package ua.GoIT_Dev2.HW4.ProjectManagementSystem.repository;

import ua.GoIT_Dev2.HW4.ProjectManagementSystem.model.BaseEntity;

import java.util.List;
import java.util.Optional;


public interface BaseRepository<E extends BaseEntity<ID>, ID> {

    List<E> saveAll(Iterable<E> itrb);

    E save(E e);

    void deleteById(ID id);

    E getOne(ID id);

    Optional<E> findById(ID id);

    List<E> findAll();

    void close();

}
