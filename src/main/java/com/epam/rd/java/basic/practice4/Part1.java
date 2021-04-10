package com.epam.rd.java.basic.practice4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        String path = Demo.DIRECTORY + "part1.txt";
        String str = Part2.readData(path);
        printChangedData(str);
    }

    public static void printChangedData(String data) {
        StringBuilder sb = new StringBuilder(data);
        int q = 0;
        Matcher matcher = Pattern.compile("(?iu)[a-zа-яёэєії]{4,}").matcher(data);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String str = data.substring(start + 2, end);
            sb.replace(start - q, end - q, str);
            q += 2;
        }
        System.out.println(sb.toString());
    }



}
