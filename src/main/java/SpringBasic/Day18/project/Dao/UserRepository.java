package SpringBasic.Day18.project.Dao;


import Day18.project.User;

public interface UserRepository {
    User get(int id);
    void add(User user);
    void update(User user);
    void remove(User user);
}
