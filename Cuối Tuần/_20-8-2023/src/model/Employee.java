package model;

import model.exceptionCase.*;

import java.util.*;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Employee {

    private int ID;
    private String fullName;
    private String birthDay;
    private String phone;
    private String email;
    private int employeeType;
    private int employeeCount;
    private final List<Certificate> certificates = new ArrayList<>();

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }

    /**
     * Constructor of employee
     */
    public Employee()
            throws PhoneException, FullNameException, EmailException, BirthDayException, IdException {
        Scanner scanner = new Scanner(System.in);
        inPutData(scanner);
    }

    public void inPutData(Scanner scanner)
            throws BirthDayException, FullNameException, PhoneException, EmailException, IdException {
        // Nhập id
        String input;
        int id = -1;
        do {
            System.out.println("Nhập id :");
            input = scanner.nextLine();
            try {
                id = Integer.parseInt(input);
                this.ID = id;
                break;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input, the input value must be number, Input : " + e.getMessage());
            }
        } while (true);
        String name;
        String date;
        String phoneNumber;
        String emailInput;
        do {
            try {
                // input
                System.out.println("Nhập tên :");
                name = scanner.nextLine();
                if (!isValidFullName(name)) {
                    throw new FullNameException(" Invalid name !");
                }
                // input
                System.out.println("Nhập ngày sinh :");
                date = scanner.nextLine();
                if (!isValidDay(date)) {
                    throw new BirthDayException("Invalid birth day");
                }
                // input
                System.out.println("Nhập số điện thoại:");
                phoneNumber = scanner.nextLine();
                if (!isValidPhoneNumber(phoneNumber)) {
                    throw new PhoneException("Invalid phone number");
                }
                // input
                System.out.println("Nhập email:");
                emailInput = scanner.nextLine();

                if (!isValidEmail(emailInput)) {
                    throw new EmailException("Invalid email");
                }
                // nếu không có lỗi nào được throw
                this.fullName = name;
                this.phone = phoneNumber;
                this.email = emailInput;
                this.birthDay = date;
                break; // thoát loop
            } catch (FullNameException e) {
                System.err.println("Tên nhập không hợp lệ. Vui lòng nhập lại. Error: " + e.getMessage());
            } catch (BirthDayException e) {
                System.err.println("Ngày sinh không hợp lệ. Vui lòng nhập lại. Error: " + e.getMessage());
            } catch (PhoneException e) {
                System.err.println("Số điện thoại không hợp lệ. Vui lòng nhập lại. Error: " + e.getMessage());
            } catch (EmailException e) {
                System.err.println("Email không hợp lệ. Vui lòng nhập lại. Error: " + e.getMessage());
            }
        } while (true);
        // nhập certificate
        System.out.println("Nhập certificate :");
        Certificate certificate = new Certificate(scanner, certificates);
        certificates.add(certificate);
    }

    // valid birthday
    public static boolean isValidDay(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateStr);
            Date currentDate = new Date();
            // không phải là tương lai
            return !date.after(currentDate);
        } catch (ParseException e) {
            return false;
        }
    }

    // display
    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", fullName='" + fullName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", employeeType=" + employeeType +
                ", employeeCount=" + employeeCount +
                ", certificates=" + certificates +
                '}';
    }

    public static boolean isValidPhoneNumber(String phone) {
        return !Pattern.matches("^(03|05|07|09)[0-9]{8}$", phone);
    }

    // Validate email
    public static boolean isValidEmail(String email) {

        return !Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email);
    }

    // Validate full name
    public static boolean isValidFullName(String input) throws NumberFormatException {
        boolean isInValid = true;
        int number;
        try {
            number = Integer.parseInt(input);
            isInValid = false;
        } catch (NumberFormatException e) {
            System.out.println("Ok");
        }
        return isInValid;
    }

    public void addCertificate(Certificate certificate) {
        certificates.add(certificate);
    }

    /**
     *
     */

}