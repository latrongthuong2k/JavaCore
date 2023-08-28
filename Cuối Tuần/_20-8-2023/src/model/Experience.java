package model;

import model.exceptionCase.*;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Experience extends Employee {
    private int expInYear;
    private String proSkill;


    public Experience() throws PhoneException, FullNameException, EmailException, BirthDayException, IdException {
        expInYear = 0;
        proSkill = "";
    }

    @Override
    public void inPutData(Scanner scanner) throws BirthDayException, FullNameException, PhoneException, EmailException, IdException {
        super.inPutData(scanner);
        do {
            try {
                if (this.expInYear != 0) {
                    System.out.println("Nhập số năm kinh nghiệm");
                    int year;
                    year = scanner.nextInt();
                    if (year < 20 && year > 2) {
                        this.expInYear = year;
                    } else
                        throw new InputMismatchException("Ngày không hợp lệ");
                }
                if (!this.proSkill.isEmpty()) {
                    proSkill = scanner.nextLine();
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
                "expInYear :" + expInYear + '\'' +
                "proSkill :" + proSkill + '\'';
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}