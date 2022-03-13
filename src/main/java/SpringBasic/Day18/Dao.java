package SpringBasic.Day18;

import java.util.List;
/*
UserDAO -> USer Data access Object
Basically this interface is used to access data from the USer table
 */
public interface Dao<T> {
    List<T> readAll();
    void create(T entity);
    T readById(int id);
    void update(T entity);
    void delete(T entity);
}