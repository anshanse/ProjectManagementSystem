package ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository;

public class ProjectRepository extends BaseRepositoryImpl{

    public ProjectRepository(Class modelClass) {
        super(modelClass);
    }

    public String fetchDevsOnProject (int id){
        String sql = "SELECT name FROM developers " +
                "JOIN developers_projects dp ON developers.id = dp.developers_id " +
                "JOIN projects p ON p.id = dp.projects_id " +
                "WHERE projects_id = " + id;
        return sql;
    }

    public String getProjectList(){
        String sql = "SELECT start_date, project_name, count(name) FROM  projects " +
                "JOIN  developers_projects dp ON  projects.id = dp.projects_id " +
                "JOIN  developers d on d.id = dp.developers_id " +
                "GROUP BY  project_name ORDER BY project_name asc;";
        return sql;
    }
}
