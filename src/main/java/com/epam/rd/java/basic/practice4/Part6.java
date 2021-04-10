package com.epam.rd.java.basic.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    private static final String CYRL_PATTERN = "(?iu)[а-яёэєії]+";
    private static final String LATN_PATTERN = "(?iu)[a-z]+";

    public static void main(String[] args) {
         try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
             boolean flag = true;
            while (flag) {
                String choice = reader.readLine().toLowerCase();
                if(choice.equals("latn")) {
                    System.out.println("Latn: " + getWords(LATN_PATTERN, "part6.txt"));
                } else if (choice.equals("cyrl")) {
                    System.out.println("Cyrl: " + getWords(CYRL_PATTERN, "part6.txt"));
                } else if (choice.equals("stop")) {
                    flag = false;
                } else {
                    System.out.println(choice + ": Incorrect input");
                }
            }
        } catch (IOException e) { System.out.println(Part2.ERROR_MESSAGE); }
    }

    public static String getWords(String pattern, String fileName ) {
        String path = Demo.DIRECTORY + fileName;
        String str = Part2.readData(path);
        StringBuilder res = new StringBuilder();
        Matcher matcher = Pattern.compile(pattern).matcher(str);
        while (matcher.find()) {
            String s = str.substring(matcher.start(), matcher.end());
            res.append(s);
            res.append(' ');
        }
        return res.toString();
    }
}
