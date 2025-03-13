import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class HotelRoom {
    private int roomNumber;
    private boolean isAvailable;

    public HotelRoom(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Room " + roomNumber + " has been successfully booked.");
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

    public void cancelBooking() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Room " + roomNumber + " booking has been canceled.");
        } else {
            System.out.println("Room " + roomNumber + " is already available.");
        }
    }
}

class HotelReservationSystem {
    private Map<Integer, HotelRoom> rooms;

    public HotelReservationSystem(int totalRooms) {
        rooms = new HashMap<>();
        for (int i = 1; i <= totalRooms; i++) {
            rooms.put(i, new HotelRoom(i));
        }
    }

    public void showAvailableRooms() {
        System.out.println("Available Rooms:");
        for (HotelRoom room : rooms.values()) {
            if (room.isAvailable()) {
                System.out.println("Room Number: " + room.getRoomNumber());
            }
        }
    }

    public void bookRoom(int roomNumber) {
        HotelRoom room = rooms.get(roomNumber);
        if (room != null) {
            room.bookRoom();
        } else {
            System.out.println("Invalid room number.");
        }
    }

    public void cancelBooking(int roomNumber) {
        HotelRoom room = rooms.get(roomNumber);
        if (room != null) {
            room.cancelBooking();
        } else {
            System.out.println("Invalid room number.");
        }
    }

    public void showBookings() {
        System.out.println("Current Bookings:");
        for (HotelRoom room : rooms.values()) {
            String status = room.isAvailable() ? "Available" : "Booked";
            System.out.println("Room Number: " + room.getRoomNumber() + " - " + status);
        }
    }
}

public class HotelReservationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize hotel system with 10 rooms
        HotelReservationSystem hotel = new HotelReservationSystem(10);

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Show Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Show All Bookings");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.showAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int bookRoom = scanner.nextInt();
                    hotel.bookRoom(bookRoom);
                    break;
                case 3:
                    System.out.print("Enter room number to cancel booking: ");
                    int cancelRoom = scanner.nextInt();
                    hotel.cancelBooking(cancelRoom);
                    break;
                case 4:
                    hotel.showBookings();
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
