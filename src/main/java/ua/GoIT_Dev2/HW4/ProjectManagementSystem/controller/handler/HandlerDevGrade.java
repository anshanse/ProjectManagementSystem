package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.OutputMessage;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler.ProjectManagementHandler;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.DevRepository;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.service.DeveloperService;

import java.util.Scanner;

public class HandlerDevGrade extends ProjectManagementHandler {

    private final DeveloperService service = new DeveloperService();
    private final OutputMessage printMessage = new OutputMessage();

    public HandlerDevGrade(ProjectManagementHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input grade:");
        String grade = in.next();
        System.out.println("Developers with " + grade + " grade in any skill: ");
        service.getDevWithGrade(grade);
        printMessage.welcomeMessage();
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("4".equals(inputNumber));
    }
}