package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.security.SecureRandom;
import java.util.Scanner;

public class Part2 {
    public static final String ERROR_MESSAGE = "Something went wrong!";

    public static void main(String[] args) {
        String firstFile = createFileAndWriteNums("part2.txt");
        getNumsFromFile(firstFile, "part2_sorted.txt");
    }

    public static void writeData(String data, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(data);
            writer.flush();
        } catch (IOException e) { System.out.println(ERROR_MESSAGE); }
    }

    public static String createFileAndWriteNums(String fileName) {
        String path = Demo.DIRECTORY + fileName;
        String nums = getNumbers();
        System.out.println("input ==> " + nums);
        writeData(nums, path);
        return path;
    }

    public static String readData(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "cp1251");
            while (scanner.hasNextLine()) { sb.append(scanner.nextLine()).append(Demo.LINE_SEP); }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) { System.out.println("During scanning info, something went wrong!"); }
        return sb.toString();
    }

    public static void getNumsFromFile(String firstFile, String secondFileName) {
        String nums = readData(firstFile);
        String[] numbersStr = nums.split(" ");
        int[] numbersInt = new int[numbersStr.length];
        for (int i = 0; i < numbersStr.length; i++) { numbersInt[i] = Integer.parseInt(numbersStr[i]); }
        String sortedNums = sort(numbersInt);
        String secondFile = Demo.DIRECTORY + secondFileName;
        System.out.println("output ==> " + sortedNums);
        writeData(sortedNums, secondFile);
    }
    
    private static String sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1 + i; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int swap = nums[i];
                    nums[i] = nums[j];
                    nums[j] = swap;
                }
            }
        }
        StringBuilder sorted = new StringBuilder();
        for (int i : nums) {sorted.append(i + " ");}
        sorted.delete(sorted.length()-1, sorted.length());
        return sorted.toString();
    }

    private static String getNumbers() {
        StringBuilder nums = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 1; i <= 10; i++) { nums.append(secureRandom.nextInt(50) + " "); }
        nums.delete(nums.length()-1, nums.length());
        return nums.toString();
    }

}
