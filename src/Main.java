import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        Department department = new Department(departmentName);

        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Level: ");
        WorkerLevel level = WorkerLevel.valueOf(sc.nextLine());

        System.out.print("Base salary: ");
        double baseSalary = sc.nextInt();

        Worker worker = new Worker(name, level, baseSalary, department);

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter contract #%d: %n", i + 1);
            System.out.print("Date (DD/MM/YYYY): ");
            Date date = sdf.parse(sc.next());

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            HourContract contract = new HourContract(date, valuePerHour, hours);
            worker.addContract(contract);
        };

        System.out.print("Enter month and year to calculate in come (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + worker.income(year, month));

        sc.close();
    }
}