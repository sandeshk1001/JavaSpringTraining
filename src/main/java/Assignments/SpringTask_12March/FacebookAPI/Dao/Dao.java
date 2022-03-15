package Assigments.SpringTask_12March.FacebookAPI.Dao;

import java.util.List;

public interface Dao<T> {
    List<T> readAll();
    void create(T entity);
    T readById(int id);
    Boolean update(T entity);
    void delete(T entity);
    T readByEmail(String entity);
}
