public class Roomsearch {

    // =======================
    // Room Class
    // =======================
    static class Room {
        private String type;
        private double price;
        private int availableCount;

        public Room(String type, double price, int availableCount) {
            this.type = type;
            this.price = price;
            this.availableCount = availableCount;
        }

        public String getType() {
            return type;
        }

        public double getPrice() {
            return price;
        }

        public int getAvailableCount() {
            return availableCount;
        }
    }

    // =======================
    // RoomInventory Class
    // =======================
    static class RoomInventory {

        public boolean isAvailable(Room room) {
            return room.getAvailableCount() > 0;
        }
    }

    // =======================
    // RoomSearchService Class
    // =======================
    static class RoomSearchService {

        public void searchAvailableRooms(
                RoomInventory inventory,
                Room singleRoom,
                Room doubleRoom,
                Room suiteRoom) {

            System.out.println("=== Available Rooms ===\n");

            displayRoom(inventory, singleRoom);
            displayRoom(inventory, doubleRoom);
            displayRoom(inventory, suiteRoom);
        }

        private void displayRoom(RoomInventory inventory, Room room) {
            if (inventory.isAvailable(room)) {
                System.out.println("Room Type: " + room.getType());
                System.out.println("Price: ₹" + room.getPrice());
                System.out.println("Available: " + room.getAvailableCount());
                System.out.println("------------------------");
            } else {
                System.out.println("Room Type: " + room.getType() + " is NOT available");
                System.out.println("------------------------");
            }
        }
    }

    // =======================
    // MAIN METHOD
    // =======================
    public static void main(String[] args) {

        // Create Room Objects
        Room singleRoom = new Room("Single Room", 2000, 3);
        Room doubleRoom = new Room("Double Room", 3500, 0);
        Room suiteRoom = new Room("Suite Room", 6000, 2);

        // Create Inventory
        RoomInventory inventory = new RoomInventory();

        // Create Service
        RoomSearchService service = new RoomSearchService();

        // Call Search Function
        service.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}