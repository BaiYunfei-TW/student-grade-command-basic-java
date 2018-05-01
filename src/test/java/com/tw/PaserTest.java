package com.tw;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class PaserTest {

    @Test
    public void test_parse_string_to_student(){
        Student testStudent1 = new Student("001", "白云飞", 100.0,100.0,100.0,100.0);
        String str = "白云飞, 001, 数学: 100, 语文: 100, 英语: 100, 编程: 100";

        assertThat(Parser.parseLineToStudent(str)).isEqualTo(testStudent1);
    }
}
