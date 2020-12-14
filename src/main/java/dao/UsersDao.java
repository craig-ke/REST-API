package dao;

import models.Users;

import java.util.List;

public class UsersDao {
    //create
    void add(Users users);

    //read
    List<Users> getAll();
    List<Users> getAllUsersByDepartments(int departmentId);

    //update

    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();

}