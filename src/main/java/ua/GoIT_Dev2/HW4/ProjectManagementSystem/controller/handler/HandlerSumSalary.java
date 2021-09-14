package ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.DevRepository;

import java.util.Scanner;

public class HandlerSumSalary extends ProjectManagementHandler {

    public HandlerSumSalary(ProjectManagementHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input project ID:");
        int id = in.nextInt();
        System.out.println("The salary of developers in project with ID=" + id + " is:");
        DevRepository.sumSalaryDevsOnProject(id);
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("1".equals(inputNumber));
    }
}
