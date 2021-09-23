package ua.GoIT_Dev2.HW4.ProjectManagementSystem.util;

import java.util.List;

public class OutputMessage {

    public void welcomeMessage (){
        String startMessage =
                "\nprint a formatted string for operations with tables (company, customer, developer, project, skill):\n" +
                        "    for CREATE:  create-{table}\n" +
                        "    for READ:    get-{table}-{id}\n" +
                        "    for UPDATE:  update-{table}\n" +
                        "    for DELETE:  delete-{table}-{id}\n" +
                        "    for help:    help\n" +
                        "    for exit:    exit";
        System.out.println(startMessage);
    }

    public void printResult(List<String> resultData){
        resultData.forEach(System.out::println);
        System.out.println();
    }
}
