package ua.GoIT_Dev2.HW4.ProjectManagementSystem.service;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Scanner;

public class DataValidator {



    @SneakyThrows
    public static String verifyInputData(String key, Class modelClass, Scanner in){
        String input = "";
        String textMatch = "\\w+";
        String warningMessage = String.format("input %s : ",key);
        //System.out.println(key);
        Field field = modelClass.getDeclaredField(key);
        if (field.getType().equals(Integer.TYPE) || field.getName().contains("id") || field.getName().contains("Id")){
            textMatch = "\\d+";
            warningMessage =String.format("Input %s (only numbers): ", key);
        }
        if (field.getType().equals(Date.class)){
            textMatch = "\\d{4}-\\d{2}-\\d{2}";
            warningMessage = String.format("Input %s in format (yyyy-mm-dd): ", key);
        }
        while (!input.matches(textMatch)){
            System.out.println(warningMessage);
            input = in.nextLine();
        }
        return input;
    }

}
