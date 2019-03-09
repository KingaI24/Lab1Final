package UI;

import Domain.Room;
import Domain.RoomPerAverageRating;
import Service.HotelService;

import java.util.Scanner;

public class Console {
    private HotelService service;
    private Scanner scanner;

    public Console(HotelService service) {
        this.service = service;
        scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Book in");
        System.out.println("2. Book out");
        System.out.println("3. Show rooms by average rating");
        System.out.println("4. Show all rooms");
        System.out.println("0. EXIT");
    }

    public void run() {

        while (true) {
            showMenu();
            String option = scanner.nextLine();
            if (option.equals("1")) {
                bookRoom();
            } else if (option.equals("2")) {
                leaveRoom();
            } else if (option.equals("3")) {
                showRoomsByRating();
            } else if (option.equals("4")) {
                showRooms();
            } else if (option.equals("0")) {
                break;
            }
        }
        System.out.println("Application was closed");
    }

    private void bookRoom() {
        try {
            System.out.println("Reservation ID:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Number of guests:");
            int guests = Integer.parseInt(scanner.nextLine());
            System.out.println("Room number:");
            int no = Integer.parseInt(scanner.nextLine());
            System.out.println("Number of days:");
            int days = Integer.parseInt(scanner.nextLine());
            service.checkIn(id, guests, no, days);
        } catch (RuntimeException runtimeException) {
            System.out.println("Input error: " + runtimeException.getMessage());
        }
    }

    private void leaveRoom() {
        try {
            System.out.println("Room number:");
            int no = Integer.parseInt(scanner.nextLine());
            System.out.println("Feedback:");
            String feedback = scanner.nextLine();
            System.out.println("Rating:");
            int rating = Integer.parseInt(scanner.nextLine());
            service.checkOut(no, feedback, rating);
        } catch (RuntimeException runtimeException) {
            System.out.println("Input error: " + runtimeException.getMessage());
        }
    }

    private void showRoomsByRating() {
        for (RoomPerAverageRating averageRating : service.roomsByRating())
            System.out.println(averageRating);

    }

    private void showRooms() {
        for (Room r : service.showAll())
            System.out.println(r);
    }
}