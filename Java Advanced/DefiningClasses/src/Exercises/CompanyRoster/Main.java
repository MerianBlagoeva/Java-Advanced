package Exercises.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int countOfEmployees = Integer.parseInt(sc.nextLine());
        List<Employee> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        for (int i = 0; i < countOfEmployees; i++) {
            String[] data = sc.nextLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String employeeDepartment = data[3];

            Employee employee = null;

            switch (data.length) {
                case 4:
                    //no email, no age
                    employee = new Employee(name, salary, position, employeeDepartment);
                    break;
                case 5:
                    //no email, but has age
                    if (data[4].contains("@")) {
                        String email = data[4];
                        employee = new Employee(name, salary, position, employeeDepartment, email);
                    } else {
                        //email and age
                        int age = Integer.parseInt(data[4]);
                        employee = new Employee(name, salary, position, employeeDepartment, age);
                    }
                    break;
                case 6:
                    //email and age
                    String email = data[4];
                    int age = Integer.parseInt(data[5]);
                    employee = new Employee(name, salary, position, employeeDepartment, email, age);
                    break;
            }
            //Do we have this department?
            //if yes - add the employee
            //else -> create the department and add the employee
            boolean departmentExists = departments.stream()
                    .anyMatch(department -> department.getName().equals(employeeDepartment));

            if (!departmentExists) {
                Department department = new Department(employeeDepartment);
                departments.add(department);
            }
            //Now we have the department

            Department currentDepartment = departments
                    .stream()
                    .filter(dep -> dep.getName().equals(employeeDepartment))
                    .findFirst()
                    .get();

            currentDepartment.getEmployees().add(employee);
        }

        //Calculate average salary - using method in Department class
        Department highestPaidDepartment = departments
                .stream()
                .max(Comparator.comparingDouble(Department::calculateAverageSalary))
                .get();

        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());
        highestPaidDepartment.getEmployees()
                .stream()
                .sorted((first, second) -> Double.compare(second.getSalary(), first.getSalary()))
                .forEach(System.out::println);

    }
}
