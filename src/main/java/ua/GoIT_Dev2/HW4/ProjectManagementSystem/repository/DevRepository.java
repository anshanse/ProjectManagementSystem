package ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.OutputMessage;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.service.QueryService;

public class DevRepository extends BaseRepositoryImpl{

    private final QueryService queryService = new QueryService();
    private final OutputMessage printMessage = new OutputMessage();

    public DevRepository(Class modelClass) {
        super(modelClass);
    }

    public void sumSalaryDevsOnProject (int id){
        String sql = "SELECT  SUM(salary) AS 'Summary salary' FROM developers " +
                "JOIN developers_projects dp ON developers.id = dp.developers_id " +
                "JOIN projects p ON p.id = dp.projects_id " +
                "WHERE projects_id = " + id;
        printMessage.printResult(queryService.sendQuery(sql));
    }

    public void devWithSkill (String skill){
        String sql = "SELECT name FROM developers " +
                "JOIN developers_skills ds ON developers.id = ds.developers_id " +
                "JOIN skills s ON s.id = ds.skills_id  " +
                "WHERE skill = '" + skill + "' ORDER BY name asc";
        printMessage.printResult(queryService.sendQuery(sql));
    }

    public void devWithGrade (String grade) {
        String sql = "SELECT DISTINCT name FROM developers " +
                "JOIN developers_skills ds ON developers.id = ds.developers_id " +
                "JOIN skills s ON s.id = ds.skills_id  " +
                "WHERE grade = '" + grade + "' ORDER BY name asc";
        printMessage.printResult(queryService.sendQuery(sql));
    }
}
