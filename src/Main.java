import Domain.RoomValidator;
import Repository.HotelRepository;
import Service.HotelService;
import UI.Console;

public class Main {

    public static void main(String[] args) {
        RoomValidator validator = new RoomValidator();
        HotelRepository repository = new HotelRepository(validator);
        HotelService service = new HotelService(repository);
        service.checkIn(1, 4, 23, 2);
        service.checkIn(2, 2, 12, 3);
        service.checkIn(3, 1, 21, 1);
        service.checkOut(21, "foarte curat", 5);
        service.checkIn(4, 2, 11, 3);
        service.checkOut(23, "mic", 2);
        service.checkOut(11, "ok", 4);
        service.checkIn(5, 1, 11, 1);
        service.checkIn(6, 1, 23, 1);
        service.checkOut(11, "ok", 3);
        service.checkOut(12, "ok", 5);
        service.checkOut(23, "ok", 4);
        Console console = new Console(service);
        console.run();
    }
}
