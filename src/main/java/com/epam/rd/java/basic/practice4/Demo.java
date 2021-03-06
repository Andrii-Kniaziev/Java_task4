package com.epam.rd.java.basic.practice4;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Demo {
    public static final String DIRECTORY = System.getProperty("user.dir") + File.separator;
    public static final String LINE_SEP = System.lineSeparator();
    private static final InputStream STD_IN = System.in;

    public static void main(String[] args) {
        System.out.println("=========================== PART1");
        Part1.main(args);

        System.out.println("=========================== PART2");
        Part2.main(args);

        System.out.println("=========================== PART3");
        System.setIn(new ByteArrayInputStream(
                "char^String^int^double^stop".replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
        Part3.main(args);
        System.setIn(STD_IN);

        System.out.println("=========================== PART5");
        System.setIn(new ByteArrayInputStream(
                "table ru^table en^apple ru^stop".replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
        Part5.main(args);
        System.setIn(STD_IN);

        System.out.println("=========================== PART6");
        System.setIn(new ByteArrayInputStream(
                "Latn^Cyrl^asdf^latn^cyrl^stop".replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
        Part6.main(args);
        System.setIn(STD_IN);
    }

}
