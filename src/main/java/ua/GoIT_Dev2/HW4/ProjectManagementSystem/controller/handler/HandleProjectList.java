package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler.ProjectManagementHandler;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.ProjectRepository;

public class HandleProjectList extends ProjectManagementHandler {

    public HandleProjectList(ProjectManagementHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        System.out.println("Project list:");
        ProjectRepository.projectList();
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("5".equals(inputNumber));
    }
}