package Service;

import Domain.Room;
import Domain.RoomPerAverageRating;
import Repository.HotelRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HotelService {

    private HotelRepository repository;

    /**
     *
     * @param repository
     */
    public HotelService(HotelRepository repository) {
        this.repository=repository;
    }

    /**
     *
     * @param id - room ID
     * @param guests - number of guests
     * @param no - room number
     * @param days - number of days
     *             check in with the condition that room is not occupied
     */
    public void checkIn(int id, int guests, int no, int days) {
        Room room = new Room(id,guests,no,days);
        List<Room> rooms = repository.showAll();
        for (Room r : rooms) {
            if (r.getNo() == no && !r.isFree()) {
                throw new RuntimeException("room already booked");
            }
        }
        repository.add(room);
    }

    /**
     *
     * @param no - room number
     * @param feedback - mandatory text
     * @param rating - rating 1-5
     *               condition: existing booking
     */
    public void checkOut(int no,String feedback,int rating) {
        Room booking = null;
        List<Room> rooms = repository.showAll();
        for (Room r : rooms) {
            if (r.getNo() == no && !r.isFree()) {
                booking = r;
            }
        }

        if (booking != null) {
            booking.setFeedback(feedback);
            booking.setRating(rating);
            booking.setFree(true);
            repository.modify(booking);
        } else {
            throw new RuntimeException("the room was not booked");
        }
    }

    /**
     *
     * @return list of average rating per room in descendent order
     * handling data by using a Map of Lists
     */
    public List<RoomPerAverageRating> roomsByRating() {
        List<RoomPerAverageRating> results = new ArrayList<>();
        HashMap<Integer, List<Double>> roomRatings = new HashMap<>();

        for (Room r : repository.showAll()) {
            if (r.isFree()) {
                int no = r.getNo();
                double rating = r.getRating();

                if (!roomRatings.containsKey(no)) {
                    roomRatings.put(no, new ArrayList<>());
                }
                roomRatings.get(no).add(rating);
            }
        }

        for (int no : roomRatings.keySet()) {
            List<Double> ratings = roomRatings.get(no);
            double average = 0;
            for (double r : ratings) {
                average += r;
            }
            average /= ratings.size();
            results.add(new RoomPerAverageRating(no, average));
        }

        results.sort((r1, r2) -> {
            if (r1.getAverageRating() > r2.getAverageRating())
                return -1;
            else if (r1.getAverageRating() == r2.getAverageRating())
                return 0;
            else
                return 1;
        });

        return results;
    }

    public List<Room> showAll() {
        return repository.showAll();
    }
}