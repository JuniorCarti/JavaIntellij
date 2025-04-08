import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FarmersCooperativeSystem {
    // Non-primitive: Custom Class for Farmer
    static class Farmer {
        // Primitive fields
        private int farmerId;
        private byte familySize;
        private short yearsInCooperative;
        private float landSize; // in acres
        private boolean hasOrganicCertification;

        // Non-primitive fields
        private String name;
        private String county;
        private ArrayList<String> crops;
        private HashMap<String, Double> harvestRecords; // crop -> yield (kg)

        // Constructor
        public Farmer(int farmerId, String name, String county, byte familySize,
                      short yearsInCooperative, float landSize, boolean hasOrganicCertification) {
            this.farmerId = farmerId;
            this.name = name;
            this.county = county;
            this.familySize = familySize;
            this.yearsInCooperative = yearsInCooperative;
            this.landSize = landSize;
            this.hasOrganicCertification = hasOrganicCertification;
            this.crops = new ArrayList<>();
            this.harvestRecords = new HashMap<>();
        }

        // Methods
        public void addCrop(String crop) {
            if (!crops.contains(crop)) {
                crops.add(crop);
                System.out.println(crop + " added to " + name + "'s farm");
            }
        }

        public void recordHarvest(String crop, double yield) {
            harvestRecords.put(crop, yield);
            System.out.printf("Recorded %.2f kg of %s for %s%n", yield, crop, name);
        }

        public double calculateAnnualIncome(HashMap<String, Double> marketPrices) {
            double total = 0.0;
            for (String crop : harvestRecords.keySet()) {
                if (marketPrices.containsKey(crop)) {
                    total += harvestRecords.get(crop) * marketPrices.get(crop);
                }
            }
            return total;
        }

        public void displayProfile() {
            System.out.println("\n--- Farmer Profile ---");
            System.out.println("ID: " + farmerId);
            System.out.println("Name: " + name);
            System.out.println("County: " + county);
            System.out.println("Family Size: " + familySize);
            System.out.println("Years in Cooperative: " + yearsInCooperative);
            System.out.println("Land Size: " + landSize + " acres");
            System.out.println("Organic Certified: " + (hasOrganicCertification ? "Yes" : "No"));
            System.out.println("Crops Grown: " + String.join(", ", crops));
            System.out.println("Harvest Records: " + harvestRecords);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Primitive variables for system control
        boolean systemRunning = true;
        char userChoice;

        // Non-primitive collections
        HashMap<Integer, Farmer> farmers = new HashMap<>();
        HashMap<String, Double> currentMarketPrices = new HashMap<>();
        ArrayList<String> commonKenyanCrops = new ArrayList<>();

        // Initialize with sample data
        Farmer farmer1 = new Farmer(1, "Wanjiku Mwangi", "Kiambu", (byte)5, (short)3, 2.5f, true);
        farmer1.addCrop("Coffee");
        farmer1.addCrop("Bananas");
        farmer1.recordHarvest("Coffee", 150.5);
        farmer1.recordHarvest("Bananas", 320.0);

        Farmer farmer2 = new Farmer(2, "Kamau Kariuki", "Nakuru", (byte)7, (short)5, 4.0f, false);
        farmer2.addCrop("Maize");
        farmer2.addCrop("Beans");
        farmer2.recordHarvest("Maize", 450.0);
        farmer2.recordHarvest("Beans", 120.5);

        farmers.put(1, farmer1);
        farmers.put(2, farmer2);

        currentMarketPrices.put("Coffee", 50.0);  // KES per kg
        currentMarketPrices.put("Bananas", 20.0);
        currentMarketPrices.put("Maize", 30.0);
        currentMarketPrices.put("Beans", 80.0);

        commonKenyanCrops.add("Coffee");
        commonKenyanCrops.add("Tea");
        commonKenyanCrops.add("Maize");
        commonKenyanCrops.add("Beans");
        commonKenyanCrops.add("Bananas");
        commonKenyanCrops.add("Avocado");

        // Main system loop
        while (systemRunning) {
            System.out.println("\n===== KENYAN FARMERS COOPERATIVE SYSTEM =====");
            System.out.println("Today's Date: " + LocalDate.now());
            System.out.println("1. Register New Farmer");
            System.out.println("2. Add Crop to Farmer");
            System.out.println("3. Record Harvest");
            System.out.println("4. View Farmer Profiles");
            System.out.println("5. Calculate Farmer Income");
            System.out.println("6. Update Market Prices");
            System.out.println("7. View Common Kenyan Crops");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            userChoice = scanner.next().charAt(0);
            scanner.nextLine(); // Consume newline

            switch (userChoice) {
                case '1':
                    // Register new farmer
                    System.out.print("Enter Farmer ID (int): ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter County: ");
                    String county = scanner.nextLine();

                    System.out.print("Enter Family Size (1-127): ");
                    byte familySize = scanner.nextByte();

                    System.out.print("Enter Years in Cooperative (short): ");
                    short years = scanner.nextShort();

                    System.out.print("Enter Land Size (acres, float): ");
                    float landSize = scanner.nextFloat();

                    System.out.print("Organic Certified? (true/false): ");
                    boolean organic = scanner.nextBoolean();
                    scanner.nextLine();

                    Farmer newFarmer = new Farmer(id, name, county, familySize, years, landSize, organic);
                    farmers.put(id, newFarmer);
                    System.out.println("Farmer registered successfully!");
                    break;

                case '2':
                    // Add crop to farmer
                    System.out.print("Enter Farmer ID: ");
                    int fId = scanner.nextInt();
                    scanner.nextLine();

                    if (farmers.containsKey(fId)) {
                        System.out.print("Enter Crop to Add: ");
                        String crop = scanner.nextLine();
                        farmers.get(fId).addCrop(crop);

                        if (!commonKenyanCrops.contains(crop)) {
                            commonKenyanCrops.add(crop);
                            System.out.println(crop + " added to common crops list");
                        }
                    } else {
                        System.out.println("Farmer not found!");
                    }
                    break;

                case '3':
                    // Record harvest
                    System.out.print("Enter Farmer ID: ");
                    int farmerId = scanner.nextInt();
                    scanner.nextLine();

                    if (farmers.containsKey(farmerId)) {
                        System.out.print("Enter Crop: ");
                        String crop = scanner.nextLine();

                        System.out.print("Enter Yield (kg): ");
                        double yield = scanner.nextDouble();

                        farmers.get(farmerId).recordHarvest(crop, yield);
                    } else {
                        System.out.println("Farmer not found!");
                    }
                    break;

                case '4':
                    // View profiles
                    System.out.println("\n=== FARMER PROFILES ===");
                    for (Farmer farmer : farmers.values()) {
                        farmer.displayProfile();
                    }
                    break;

                case '5':
                    // Calculate income
                    System.out.print("Enter Farmer ID: ");
                    int fid = scanner.nextInt();

                    if (farmers.containsKey(fid)) {
                        double income = farmers.get(fid).calculateAnnualIncome(currentMarketPrices);
                        System.out.printf("Estimated Annual Income: KES %,.2f%n", income);
                    } else {
                        System.out.println("Farmer not found!");
                    }
                    break;

                case '6':
                    // Update market prices
                    System.out.print("Enter Crop Name: ");
                    String crop = scanner.nextLine();

                    System.out.print("Enter New Price (KES per kg): ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    currentMarketPrices.put(crop, price);
                    System.out.println("Market price updated for " + crop);
                    break;

                case '7':
                    // View common crops
                    System.out.println("\nCommon Kenyan Crops:");
                    for (int i = 0; i < commonKenyanCrops.size(); i++) {
                        System.out.println((i + 1) + ". " + commonKenyanCrops.get(i));
                    }
                    break;

                case '8':
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