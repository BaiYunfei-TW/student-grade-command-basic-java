package com.tw;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class StringUtilsTest {

    @Test
    public void test_double_to_string(){
        double num = 100.0;
        assertThat(StringUtils.doubleToString(num)).isEqualTo("100");
        num = 330.0;
        assertThat(StringUtils.doubleToString(num)).isEqualTo("330");
    }

}
