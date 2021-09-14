package ua.GoIT_Dev2.HW4.ProjectManagementSystem.main;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.model.*;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.BaseRepository;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.RepositoryFactory;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler.HandlerExit;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.controller.handler.ProjectManagementHandler;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ProjectManagementHandler handler = ProjectManagementHandler.of();

        BaseRepository<Company, Long> companyRepository = RepositoryFactory.of(Company.class);
        BaseRepository<Developer, Long> developersRepository = RepositoryFactory.of(Developer.class);
        BaseRepository<Customer, Long> customerRepository = RepositoryFactory.of(Customer.class);
        BaseRepository<Project, Long> projectRepository = RepositoryFactory.of(Project.class);
        BaseRepository<Skill, Long> skillRepository = RepositoryFactory.of(Skill.class);

        while (!HandlerExit.isExit) {
            System.out.println("1 - The salary of developers in project");
            System.out.println("2 - Developers working on the project");
            System.out.println("3 - Developers with skill");
            System.out.println("4 - Developers with grade");
            System.out.println("5 - Project list");
            System.out.println("6 - Operation with BD");
            System.out.println("0 - Exit");
            Scanner in = new Scanner(System.in);
            handler.handle(in.next());
        }

    }
}
