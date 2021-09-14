package ua.GoIT_Dev2.HW4.ProjectManagementSystem.util;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.QueryRepository;

import java.util.List;

public class UtilsPMS {

    public static void printQueryResult(String sql){
        List<String> result = QueryRepository.sendQuery(sql);
        result.forEach(System.out::println);
        System.out.println();
    }
}
