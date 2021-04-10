package com.epam.rd.java.basic.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    private static final String INT_PATTERN = "^\\d{1,}$";
    private static final String DOUBLE_PATTERN = "^(\\d+\\.{1}\\d?|\\d?\\.{1}\\d+|\\d+\\.{1}\\d+)$";

    public static void main(String[] args) {
        StringBuilder[] sb = getRequiredTypes();
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String requirement = bufReader.readLine();
                if (requirement.equals("stop")) break;
                switch (requirement) {
                    case "int" : System.out.println(sb[0]); break;
                    case "double" : System.out.println(sb[1]); break;
                    case "char" : System.out.println(sb[2]); break;
                    case "String" : System.out.println(sb[3]); break;
                    default : System.out.println("Incorrect input");
                }
            }
        } catch (IOException e) {
            System.out.println(Part2.ERROR_MESSAGE);
        }
    }

    public static StringBuilder[] getRequiredTypes() {
        String[] arr = getSplittedInput();
        StringBuilder[] res = {new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder()};
        for (int i = 0; i < arr.length; i++) {
            Matcher matcherInt = Pattern.compile(INT_PATTERN).matcher(arr[i]);
            Matcher matcherDbl = Pattern.compile(DOUBLE_PATTERN).matcher(arr[i]);
            if (matcherInt.find()) { res[0].append(arr[i]); res[0].append(' '); arr[i] = "*"; }
            if (matcherDbl.find()) { res[1].append(arr[i]); res[1].append(' '); arr[i] = "*"; }
        }
        findStringsAndChars(res, arr);
         return res;
    }

    public static void findStringsAndChars(StringBuilder[] res, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("*")) continue;
            Matcher matcherCyrl = Pattern.compile("\\p{InCyrillic}{1}").matcher(arr[i]);
            Matcher matcherLatn = Pattern.compile("[A-z]{1,}").matcher(arr[i]);
            if (matcherLatn.find()) {
                if (arr[i].length() == 1) { res[2].append(arr[i]); res[2].append(' '); }
                else { res[3].append(arr[i]); res[3].append(' '); }
            }
            if (matcherCyrl.find()) {
                if (arr[i].length() == 1) { res[2].append(arr[i]); res[2].append(' '); }
                else { res[3].append(arr[i]); res[3].append(' '); }
            }
        }
    }

    private static String[] getSplittedInput() {
        String s = Part2.readData(Demo.DIRECTORY + "part3.txt");
        s = replace(s);
        return s.split(" ");
    }

    private static String replace(String input) {
        Matcher matcher = Pattern.compile(Demo.LINE_SEP).matcher(input);
        return matcher.replaceAll(" ");
    }


}
