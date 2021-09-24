package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.DataValidator;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.MessageService;

import java.lang.reflect.Field;
import java.util.Scanner;

public class ReadData {

    private final Scanner in = new Scanner(System.in);
    private final DataValidator validator = new DataValidator();
    private final MessageService message = new MessageService();

    public String readConsole(){
        return in.nextLine();
    }

    public String readField(Field field){
        String inputData = "";
        while (!validator.validateInputData(inputData, field)) {
            message.promptFormattingInput(field);
            inputData = readConsole();
        }
        return inputData;
    }
}
