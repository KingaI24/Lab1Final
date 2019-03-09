package Domain;

public class RoomPerAverageRating {
    private int no;
    private double averageRating;

    public RoomPerAverageRating(int no, double averageRating) {
        this.no = no;
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {
        return "RoomPerAverageRating{" +
                "no=" + no +
                ", averageRating=" + averageRating +
                '}';
    }

    public int getNo() {
        return no;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
