package ua.GoIT_Dev2.HW4.ProjectManagementSystem.service;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.model.Project;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.ProjectRepository;

public class ProjectService {

    private final ProjectRepository repository = new ProjectRepository(Project.class);

    public void getDevsOnProject (int id){
        repository.fetchDevsOnProject(id);
    }

    public void getProjectList(){
        repository.getProjectList();
    }
}
