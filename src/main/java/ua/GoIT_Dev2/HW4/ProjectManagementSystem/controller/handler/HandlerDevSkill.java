package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.MessageService;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.service.DeveloperService;

import java.util.Scanner;

public class HandlerDevSkill extends ProjectManagementHandler {

    public HandlerDevSkill(ProjectManagementHandler handler) {
        super(handler);
    }

    private final DeveloperService service = new DeveloperService();
    private final MessageService printMessage = new MessageService();

    @Override
    protected void apply() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input skill: ");
        String skill = in.next();
        System.out.println("Developers with skill in " + skill + ": ");
        printMessage.printResult(service.getDevWithSkill(skill));
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("3".equals(inputNumber));
    }

}
