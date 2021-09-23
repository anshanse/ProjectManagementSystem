package ua.GoIT_Dev2.HW4.ProjectManagementSystem.service;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.model.Project;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.ProjectRepository;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.QueryService;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.OutputMessage;

public class ProjectService {

    private final ProjectRepository repository = new ProjectRepository(Project.class);
    private final QueryService queryService = new QueryService();
    private final OutputMessage printMessage = new OutputMessage();

    public void getDevsOnProject (int id){
        printMessage.printResult(queryService.sendQuery(repository.fetchDevsOnProject(id)));
    }

    public void getProjectList(){
        printMessage.printResult(queryService.sendQuery(repository.getProjectList()));
    }
}
