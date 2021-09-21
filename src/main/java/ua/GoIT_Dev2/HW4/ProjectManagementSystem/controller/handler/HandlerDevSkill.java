package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.OutputMessage;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.model.Developer;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.DevRepository;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.service.DeveloperService;

import java.util.Scanner;

public class HandlerDevSkill extends ProjectManagementHandler {

    public HandlerDevSkill(ProjectManagementHandler handler) {
        super(handler);
    }

    private final DeveloperService service = new DeveloperService();
    private final OutputMessage printMessage = new OutputMessage();

    @Override
    protected void apply() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input skill:");
        String skill = in.next();
        System.out.println("Developers with skill in " + skill + ": ");
        service.getDevWithSkill(skill);
        printMessage.welcomeMessage();
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("3".equals(inputNumber));
    }

}
