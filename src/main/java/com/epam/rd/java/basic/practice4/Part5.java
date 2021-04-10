package com.epam.rd.java.basic.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Part5 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String requirement = br.readLine();
                if (requirement.equals("stop")) break;
                String[] couple = requirement.split(" ");
                print(couple[0], couple[1]);
            }
        } catch (IOException e) {
            System.out.println(Part2.ERROR_MESSAGE);
        } catch (MissingResourceException e) {
            System.out.println("Wrong Input");
        }
    }

    private static void print(String key, String localization) {
        String lang = localization;
        Locale locale = new Locale(lang);
        ResourceBundle rb = ResourceBundle.getBundle("resources", locale);
        String str = rb.getString(key);
        System.out.println(str);
    }

}
