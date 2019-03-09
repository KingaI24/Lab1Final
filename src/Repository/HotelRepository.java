package Repository;

import Domain.Room;
import Domain.RoomValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HotelRepository {

    private Map<Integer, Room> storage = new HashMap<>();
    private RoomValidator validator;

    /**
     *
     * @param validator that will check conformity of input
     */
    public HotelRepository(RoomValidator validator) {
        this.validator=validator;
    }

    /**
     *
     * @param add input as per Map characteristics
     */
    public void add(Room r) {
        if (storage.containsKey(r.getId())){
            throw new RuntimeException("used reservation ID number");
        }
        validator.validate(r);
        storage.put(r.getId(),r);
    }

    /**
     *
     * @param modify input if necessary - in case of checkout
     */
    public void modify(Room r) {
        if (!storage.containsKey(r.getId())) {
            throw new RuntimeException("reservation ID not found");
        }
        validator.validate(r);
        storage.put(r.getId(),r);
    }

    /**
     *
     * @return list of room numbers
     */
    public ArrayList<Room> showAll() {
        return new ArrayList<>(storage.values());
    }
}
