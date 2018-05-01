package com.tw;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class PaserTest {

    @Test
    public void test_parse_string_to_student(){
        Student testStudent1 = new Student("001", "���Ʒ�", 100.0,100.0,100.0,100.0);
        String str = "���Ʒ�, 001, ��ѧ: 100, ����: 100, Ӣ��: 100, ���: 100";

        assertThat(Parser.parseLineToStudent(str)).isEqualTo(testStudent1);
    }
}
