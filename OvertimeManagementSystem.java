import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

class Attendance {
    String date;   //  DATE FOR DAY BY DAY
    String status; // PRESENT / OFF / LEAVE
    String shift;  // MORNING / EVENING
    LocalTime inTime;
    LocalTime outTime;

    double overtimeHours;
    double overtimeAmount;

    public Attendance(String date, String status, String shift,
                        LocalTime inTime, LocalTime outTime) {

        this.date = date;
        this.status = status;
        this.shift = shift;
        this.inTime = inTime;
        this.outTime = outTime;

        calculateOvertime();
    }

    public void calculateOvertime() {

        // OFF or LEAVE = blank overtime
        if(status.equalsIgnoreCase("OFF") ||
            status.equalsIgnoreCase("LEAVE")) {

            overtimeHours = 0;
            overtimeAmount = 0;
            return;
        }

        long workedMinutes =
                Duration.between(inTime, outTime).toMinutes();

        double workedHours = workedMinutes / 60.0;

        double requiredHours = 0;

        // Shift working hours
        if(shift.equalsIgnoreCase("MORNING")) {
            requiredHours = 9.5;
        }
        else if(shift.equalsIgnoreCase("EVENING")) {
            requiredHours = 9.0;
        }

        // Overtime calculation
        if(workedHours > requiredHours) {
            overtimeHours = workedHours - requiredHours;
        }
        else {
            overtimeHours = 0;
        }

        overtimeAmount = overtimeHours * 50;
    }
}

class Employee {

    int empId;
    String name;

    ArrayList<Attendance> records = new ArrayList<>();

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public void addAttendance(Attendance attendance) {
        records.add(attendance);
    }

    public double calculateMonthlyOTAmount() {

        double total = 0;

        for(Attendance a : records) {
            total += a.overtimeAmount;
        }

        return total;
    }

    public void displayReport() {

        System.out.println("\n=================================");
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.println("=================================");

        System.out.printf("%-12s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "Date", "Status", "Shift", "IN", "OUT",
                "OT Hrs", "OT Amt");

        for(Attendance a : records) {

            String in = (a.inTime != null) ? a.inTime.toString() : "-";
            String out = (a.outTime != null) ? a.outTime.toString() : "-";

            System.out.printf("%-12s %-10s %-10s %-10s %-10s %-10.2f %-10.2f\n",
                    a.date,
                    a.status,
                    a.shift,
                    in,
                    out,
                    a.overtimeHours,
                    a.overtimeAmount);
        }

        System.out.println("---------------------------------");
        System.out.println("Total OT Amount : ₹" + calculateMonthlyOTAmount());
        System.out.println("=================================\n");
    }
}

public class OvertimeManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int empCount = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < empCount; i++) {

            System.out.println("\nEnter Employee Details");

            System.out.print("Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Employee Name: ");
            String name = sc.nextLine();

            Employee emp = new Employee(id, name);

            System.out.print("How many attendance records? ");
            int days = sc.nextInt();
            sc.nextLine();

            for(int j = 0; j < days; j++) {

                System.out.println("\nRecord " + (j + 1));

                System.out.print("Date (DD-MM-YYYY): ");
                String date = sc.nextLine();

                System.out.print("Status (PRESENT/OFF/LEAVE): ");
                String status = sc.nextLine();

                String shift = "";
                LocalTime inTime = null;
                LocalTime outTime = null;

                // Only ask time if PRESENT
                if(status.equalsIgnoreCase("PRESENT")) {

                    System.out.print("Shift (MORNING/EVENING): ");
                    shift = sc.nextLine();

                    System.out.print("IN Time (HH:MM): ");
                    inTime = LocalTime.parse(sc.nextLine());

                    System.out.print("OUT Time (HH:MM): ");
                    outTime = LocalTime.parse(sc.nextLine());
                }

                Attendance attendance =
                        new Attendance(date, status,
                                shift, inTime, outTime);

                emp.addAttendance(attendance);
            }

            employees.add(emp);
        }

        // Display all reports
        System.out.println("\n\n========= MONTHLY REPORT =========");

        for(Employee e : employees) {
            e.displayReport();
        }

        sc.close();
    }
}