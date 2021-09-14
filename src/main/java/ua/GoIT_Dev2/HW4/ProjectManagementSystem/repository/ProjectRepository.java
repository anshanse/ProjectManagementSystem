package ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.UtilsPMS;

public class ProjectRepository extends BaseRepositoryImpl{
    public ProjectRepository(Class modelClass) {
        super(modelClass);
    }

    public static void fetchDevsOnProject (int id){
        String sql = "SELECT name FROM developers " +
                "JOIN developers_projects dp ON developers.id = dp.developers_id " +
                "JOIN projects p ON p.id = dp.projects_id " +
                "WHERE projects_id = " + id;
        UtilsPMS.printQueryResult(sql);
    }



    public static void projectList (){
        String sql = "SELECT start_date, project_name, count(name) AS 'developers on project' FROM  projects " +
                "JOIN  developers_projects dp ON  projects.id = dp.projects_id " +
                "JOIN  developers d on d.id = dp.developers_id " +
                "GROUP BY  project_name ORDER BY project_name asc;";
        UtilsPMS.printQueryResult(sql);
    }
}
