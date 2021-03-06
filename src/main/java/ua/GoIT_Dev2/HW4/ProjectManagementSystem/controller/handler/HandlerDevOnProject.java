package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.MessageService;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.service.ProjectService;
import java.util.Scanner;

public class HandlerDevOnProject extends ProjectManagementHandler {

    private final ProjectService service = new ProjectService();
    private final MessageService printMessage = new MessageService();

    public HandlerDevOnProject(ProjectManagementHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input project ID: ");
        int id = in.nextInt();
        System.out.println("Developers working on project with ID=" + id + ": ");
        printMessage.printResult(service.getDevsOnProject(id));
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("2".equals(inputNumber));
    }
}
