package com.tw;

public class Student {

    private String id;
    private String name;
    private double math;
    private double chinese;
    private double english;
    private double programming;

    private double total;
    private double average;

    public Student(String id, String name, Double math, Double chinese, Double english, Double programming) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.chinese = chinese;
        this.english = english;
        this.programming = programming;

        updateAverageAndTotalGrade();
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMath() {
        return math;
    }

    public void setMath(Double math) {
        this.math = math;
        updateAverageAndTotalGrade();
    }

    public Double getChinese() {
        return chinese;
    }

    public void setChinese(Double chinese) {
        this.chinese = chinese;
        updateAverageAndTotalGrade();
    }

    public Double getEnglish() {
        return english;
    }

    public void setEnglish(Double english) {
        this.english = english;
        updateAverageAndTotalGrade();
    }

    public Double getProgramming() {
        return programming;
    }

    public void setProgramming(Double programming) {
        this.programming = programming;
        updateAverageAndTotalGrade();
    }

    public Double getTotal() {
        return total;
    }

    public Double getAverage() {
        return average;
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Student)) {
            return false;
        }
        Student stu = (Student) obj;
        if (!stu.getId().equals(this.getId())) {
            return false;
        }
        if (!stu.getName().equals(this.getName())) {
            return false;
        }
        if (!stu.getChinese().equals(this.getChinese())) {
            return false;
        }
        if (!stu.getEnglish().equals(this.getEnglish())) {
            return false;
        }
        if (!stu.getMath().equals(this.getMath())) {
            return false;
        }
        if (!stu.getProgramming().equals(this.getProgramming())) {
            return false;
        }
        return true;
    }

    private void updateAverageAndTotalGrade(){
        double total = this.getChinese() + this.getMath() + this.getEnglish() + this.getProgramming();
        double avg = (total) / 4;
        this.total = total;
        this.average = avg;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%s|%s|%s",
                name,
                StringUtils.doubleToString(math),
                StringUtils.doubleToString(chinese),
                StringUtils.doubleToString(english),
                StringUtils.doubleToString(programming),
                StringUtils.doubleToString(average),
                StringUtils.doubleToString(total));
    }
}
