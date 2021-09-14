package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler.ProjectManagementHandler;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.ProjectRepository;

import java.util.Scanner;

public class HandlerDevOnProject extends ProjectManagementHandler {

    public HandlerDevOnProject(ProjectManagementHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input project ID:");
        int id = in.nextInt();
        System.out.println("Developers working on project with ID=" + id + ":");
        ProjectRepository.fetchDevsOnProject(id);
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("2".equals(inputNumber));
    }
}
