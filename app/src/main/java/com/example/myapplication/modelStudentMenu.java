package com.example.myapplication;

public class modelStudentMenu {
    String days,breakfast1,breakfast2,breakfast3,lunch1,lunch2,lunch3,snacks1,snacks2,dinner1,dinner2;

    public modelStudentMenu() {
    }

    @Override
    public String toString() {
        return "modelStudentMenu{" +
                "days='" + days + '\'' +
                ", breakfast1='" + breakfast1 + '\'' +
                ", breakfast2='" + breakfast2 + '\'' +
                ", breakfast3='" + breakfast3 + '\'' +
                ", lunch1='" + lunch1 + '\'' +
                ", lunch2='" + lunch2 + '\'' +
                ", lunch3='" + lunch3 + '\'' +
                ", snacks1='" + snacks1 + '\'' +
                ", snacks2='" + snacks2 + '\'' +
                ", dinner1='" + dinner1 + '\'' +
                ", dinner2='" + dinner2 + '\'' +
                '}';
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getBreakfast1() {
        return breakfast1;
    }

    public void setBreakfast1(String breakfast1) {
        this.breakfast1 = breakfast1;
    }

    public String getBreakfast2() {
        return breakfast2;
    }

    public void setBreakfast2(String breakfast2) {
        this.breakfast2 = breakfast2;
    }

    public String getBreakfast3() {
        return breakfast3;
    }

    public void setBreakfast3(String breakfast3) {
        this.breakfast3 = breakfast3;
    }

    public String getLunch1() {
        return lunch1;
    }

    public void setLunch1(String lunch1) {
        this.lunch1 = lunch1;
    }

    public String getLunch2() {
        return lunch2;
    }

    public void setLunch2(String lunch2) {
        this.lunch2 = lunch2;
    }

    public String getLunch3() {
        return lunch3;
    }

    public void setLunch3(String lunch3) {
        this.lunch3 = lunch3;
    }

    public String getSnacks1() {
        return snacks1;
    }

    public void setSnacks1(String snacks1) {
        this.snacks1 = snacks1;
    }

    public String getSnacks2() {
        return snacks2;
    }

    public void setSnacks2(String snacks2) {
        this.snacks2 = snacks2;
    }

    public String getDinner1() {
        return dinner1;
    }

    public void setDinner1(String dinner1) {
        this.dinner1 = dinner1;
    }

    public String getDinner2() {
        return dinner2;
    }

    public void setDinner2(String dinner2) {
        this.dinner2 = dinner2;
    }
}
