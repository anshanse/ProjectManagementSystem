package ua.GoIT_Dev2.HW4.ProjectManagementSystem.main;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.ReadData;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler.HandlerExit;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler.ProjectManagementHandler;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.MessageService;

public class Main {

    public static void main(String[] args) {

        ProjectManagementHandler handler = ProjectManagementHandler.of();
        MessageService message = new MessageService();
        ReadData readData = new ReadData();

        while (!HandlerExit.isExit) {
            message.queryOperationMessage();
            handler.handle(readData.readConsole());
        }

    }
}
