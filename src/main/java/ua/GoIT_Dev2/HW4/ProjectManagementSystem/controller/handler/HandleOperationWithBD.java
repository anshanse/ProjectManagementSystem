package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

import lombok.SneakyThrows;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.service.BaseService;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.PropertiesLoader;

import java.util.Scanner;

public class HandleOperationWithBD extends ProjectManagementHandler {

    private static final Scanner in = new Scanner(System.in);

    public HandleOperationWithBD(ProjectManagementHandler handler) {
        super(handler);
    }
    private final BaseService service = new BaseService();

    @SneakyThrows
    @Override
    protected void apply() {

        String startMessage =
                "print a formatted string for operations with tables (company, customer, developer, project, skill):\n" +
                        "    for CREATE:  create-{table}\n" +
                        "    for READ:    get-{table}-{id}\n" +
                        "    for UPDATE:  update-{table}\n" +
                        "    for DELETE:  delete-{table}-{id}\n" +
                        "    for help:    help\n" +
                        "    for exit:    exit";
        System.out.println(startMessage);
        String response = in.next();
        while (!"exit".equals(response)){
            if ("help".equals(response)){
                System.out.println(startMessage);
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
            } else if ("delete".equals(operation)) {
                service.delete(modelClass, id);
            } else if ("create".equals(operation)) {
                service.create(modelClass);
            } else if ("update".equals(operation)) {
                service.update(modelClass);
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
