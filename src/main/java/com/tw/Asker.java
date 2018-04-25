package com.tw;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Asker {

    private final Scanner in;
    private final PrintStream out;

    public Asker(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public String askForLine(String message, Object ... args) {
        out.printf(message, args);
        return in.nextLine();
    }

    public Integer askForInteger(String message, Object ... args) {
        out.printf(message, args);
        return in.nextInt();
    }

}
