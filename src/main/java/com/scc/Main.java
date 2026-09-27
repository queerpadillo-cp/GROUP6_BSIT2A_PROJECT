package com.scc;

import com.scc.dao.ExpenseDao;
import com.scc.dao.PassengerDao;
import com.scc.model.Expense;
import com.scc.model.Passenger;

import java.util.Scanner;

public class Main {
    private static final int MAX_SEATS = 18;
    private static int occupiedSeats = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PassengerDao passengerDao = new PassengerDao();
        ExpenseDao expenseDao = new ExpenseDao();

        int choice = 0;

        do {
            System.out.println("\n==================================================");
            System.out.println("  JEEPNEY OPERATIONS & FARE MANAGEMENT SYSTEM");
            System.out.println("  Active Seating: [" + occupiedSeats + " / " + MAX_SEATS + " Occupied]");
            System.out.println("==================================================");
            System.out.println("1. Add Passenger & Collect Fare");
            System.out.println("2. View Passenger Records");
            System.out.println("3. Reset Trip Seats (New Pasada)");
            System.out.println("4. Log Fuel Expense");
            System.out.println("5. View Financial Summary");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-6): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    if (occupiedSeats >= MAX_SEATS) {
                        System.out.println("\n[ERROR] Jeepney is full! Cannot add more passengers.");
                        break;
                    }

                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.nextLine();

                    System.out.print("Enter drop-off destination: ");
                    String destination = scanner.nextLine();

                    System.out.print("Enter travel distance (km): ");
                    double distance = scanner.nextDouble();

                    System.out.println("Select Passenger Category:");
                    System.out.println("1. Regular");
                    System.out.println("2. Student (20% Discount)");
                    System.out.println("3. Senior Citizen (20% Discount)");
                    System.out.println("4. PWD (20% Discount)");
                    System.out.print("Choice: ");
                    int categoryChoice = scanner.nextInt();
                    scanner.nextLine();

                    String category = "Regular";
                    boolean isDiscounted = false;

                    if (categoryChoice == 2) { category = "Student"; isDiscounted = true; }
                    else if (categoryChoice == 3) { category = "Senior Citizen"; isDiscounted = true; }
                    else if (categoryChoice == 4) { category = "PWD"; isDiscounted = true; }

                    // Fare calculation logic: Base = 13.00 for first 4.0 km + 1.80/extra km
                    double baseFare = 13.00;
                    double extraKmRate = 1.80;
                    double rawFare = baseFare;

                    if (distance > 4.0) {
                        double extraDistance = Math.ceil(distance - 4.0);
                        rawFare += extraDistance * extraKmRate;
                    }

                    double finalFare = isDiscounted ? (rawFare * 0.80) : rawFare;

                    passengerDao.addPassenger(new Passenger(passengerName, destination, distance, category, finalFare));
                    occupiedSeats++;

                    System.out.printf("\n[SUCCESS] Ticket Created for %s! Fare: P%.2f | Seats: %d/%d\n",
                            passengerName, finalFare, occupiedSeats, MAX_SEATS);
                    break;

                case 2:
                    System.out.println("\n------------------------------------------------------------------");
                    System.out.println("                        PASSENGER RECORDS                         ");
                    System.out.println("------------------------------------------------------------------");
                    if (passengerDao.getAllPassengers().isEmpty()) {
                        System.out.println("No passengers recorded yet.");
                    } else {
                        int index = 1;
                        for (Passenger p : passengerDao.getAllPassengers()) {
                            System.out.printf("%d. Name: %s | Dest: %s | Distance: %.1f km | Type: %s | Fare: P%.2f\n",
                                    index++, p.getPassengerName(), p.getDestination(), p.getDistance(), p.getCategory(), p.getFare());
                        }
                    }
                    break;

                case 3:
                    occupiedSeats = 0;
                    System.out.println("\n[SUCCESS] Trip reset complete! Seat count reset to 0/18.");
                    break;

                case 4:
                    System.out.print("Enter driver/conductor name logging expense: ");
                    String loggedBy = scanner.nextLine();

                    System.out.print("Enter fuel/gas expense amount (P): ");
                    double fuelAmount = scanner.nextDouble();
                    scanner.nextLine();

                    expenseDao.addExpense(new Expense("Fuel Purchase", fuelAmount, loggedBy));
                    System.out.printf("\n[SUCCESS] Logged fuel expense of P%.2f by %s\n", fuelAmount, loggedBy);
                    break;

                case 5:
                    double totalGross = passengerDao.getTotalFareRevenue();
                    double totalFuel = expenseDao.getTotalExpenses();
                    double netPay = totalGross - totalFuel;

                    System.out.println("\n==================================================");
                    System.out.println("             DAILY FINANCIAL SUMMARY              ");
                    System.out.println("==================================================");
                    System.out.printf("Total Gross Revenue:   P%.2f\n", totalGross);
                    System.out.printf("Total Fuel Expenses:   P%.2f\n", totalFuel);
                    System.out.println("--------------------------------------------------");
                    System.out.printf("Net Take-Home Pay:     P%.2f\n", netPay);
                    System.out.println("==================================================");
                    break;

                case 6:
                    System.out.println("\nExiting System. Thank you!");
                    break;

                default:
                    System.out.println("\nInvalid menu option. Please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}