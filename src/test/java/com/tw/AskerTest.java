package com.tw;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.mockito.Mockito.mock;
import static org.fest.assertions.api.Assertions.*;
import static org.mockito.Mockito.when;

public class AskerTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void testAskForLine() {
        String inputLine = "Hello world!";
        String msg = "This is a message.";

        Asker asker = new Asker(new ByteArrayInputStream(inputLine.getBytes()), new PrintStream(outContent));

        String returnMsg = asker.askForLine(msg);
        assertThat(systemOut()).isEqualTo(msg);
        assertThat(returnMsg).isEqualTo(inputLine);
    }

}
