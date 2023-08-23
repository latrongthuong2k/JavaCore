package model;

import model.exceptionCase.BirthDayException;
import model.exceptionCase.IdException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Certificate {
    private int certificatedID;
    private String certificateName;
    private String certificateRank;
    private String certificatedDate;

    public int getCertificatedID() {
        return certificatedID;
    }

    public void setCertificatedID(int certificatedID) {
        this.certificatedID = certificatedID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public String getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(String certificatedDate) {
        this.certificatedDate = certificatedDate;
    }

    public Certificate(Scanner scanner, List<Certificate> certificatesList) throws IdException, BirthDayException {
        inputData(scanner, certificatesList);
    }

    public void inputData(Scanner scanner, List<Certificate> certificatesList) throws IdException, BirthDayException {
        int id;
        boolean isFinished = false;
        do {
            try {
                System.out.println("Nhập mã chứng chỉ");
                id = scanner.nextInt();

                // Kiểm tra xem mã đã tồn tại hay chưa
                boolean idExists = false;
                for (Certificate ct : certificatesList) {
                    if (id == ct.getCertificatedID()) {
                        idExists = true;
                        break;
                    }
                }

                if (idExists) {
                    throw new IdException("Mã đã tồn tại !");
                } else {
                    this.certificatedID = id;
                    isFinished = true;
                }
            } catch (InputMismatchException e) {
                System.err.println("Lỗi đầu vào, xin hãy nhập lại !");
                scanner.nextLine();
            } catch (IdException e) {
                System.out.println(e.getMessage());
            }
        } while (!isFinished);

        System.out.println("Nhập tên chứng chỉ");
        this.certificateName = scanner.nextLine();
        System.out.println("Nhập rank chứng chỉ");
        this.certificateRank = scanner.nextLine();
        System.out.println("Nhập ngày đỗ chứng chỉ");
        String day;
        do {
            day = scanner.nextLine();
            if (Employee.isValidDay(day))
                throw new BirthDayException(" Ngày nhập không đúng định dạng");
            else
                this.certificatedDate = day;
        } while (Employee.isValidDay(day));
    }
}
