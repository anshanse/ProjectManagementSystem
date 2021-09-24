package ua.GoIT_Dev2.HW4.ProjectManagementSystem.service;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.model.Project;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.ProjectRepository;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.MessageService;

public class ProjectService {

    private final ProjectRepository repository = new ProjectRepository(Project.class);
    private final MessageService printMessage = new MessageService();

    public void getDevsOnProject (int id){
        printMessage.printResult(repository.fetchDevsOnProject(id));
    }

    public void getProjectList(){
        printMessage.printResult(repository.getProjectList());
    }
}
