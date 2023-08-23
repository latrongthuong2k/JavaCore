package model;

import model.exceptionCase.*;


public class Experience extends Employee {
    private int expInYear;
    private String proSkill;

    public Experience() throws PhoneException, FullNameException, EmailException, BirthDayException, IdException {

    }


    @Override
    public String toString() {
        return super.toString() +
                "ExpInYear :" + expInYear + '\'' +
                "ProSkill :" + proSkill + '\'';
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