package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.MessageService;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.service.DeveloperService;

import java.util.List;
import java.util.Scanner;

public class HandlerSumSalary extends ProjectManagementHandler {

    private final DeveloperService service = new DeveloperService();
    private final MessageService printMessage = new MessageService();

    public HandlerSumSalary(ProjectManagementHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input project ID: ");
        int id = in.nextInt();
        System.out.println("The salary of developers in project with ID=" + id + " is: ");
        printMessage.printResult(service.getSumSalaryDevsOnProject(id));
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("1".equals(inputNumber));
    }
}
