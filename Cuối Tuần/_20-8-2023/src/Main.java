import managerGroup.EmployeeManagementSystem;
import managerGroup.FileManager;
import model.Employee;
import model.Experience;
import model.Fresher;
import model.Intern;
import model.exceptionCase.*;

import java.io.File;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws PhoneException, FullNameException, EmailException, BirthDayException, IdException {
        /**
         * employeeManagementSystem : 管理者のオブジェクト
         * employeeList :  管理者のオブジェクトの従業員リストの参照
         */
        EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem();
        List<Employee> employeeList = employeeManagementSystem.getEmployees();
        // project path
        String projectDirectory = System.getProperty("user.dir");

        // certificate for each employee folder
        File targetDirectory = new File(projectDirectory + File.separator + "certificateListTxt");
        targetDirectory.mkdir(); // Tạo thư mục nếu chưa tồn tại


        // file path
        String path = "data.txt";
        // file manager
        FileManager fileManager = new FileManager();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("***************************MENU*************************");
            System.out.println("1. Thêm employee");
            System.out.println("2. Hiển thị employee");
            System.out.println("3. Sửa employee");
            System.out.println("4. Xoá employee");
            System.out.println("5. Hiển thị certificate theo employee");
            System.out.println("6. Xắp xếp giảm dần theo full name ");
            System.out.println("7. Xắp xếp tăng dần theo birthday");
            System.out.println("8. Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Chọn level employee : " +
                            "1. Experience \n" +
                            "2. Fresher \n" +
                            "3. Intern\n");
                    int levelSelect = scanner.nextInt();
                    scanner.nextLine();
                    switch (levelSelect) {
                        case 1 -> {
                            System.out.println("Nhập thông tin cho Experience");
                            Experience experience = new Experience();
                            experience.setEmployeeType(1);
                            experience.inPutData(scanner);
                            employeeManagementSystem.addEmployee(experience);
                            fileManager.writeFileEmployee(employeeList, path);
                        }
                        case 2 -> {
                            Fresher fresher = new Fresher();
                            fresher.setEmployeeType(2);
                            fresher.inPutData(scanner);
                            employeeManagementSystem.addEmployee(fresher);
                            fileManager.writeFileEmployee(employeeList, path);
                        }
                        case 3 -> {
                            Intern intern = new Intern();
                            intern.setEmployeeType(3);
                            intern.inPutData(scanner);
                            employeeManagementSystem.addEmployee(intern);
                            fileManager.writeFileEmployee(employeeList, path);
                        }
                    }
                }
                case 2 -> {
                    for (Employee emp : employeeList) {
                        System.out.println(emp);
                    }
                }
                case 3 -> employeeManagementSystem.editEmployee(scanner);
                case 4 -> employeeManagementSystem.showCertificate(scanner);
                case 5 -> employeeManagementSystem.deleteEmployee(scanner);
                case 6 -> employeeManagementSystem.sortByFullName();
                case 7 -> employeeManagementSystem.sortByBirthday();
            }
        }
        while (choice != 8);
    }
}