package com.tw;

import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Library {

    private String inputStudentFormate = "����ʽ������, ѧ��, ѧ��: �ɼ�, ...��";
    private String generateFormate = "����ʽ�� ѧ��, ѧ��,...��";

    private Set<Student> students = new LinkedHashSet<>();

    private Asker asker;

    public void serve() {
        int option = asker.askForInteger(Constants.MAIN_MENU);
        switch (option) {
            case 1:
                inputStudent();
                break;
            case 2:
                queryGradeList();
                break;
            case 3:
                return ;
            default:
                break;
        }
        serve();
    }

    private void queryGradeList() {
        String ids = asker.askForLine(Constants.QUERY_GRADE_LIST_MESSAGE);
        HashSet<String> idSet = Sets.newHashSet(ids.split(", "));
        String table = Constants.GRADE_LIST_HEADER;
        double sum = 0;
        Set<Student> studentSet = new HashSet<>();
        for (Student stu : students) {
            if (!idSet.contains(stu.getId())) {
                continue;
            }
            table += stu.toString() + "\n";
            sum += stu.getTotal();
            studentSet.add(stu);
        }
        //����λ��
        Double[] gradeList = new Double[studentSet.size()];
        int i = 0;
        for (Student stu : studentSet) {
            gradeList[i++] = stu.getTotal();
        }
        Arrays.sort(gradeList);
        double mid = gradeList.length % 2 == 1 ? gradeList[gradeList.length/2] : (gradeList[gradeList.length/2 - 1] + gradeList[gradeList.length/2]) / 2;
        table += String.format("========================\n" +
                               "ȫ���ܷ�ƽ������%s\n" +
                               "ȫ���ܷ���λ����%s\n",
                               StringUtils.doubleToString(sum/idSet.size()),
                               StringUtils.doubleToString(mid));
        System.out.print(table);
    }

    private void inputStudent() {
        String line = asker.askForLine(Constants.STDDENT_INPUT_MESSAGE);
        while (!addStudent(line)) {
            line = asker.askForLine(Constants.STUDENT_INPUT_FORMAT_ERROR);
        }
    }

    public boolean addStudent(String line){
        Student student = Parser.parseLineToStudent(line);
        if (student == null) {
            return false;
        }
        students.add(student);
        return true;
    }

    public Library(Asker asker) {
        this.asker = asker;
    }

    public Library() {
        this(new Asker(System.in, System.out));
    }

    public boolean someLibraryMethod() {
        return true;
    }

    public Set<Student> getStudents() {
        return students;
    }

    /**
     * ����double����ĩβ��0
     *
     * @param s
     * @return
     */
    private static String subZeroAndDot(String s) {
        if (null == s) {
            return "";
        }
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//ȥ�������0
            s = s.replaceAll("[.]$", "");//�����һλ��.��ȥ��
        }
        return s;
    }
}
