package Domain;

public class RoomValidator {

    /**
     *
     * @param r is the variable to validate
     * @throws RuntimeException in case of input errors
     */

    public void validate(Room r) {

        if (r.getDays() <= 0) {
            throw new RuntimeException("error in day input (negative value)");
        }

        if ((r.isFree()) && ((r.getRating() < 1 ) || (r.getRating() > 5 ))){
            throw new RuntimeException("error in rating input (should be between 1-5)");
        }

        if ((r.isFree()) && (r.getFeedback().equals("") || r.getFeedback().equals(null))) {
            throw new RuntimeException("please give feedback");
        }
    }
}
