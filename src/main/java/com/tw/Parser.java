package com.tw;

public class Parser {

    public static Student parseLineToStudent(String line){
        String[] parts = line.split(", ");
        if (parts.length != 6) {
            return null;
        }
        String name = parts[0];
        String id = parts[1];
        Student student = new Student(id, name);
        for (int i = 2; i < parts.length; i++) {
            String[] item = parts[i].split(": ");
            Double grade = null;
            try {
                grade = Double.parseDouble(item[1]);
            } catch (NumberFormatException nfe) {
                return null;
            }
            switch (item[0]) {
                case "��ѧ":
                    student.setMath(grade);
                    break;
                case "����":
                    student.setChinese(grade);
                    break;
                case "Ӣ��":
                    student.setEnglish(grade);
                    break;
                case "���":
                    student.setProgramming(grade);
                    break;
                default:
                    return null;
            }
        }
        return student;
    }

}
