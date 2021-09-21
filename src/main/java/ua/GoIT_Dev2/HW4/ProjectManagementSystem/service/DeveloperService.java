package ua.GoIT_Dev2.HW4.ProjectManagementSystem.service;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.model.Developer;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.DevRepository;

public class DeveloperService {

    private final DevRepository repository = new DevRepository(Developer.class);

    public void getSumSalaryDevsOnProject (int id){
        repository.sumSalaryDevsOnProject(id);
    }

    public void getDevWithSkill (String skill){
        repository.devWithSkill(skill);
    }

    public void getDevWithGrade (String grade){
        repository.devWithGrade(grade);
    }
}
