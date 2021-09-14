package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

public abstract class ProjectManagementHandler {

    private final ProjectManagementHandler handler;

    public ProjectManagementHandler(ProjectManagementHandler handler){
        this.handler = handler;
    }

    protected abstract void apply();

    protected abstract boolean isApplicable(String inputNumber);

    public final void handle (String inputNumber){
        if (isApplicable(inputNumber)) apply();
        else handler.handle(inputNumber);
    }

    public static ProjectManagementHandler of(){
        return new HandlerSumSalary(new HandlerDevOnProject(new HandlerDevSkill(
                new HandlerDevGrade(new HandleProjectList(new HandleOperationWithBD(new HandlerExit()))))));
    }
}
