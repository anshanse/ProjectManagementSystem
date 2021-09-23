package ua.GoIT_Dev2.HW4.ProjectManagementSystem.service;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.model.Developer;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.DevRepository;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.QueryService;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.OutputMessage;

public class DeveloperService {

    private final DevRepository repository = new DevRepository(Developer.class);
    private final QueryService queryService = new QueryService();
    private final OutputMessage printMessage = new OutputMessage();

    public void getSumSalaryDevsOnProject (int id){
        printMessage.printResult(queryService.sendQuery(repository.sumSalaryDevsOnProject(id)));
    }

    public void getDevWithSkill (String skill){
        printMessage.printResult(queryService.sendQuery(repository.devWithSkill(skill)));
    }

    public void getDevWithGrade (String grade){
        printMessage.printResult(queryService.sendQuery(repository.devWithGrade(grade)));
    }
}
