package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler.ProjectManagementHandler;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.ProjectRepository;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.service.ProjectService;

public class HandleProjectList extends ProjectManagementHandler {

    public HandleProjectList(ProjectManagementHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        System.out.println("Project list:");
        ProjectService.getProjectList();
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("5".equals(inputNumber));
    }
}