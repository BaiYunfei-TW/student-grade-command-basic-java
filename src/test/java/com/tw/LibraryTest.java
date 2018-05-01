package com.tw;

import com.google.common.collect.Sets;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream(1);

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }

    @Test
    public void testMockClass() throws Exception {
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        String value = "first";
        when(mockedList.get(0)).thenReturn(value);

        assertEquals(mockedList.get(0), value);

    }

    @Test
    public void test_input_student_success() {
        Student testStudent1 = new Student("001", "白云飞", 100.0,100.0,100.0,100.0);

        Asker asker = mock(Asker.class);
        when(asker.askForInteger(Constants.MAIN_MENU)).thenReturn(1,3);
        when(asker.askForLine(Constants.STDDENT_INPUT_MESSAGE)).thenReturn(praseStudentToInputString(testStudent1));

        Library library = new Library(asker);
        library.serve();
        assertThat(library.getStudents()).contains(testStudent1);
    }

    @Test
    public void test_calculate_average_and_total_grade() {
        Student testStudent1 = new Student("001", "白云飞", 100.0,100.0,100.0,100.0);

        Asker asker = mock(Asker.class);
        when(asker.askForInteger(Constants.MAIN_MENU)).thenReturn(1,3);
        when(asker.askForLine(Constants.STDDENT_INPUT_MESSAGE)).thenReturn(praseStudentToInputString(testStudent1));

        Library library = new Library(asker);
        library.serve();

        for (Student stu : library.getStudents()) {
            double total = stu.getChinese() + stu.getMath() + stu.getEnglish() + stu.getProgramming();
            double avg = (total) / 4;
            assertThat(stu.getTotal()).isEqualTo(total);
            assertThat(stu.getAverage()).isEqualTo(avg);
        }
    }

    @Test
    public void test_generate_grade_list(){
        Student testStudent1 = new Student("001", "张三", 75.0,95.0,80.0,80.0);
        Student testStudent2 = new Student("002", "李四", 85.0, 80.0, 70.0, 90.0);

        Asker asker = mock(Asker.class);
        when(asker.askForInteger(Constants.MAIN_MENU)).thenReturn(1,1,2,2,3);
        when(asker.askForLine(Constants.STDDENT_INPUT_MESSAGE))
                .thenReturn(praseStudentToInputString(testStudent1),
                            praseStudentToInputString(testStudent2));
        when(asker.askForLine(Constants.QUERY_GRADE_LIST_MESSAGE)).thenReturn("001, 002","001");

        Library library = new Library(asker);
        library.serve();

        assertThat(systemOut()).isEqualTo("成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|75|95|80|80|82.5|330\n" +
                "李四|85|80|70|90|81.25|325\n" +
                "========================\n" +
                "全班总分平均数：327.5\n" +
                "全班总分中位数：327.5\n"+
                "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|75|95|80|80|82.5|330\n" +
                "========================\n" +
                "全班总分平均数：330\n" +
                "全班总分中位数：330\n");
    }

    /**
     * 将Student实例转换成输入格式的字符串，方便测试用
     * @param student
     * @return
     */
    private String praseStudentToInputString(Student student){
        return String.format("%s, %s, 数学: %f, 英语: %f, 语文: %f, 编程: %f",
                student.getName(),
                student.getId(),
                student.getMath(),
                student.getEnglish(),
                student.getChinese(),
                student.getProgramming());
    }


}
