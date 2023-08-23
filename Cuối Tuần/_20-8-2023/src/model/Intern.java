package model;

import model.exceptionCase.*;


public class Intern extends Employee {
    private String majors;
    private String semester;
    private String universityName;

    public Intern() throws PhoneException, FullNameException, EmailException, BirthDayException, IdException {
    }


    @Override
    public String toString() {
        return super.toString() +
                "majors :" + majors + '\'' +
                "semester :" + semester + '\'' +
                "universityName :" + universityName + '\'';
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}