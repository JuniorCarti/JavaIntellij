import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataTypes {
    // Non-primitive: Custom Class
    static class Matatu {
        // Primitive fields
        private int vehicleId;
        private byte routeNumber;
        private short capacity;
        private float fare;
        private boolean hasWifi;

        // Non-primitive fields
        private String driverName;
        private String[] commonStops;
        private ArrayList<String> currentPassengers;

        // Constructor
        public Matatu(int vehicleId, byte routeNumber, short capacity, float fare,
                      boolean hasWifi, String driverName, String[] commonStops) {
            this.vehicleId = vehicleId;
            this.routeNumber = routeNumber;
            this.capacity = capacity;
            this.fare = fare;
            this.hasWifi = hasWifi;
            this.driverName = driverName;
            this.commonStops = commonStops;
            this.currentPassengers = new ArrayList<>();
        }

        // Methods
        public void boardPassenger(String passengerName) {
            if(currentPassengers.size() < capacity) {
                currentPassengers.add(passengerName);
                System.out.println(passengerName + " boarded matatu " + vehicleId);
            } else {
                System.out.println("Matatu is full! " + passengerName + " cannot board.");
            }
        }

        public float calculateDailyRevenue(int trips) {
            return fare * capacity * trips;
        }

        public void displayInfo() {
            System.out.println("\n--- Matatu " + vehicleId + " Details ---");
            System.out.println("Route: " + routeNumber);
            System.out.println("Driver: " + driverName);
            System.out.println("Capacity: " + capacity + " passengers");
            System.out.println("Fare: KES " + fare);
            System.out.println("Wifi: " + (hasWifi ? "Available" : "Not Available"));
            System.out.println("Common Stops: " + String.join(", ", commonStops));
            System.out.println("Current Passengers: " + currentPassengers.size());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Primitive variables for system control
        boolean systemRunning = true;
        char userChoice;

        // Non-primitive collections
        HashMap<Integer, Matatu> fleet = new HashMap<>();
        ArrayList<String> popularRoutes = new ArrayList<>();

        // Initialize with sample data
        String[] route14Stops = {"CBD", "Kinoo", "Kikuyu", "Uthiru"};
        Matatu matatu1 = new Matatu(1, (byte)14, (short)14, 100.0f, true,
                "Kamau", route14Stops);

        String[] route23Stops = {"CBD", "Donholm", "Pipeline", "Utawala"};
        Matatu matatu2 = new Matatu(2, (byte)23, (short)18, 80.0f, false,
                "Nyambura", route23Stops);

        fleet.put(1, matatu1);
        fleet.put(2, matatu2);

        popularRoutes.add("Ngong Road");
        popularRoutes.add("Thika Road");
        popularRoutes.add("Mombasa Road");

        // Main system loop
        while(systemRunning) {
            System.out.println("\n===== MATATU SACCO MANAGEMENT SYSTEM =====");
            System.out.println("1. Add New Matatu");
            System.out.println("2. Board Passengers");
            System.out.println("3. View Fleet Details");
            System.out.println("4. Calculate Daily Revenue");
            System.out.println("5. View Popular Routes");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            userChoice = scanner.next().charAt(0);
            scanner.nextLine(); // Consume newline

            switch(userChoice) {
                case '1':
                    // Add new matatu
                    System.out.print("Enter Vehicle ID (int): ");
                    int id = scanner.nextInt();

                    System.out.print("Enter Route Number (1-127): ");
                    byte route = scanner.nextByte();

                    System.out.print("Enter Capacity (short): ");
                    short cap = scanner.nextShort();

                    System.out.print("Enter Fare (float): ");
                    float fare = scanner.nextFloat();

                    System.out.print("Has Wifi? (true/false): ");
                    boolean wifi = scanner.nextBoolean();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Driver Name: ");
                    String driver = scanner.nextLine();

                    System.out.print("Enter Common Stops (comma separated): ");
                    String[] stops = scanner.nextLine().split(",");

                    Matatu newMatatu = new Matatu(id, route, cap, fare, wifi, driver, stops);
                    fleet.put(id, newMatatu);
                    System.out.println("Matatu added successfully!");
                    break;

                case '2':
                    // Board passengers
                    System.out.print("Enter Matatu ID: ");
                    int matatuId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if(fleet.containsKey(matatuId)) {
                        System.out.print("Enter Passenger Name: ");
                        String passenger = scanner.nextLine();
                        fleet.get(matatuId).boardPassenger(passenger);
                    } else {
                        System.out.println("Matatu not found!");
                    }
                    break;

                case '3':
                    // View fleet
                    System.out.println("\n=== FLEET DETAILS ===");
                    for(Matatu matatu : fleet.values()) {
                        matatu.displayInfo();
                    }
                    break;

                case '4':
                    // Calculate revenue
                    System.out.print("Enter Matatu ID: ");
                    int mId = scanner.nextInt();
                    System.out.print("Enter Number of Trips: ");
                    int trips = scanner.nextInt();

                    if(fleet.containsKey(mId)) {
                        float revenue = fleet.get(mId).calculateDailyRevenue(trips);
                        System.out.printf("Estimated Daily Revenue: KES %,.2f%n", revenue);
                    } else {
                        System.out.println("Matatu not found!");
                    }
                    break;

                case '5':
                    // Popular routes
                    System.out.println("\nMost Popular Routes in Nairobi:");
                    for(int i = 0; i < popularRoutes.size(); i++) {
                        System.out.println((i+1) + ". " + popularRoutes.get(i));
                    }
                    break;

                case '6':
                    systemRunning = false;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
}