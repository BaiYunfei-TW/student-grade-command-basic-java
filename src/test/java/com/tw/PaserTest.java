package com.tw;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class PaserTest {

    @Test
    public void test_parse_string_to_student(){
        Student testStudent1 = new Student("001", "°×ÔÆ·É", 100.0,100.0,100.0,100.0);
        String str = "°×ÔÆ·É, 001, ÊıÑ§: 100, ÓïÎÄ: 100, Ó¢Óï: 100, ±à³Ì: 100";

        assertThat(Parser.parseLineToStudent(str)).isEqualTo(testStudent1);
    }
}
