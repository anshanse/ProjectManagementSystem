package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.OutputMessage;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler.ProjectManagementHandler;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.ProjectRepository;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.service.ProjectService;

import java.util.Scanner;

public class HandlerDevOnProject extends ProjectManagementHandler {

    private final ProjectService service = new ProjectService();
    private final OutputMessage printMessage = new OutputMessage();

    public HandlerDevOnProject(ProjectManagementHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input project ID:");
        int id = in.nextInt();
        System.out.println("Developers working on project with ID=" + id + ": ");
        service.getDevsOnProject(id);
        printMessage.welcomeMessage();
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("2".equals(inputNumber));
    }
}
