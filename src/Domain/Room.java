package Domain;

public class Room {
    private int id, guests, no, days, rating;
    private String feedback;
    private boolean free;

    public Room(int id, int guests, int no, int days) {
        this.id = id;
        this.guests = guests;
        this.no = no;
        this.days = days;
    }

    public Room(int id, int guests, int no, int days, int rating, String feedback) {
        this.id = id;
        this.guests = guests;
        this.no = no;
        this.days = days;
        this.rating = rating;
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", guests=" + guests +
                ", no=" + no +
                ", days=" + days +
                ", rating=" + rating +
                ", feedback='" + feedback + '\'' +
                ", free=" + free +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getGuests() {
        return guests;
    }

    public int getNo() {
        return no;
    }

    public int getDays() {
        return days;
    }

    public int getRating() {
        return rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public boolean isFree() {
        return free;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}