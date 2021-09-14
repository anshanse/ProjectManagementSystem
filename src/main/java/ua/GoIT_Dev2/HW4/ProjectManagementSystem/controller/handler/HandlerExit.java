package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

public class HandlerExit extends ProjectManagementHandler {

    public static boolean isExit = false;

    public HandlerExit() {
        super(null);
    }

    @Override
    protected void apply() {
        isExit = true;
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("0".equals(inputNumber));
    }
}
