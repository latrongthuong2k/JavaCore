package model;

import model.exceptionCase.*;


public class Fresher extends Employee {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() throws PhoneException, FullNameException, EmailException, BirthDayException, IdException {
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

