package ua.GoIT_Dev2.HW4.ProjectManagementSystem.util;

import lombok.SneakyThrows;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class QueryService{

    @SneakyThrows
    public List<String> resultSetToList (ResultSet rs){
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
