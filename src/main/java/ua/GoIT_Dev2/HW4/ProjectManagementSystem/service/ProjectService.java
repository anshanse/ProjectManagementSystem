package ua.GoIT_Dev2.HW4.ProjectManagementSystem.service;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.ProjectRepository;

public class ProjectService {

    public static void getDevsOnProject (int id){
        ProjectRepository.fetchDevsOnProject(id);
    }

    public static void getProjectList(){
        ProjectRepository.getProjectList();
    }
}
