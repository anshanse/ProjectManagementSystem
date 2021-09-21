package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.OutputMessage;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler.ProjectManagementHandler;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.ProjectRepository;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.service.ProjectService;

public class HandleProjectList extends ProjectManagementHandler {

    private final ProjectService service = new ProjectService();
    private final OutputMessage printMessage = new OutputMessage();

    public HandleProjectList(ProjectManagementHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        System.out.println("Project list: ");
        service.getProjectList();
        printMessage.welcomeMessage();
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("5".equals(inputNumber));
    }
}