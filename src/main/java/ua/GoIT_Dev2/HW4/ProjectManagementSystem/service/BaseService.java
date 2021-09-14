package ua.GoIT_Dev2.HW4.ProjectManagementSystem.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.model.BaseEntity;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.BaseRepositoryImpl;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.RepositoryFactory;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BaseService<E extends BaseEntity<ID>, ID> {

    private final Scanner in = new Scanner(System.in);

    public E create(Class<E> modelClass){
        Map<String,String> mapColumnField = Arrays.stream(modelClass.getDeclaredFields())
                .filter(modelField -> !Modifier.isStatic(modelField.getModifiers()))
                .filter(field -> field.getName() != "id")
                .collect(Collectors.toMap(modelField -> getColumn(modelField), modelField -> modelField.getName()));
        BaseEntity entity = getEntity(mapColumnField, modelClass);
        return save(modelClass, (E) entity);
    };

    public E save(Class<E> modelClass, E e){
        return RepositoryFactory.of(modelClass).save(e);
    };

    public  E read(Class<E> modelClass, ID id){
        return RepositoryFactory.of(modelClass).getOne(id);
    };

    public E update(Class<E> modelClass){
        Map<String,String> mapColumnField = Arrays.stream(modelClass.getDeclaredFields())
                .filter(modelField -> !Modifier.isStatic(modelField.getModifiers()))
                .collect(Collectors.toMap(modelField -> getColumn(modelField), modelField -> modelField.getName()));
        BaseEntity entity = getEntity(mapColumnField, modelClass);
        return save(modelClass, (E) entity);
    };

    public void delete(Class<E> modelClass, ID id){
        RepositoryFactory.of(modelClass).deleteById(id);
    };

    private BaseEntity getEntity(Map<String,String> mapColumnField, Class modelClass){
        Map<String,String> mapEntity = new HashMap<>();
        for (Map.Entry<String,String> element : mapColumnField.entrySet()) {
            String key = element.getValue();
            //System.out.println(String.format("input %s : ",key));
            String response = DataService.verifyInputData(key,modelClass,in);
            mapEntity.put(key,response);
        }
        ObjectMapper jacksonMapper = new ObjectMapper();
        BaseEntity convertValue = (BaseEntity) jacksonMapper.convertValue(mapEntity, modelClass);
        return convertValue;
    }

    private String getColumn(Field modelField) {
        return modelField.getAnnotationsByType(Column.class) == null ? modelField.getName() : modelField.getAnnotation(Column.class).name();
    }
}
