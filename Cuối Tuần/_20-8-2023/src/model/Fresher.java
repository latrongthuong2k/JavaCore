package model;

import model.exceptionCase.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Fresher extends Employee {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() throws PhoneException, FullNameException, EmailException, BirthDayException, IdException {
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void inPutData(Scanner scanner) throws BirthDayException, FullNameException, PhoneException, EmailException, IdException {
        super.inPutData(scanner);
        do {
            try {
                if (!this.graduationDate.isEmpty()) {
                    System.out.println("Nhập ngày tốt nghiệp");
                    String date;
                    date = scanner.nextLine();
                    if (Employee.isValidDay(date)) {
                        this.graduationDate = date;
                    } else
                        throw new InputMismatchException("Ngày không hợp lệ");
                }

                if (!this.graduationRank.isEmpty()) {
                    System.out.println("Nhập ngày rank tốt nghiệp");
                    graduationRank = scanner.nextLine();

                }
                if (!this.graduationRank.isEmpty()) {
                    System.out.println("Nhập khoá tốt nghiệp");
                    education = scanner.nextLine();
                }
                break;
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        } while (true);
    }

    @Override
    public String toString() {
        return super.toString() +
                "graduationDate :" + graduationDate + '\'' +
                "graduationRank :" + graduationRank + '\'' +
                "education :" + education + '\'';
    }

    // Getters and setters
}

