package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.MessageService;

public class HandleWrongInput extends ProjectManagementHandler {

    private final String acceptSelect = "[^0123456]";
    private final MessageService message = new MessageService();

    public HandleWrongInput(ProjectManagementHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        message.inputCorrectData();
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return (inputNumber.matches(acceptSelect));
    }
}
