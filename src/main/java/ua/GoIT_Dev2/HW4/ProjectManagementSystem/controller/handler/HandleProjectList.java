package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.service.ProjectService;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.MessageService;

public class HandleProjectList extends ProjectManagementHandler {

    private final ProjectService service = new ProjectService();
    private final MessageService printMessage = new MessageService();

    public HandleProjectList(ProjectManagementHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        System.out.println("Project list: ");
        printMessage.printResult(service.getProjectList());
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("5".equals(inputNumber));
    }
}