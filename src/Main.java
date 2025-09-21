import Entities.Department;
import Entities.Enum.WorkerLevel;
import Entities.HourContract;
import Entities.Worker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        System.out.print("Enter department´s name: ");
        String department = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name:");
        String name = sc.nextLine();
        System.out.print("Level: ");
        String level = sc.nextLine();
        System.out.print("Base Salary: ");
        double salary = sc.nextDouble();
        Worker worker = new Worker(name, WorkerLevel.valueOf(level), salary, new Department(department) );

        System.out.print("How many contracts to this worker? ");
        int x = sc.nextInt();

        for (int i = 0; i < x; i++){
            System.out.println("Enter contractt #" + i + " data: ");
            System.out.println("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.println("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.println("Duration: ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println("Enter month and year to calculate income (MM/YYYY):  ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format( "%.2f",worker.income(year, month)));



        sc.close();
    }
}