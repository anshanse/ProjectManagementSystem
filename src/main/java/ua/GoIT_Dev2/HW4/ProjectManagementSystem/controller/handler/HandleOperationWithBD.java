package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

import lombok.SneakyThrows;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.OutputMessage;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.model.BaseEntity;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.service.BaseService;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.PropertiesLoader;

import java.util.Scanner;

public class HandleOperationWithBD extends ProjectManagementHandler {

    private static final Scanner in = new Scanner(System.in);

    public HandleOperationWithBD(ProjectManagementHandler handler) {
        super(handler);
    }
    private final BaseService service = new BaseService();
    private final OutputMessage printMessage = new OutputMessage();

    @SneakyThrows
    @Override
    protected void apply() {

        printMessage.welcomeMessage();
        String response = in.next();
        while (!"exit".equals(response)){
            if ("help".equals(response)){
                printMessage.welcomeMessage();
                response = in.next();
                continue;
            }
            String[] responseArray = response.split("-");
            if (responseArray.length < 2) {
                System.out.println("print incorrect input");
                response = in.next();
                continue;
            }
            String operation = responseArray[0];
            String className = Character.toUpperCase(responseArray[1].charAt(0)) + responseArray[1].substring(1);
            Class modelClass = Class.forName(PropertiesLoader.getProperty("classPath") + className);
            long id = 0L;
            if (("get".equals(operation) || "delete".equals(operation)) & responseArray.length < 3){
                System.out.println("print correct string (with ID in third position)");
                response = in.next();
                continue;
            } else if("get".equals(operation) || "delete".equals(operation)) id = Long.parseLong(responseArray[2]);

            if        ("get".equals(operation)){
                System.out.println(service.read(modelClass, id));
                printMessage.welcomeMessage();
            } else if ("delete".equals(operation)) {
                service.delete(modelClass, id);
                printMessage.welcomeMessage();
            } else if ("create".equals(operation)) {
                BaseEntity entity = service.create(modelClass);
                System.out.println("Was create " + modelClass.getName() + ": " + entity);
                printMessage.welcomeMessage();
            } else if ("update".equals(operation)) {
                BaseEntity entity = service.update(modelClass);
                System.out.println("Was updated " + modelClass.getName() + ": " + entity);
                printMessage.welcomeMessage();
            }
            System.out.println("\nInput command: ");
            response = in.next();
        }
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("6".equals(inputNumber));
    }

}
