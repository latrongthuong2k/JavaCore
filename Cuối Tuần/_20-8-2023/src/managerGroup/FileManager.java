package managerGroup;

import model.Employee;
import model.Experience;
import model.Fresher;
import model.Intern;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public void readData(String filePath, List<Employee> employeeList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            Employee employee = new Employee();

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Id: ")) {
                    employee.setID(Integer.parseInt(line.substring(4).trim()));
                }
                if (line.startsWith("Name: ")) {
                    employee.setFullName(line.substring(6).trim());
                }
                if (line.startsWith("Birthday: ")) {
                    employee.setBirthDay(line.substring(10).trim());
                }
                if (line.startsWith("Phone: ")) {
                    employee.setPhone(line.substring(7).trim());
                }
                if (line.startsWith("Email: ")) {
                    employee.setEmail(line.substring(7).trim());
                } else if (line.trim().isEmpty()) {

                    employeeList.add(employee);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public void writeFileEmployee(List<Employee> employeeList, String targetPath) {
        if (employeeList != null) {

            String folderPath = targetPath;
            for (Employee em : employeeList) {

            }

            try (PrintWriter writer = new PrintWriter(targetPath)) {
                for (Employee employee : employeeList) {

                    if (employee instanceof Experience) {
                        writer.println(employee);
                    }
                    // fresher
                    if (employee instanceof Fresher) {
                        writer.println(employee);
                    }
                    // intern
                    if (employee instanceof Intern) {
                        writer.println(employee);
                    }

                    writer.println();
                }
            } catch (IOException e) {
                System.out.println("Error saving to file: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }
    }
}
