package ua.GoIT_Dev2.HW4.ProjectManagementSystem.util;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Scanner;

public class DataValidator {



    @SneakyThrows
    public static String verifyInputData(String key, Class modelClass, Scanner in){
        String input = "";
        String textMatch = "[A-Za-z0-9\\s]+";
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
        if ("sex".equals(key)){
            textMatch = "[mf]";
            warningMessage = String.format("Input %s (m/f): ", key);
        }
        while (!input.matches(textMatch)){
            System.out.println(warningMessage);
            input = in.nextLine();
        }
        return input;
    }

    public boolean validateInputData (String inputData, Field field){
        String textMatch = "[A-Za-z0-9\\s]+";
        //Field field = modelClass.getDeclaredField(key);
        if (field.getType().equals(Integer.TYPE) || field.getName().contains("id") || field.getName().contains("Id")){
            textMatch = "\\d+";
        }
        if (field.getType().equals(Date.class)){
            textMatch = "\\d{4}-\\d{2}-\\d{2}";
        }
        if ("sex".equals(field.getName())){
            textMatch = "[mf]";
        }
        return inputData.matches(textMatch);
    }

}
