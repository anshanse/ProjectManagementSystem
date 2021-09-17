package ua.GoIT_Dev2.HW4.ProjectManagementSystem.service;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.DevRepository;

public class DeveloperService {

    public static void getSumSalaryDevsOnProject (int id){
        DevRepository.sumSalaryDevsOnProject(id);
    }

    public static void getDevWithSkill (String skill){
        DevRepository.devWithSkill(skill);
    }

    public static void getDevWithGrade (String grade){
        DevRepository.devWithGrade(grade);
    }
}
