package ua.GoIT_Dev2.HW4.ProjectManagementSystem.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.model.BaseEntity;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository.RepositoryFactory;
import ua.GoIT_Dev2.HW4.ProjectManagementSystem.util.ReadData;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class BaseService<E extends BaseEntity<ID>, ID> {

    private final ReadData readData = new ReadData();

    public E create(Class<E> modelClass){
        Map<String,String> mapColumnField = Arrays.stream(modelClass.getDeclaredFields())
                .filter(modelField -> !Modifier.isStatic(modelField.getModifiers()))
                .filter(field -> !field.getName().equals("id"))
                .collect(Collectors.toMap(modelField -> getColumn(modelField), modelField -> modelField.getName()));
        BaseEntity entity = getEntity(mapColumnField, modelClass);
        return save(modelClass, (E) entity);
    }

    public E save(Class<E> modelClass, E e){
        return RepositoryFactory.of(modelClass).save(e);
    }

    public E read(Class<E> modelClass, ID id){
        return RepositoryFactory.of(modelClass).getOne(id);
    }

    public E update(Class<E> modelClass){
        Map<String,String> mapColumnField = Arrays.stream(modelClass.getDeclaredFields())
                .filter(modelField -> !Modifier.isStatic(modelField.getModifiers()))
                .collect(Collectors.toMap(modelField -> getColumn(modelField), modelField -> modelField.getName()));
        BaseEntity entity = getEntity(mapColumnField, modelClass);
        return save(modelClass, (E) entity);
    }

    public void delete(Class<E> modelClass, ID id){
        RepositoryFactory.of(modelClass).deleteById(id);
    }

    @SneakyThrows
    private BaseEntity getEntity(Map<String,String> mapColumnField, Class modelClass){
        Map<String,String> mapEntity = new HashMap<>();
        for (Map.Entry<String,String> element : mapColumnField.entrySet()) {
            String key = element.getValue();
            String response = readData.readField(modelClass.getDeclaredField(key));
            mapEntity.put(key,response);
        }
        ObjectMapper jacksonMapper = new ObjectMapper();
        return (BaseEntity) jacksonMapper.convertValue(mapEntity, modelClass);
    }

    private String getColumn(Field modelField) {
        return modelField.getAnnotationsByType(Column.class) == null ? modelField.getName() : modelField.getAnnotation(Column.class).name();
    }
}
