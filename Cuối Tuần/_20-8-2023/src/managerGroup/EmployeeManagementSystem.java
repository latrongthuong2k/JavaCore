package managerGroup;

import model.*;
import model.exceptionCase.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class EmployeeManagementSystem {
    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public EmployeeManagementSystem() {
    }

    // edit
    public void editEmployee(Scanner scanner) throws IdException, PhoneException, FullNameException, EmailException, BirthDayException {
        for (Employee emp : employees) {
            if (inputID(scanner) == emp.getID()) {
                emp.inPutData(scanner);
                System.out.println("sửa thành công");
                break;
            }
        }
    }

    // delete
    public void deleteEmployee(Scanner scanner) throws IdException {
        for (Employee emp : employees) {
            if (inputID(scanner) == emp.getID()) {
                employees.remove(emp);
                if (employees.isEmpty())
                    break;
                System.out.println("Xoá thành công");
            }
        }
    }

    public int inputID(Scanner scanner) throws IdException {
        System.out.println("Nhập id");
        int id = -1;
        try {
            String input = scanner.nextLine();
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IdException("Id phải là số");
        }
        return id;
    }

    // add
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void sortByFullName() {
        employees.sort(Comparator.comparing(Employee::getFullName));
    }

    public void sortByBirthday() {
        employees.sort(Comparator.comparing(Employee::getBirthDay).reversed());
    }

    public void showCertificate(Scanner scanner) {
        System.out.println("Nhập id nhân viên cần hiển thị: ");
        int id = scanner.nextInt();
        for (Employee e : employees) {
            if (e.getID() == id) {
                List<Certificate> list = e.getCertificates();
                for (Certificate ct : list) {
                    System.out.printf("%s-20 %s-20 %s-20 %s-20 \n",
                            ct.getCertificatedID(),
                            ct.getCertificateName(),
                            ct.getCertificatedDate(),
                            ct.getCertificateRank());
                }
            }
        }
    }

//    public class BirthdayException extends Exception {
//        public BirthdayException(String message) {
//            super(message);
//        }
//    }
//
//    public class EmailException extends Exception {
//        public EmailException(String message) {
//            super(message);
//        }
//    }
//
//    public class PhoneException extends Exception {
//        public PhoneException(String message) {
//            super(message);
//        }
//    }
//
//    public class Validator {
//        public void validateBirthday(String birthday) throws BirthdayException {
//            if (!isValidBirthday(birthday)) {
//                throw new BirthdayException("Invalid ");
//            }
//        }
//
//        public void validateEmail(String email) throws EmailException {
//            if (!isValidEmail(email)) {
//                throw new EmailException("Invalid ");
//            }
//        }
//
//        public void validatePhone(String phone) throws PhoneException {
//            if (!isValidPhone(phone)) {
//                throw new PhoneException("Invalid phone");
//            }
//        }
//
//        private boolean isValidBirthday(String birthday) {
//            // logic validate
//            return true;
//        }
//
//        private boolean isValidEmail(String email) {
//            // logic validate
//
//            return true;
//        }
//
//        private boolean isValidPhone(String phone) {
//            // logic validate
//
//            return true;
//        }
//    }
//
//    public class Main {
//        public static void main(String[] args) {
//            Validator validator = new Validator();
//
//            try {
//                validator.validateBirthday("2000-01-01");
//                validator.validateEmail("user@example.com");
//                validator.validatePhone("1234567890");
//            } catch (BirthdayException | ArithmeticException | EmailException | PhoneException e) {
//                System.out.println("Error: " + e.getMessage());
//            }
//        }
//    }
}


