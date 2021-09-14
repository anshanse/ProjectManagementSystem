package ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository;

import lombok.SneakyThrows;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.model.BaseEntity;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.model.Project;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryRepository <E extends BaseEntity<ID>, ID>{

    @SneakyThrows
    public static List<String> sendQuery(String sql){
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSetToList(resultSet);
    }

    @SneakyThrows
    private static List<String> resultSetToList (ResultSet rs){
        List<String> rsList = new ArrayList<>();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columns = rsmd.getColumnCount();
        while (rs.next()){
            StringBuilder row = new StringBuilder();
            for (int i = 1; i <= columns ; i++) {
                row.append(String.join(": ",rsmd.getColumnName(i), rs.getString(i)));
                if (i<columns) row.append(", ");
            }
            rsList.add(row.toString());
        }
        return rsList;
    }
}
