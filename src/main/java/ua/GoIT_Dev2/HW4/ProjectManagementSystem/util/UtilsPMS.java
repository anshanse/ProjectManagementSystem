package ua.GoIT_Dev2.HW4.ProjectManagementSystem.util;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.service.QueryService;

import java.util.List;

public class UtilsPMS {

    public static void printQueryResult(String sql){
        List<String> result = getQueryResult(sql);
        result.forEach(System.out::println);
        System.out.println();
    }

    private static List<String> getQueryResult (String sql){
        return QueryService.sendQuery(sql);
    }
}
