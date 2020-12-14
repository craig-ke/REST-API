package dao;

import models.Departments;
import models.Users;
import org.junit.After;
import org.junit.Before;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;

public class Sql2oUsersDaoTest {
    private Connection conn;
    private Sql2oUsersDao usersDao;
    private Sql2oDepartmentsDao departmentsDao;
//Setup method
    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "rose", "wambua");
        usersDao = new Sql2oUsersDao(sql2o);
        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        conn = sql2o.open();
    }
//TearDownMethod
    @After
    public void tearDown() throws Exception {
        Users Users = setupUsers();
        Users  Users2 = setupUsers();
        assertEquals(2, usersDao.getAll().size());
    }
    //Test 1
    //Test 2
    //Test 3
    //Test 4
    //helpers
    public Users  setupUsers() {
        Users users = new Users("Rose", "Senior", "Maintenance", "rmogusu123@gmail.com",234,"IT",1) ;
        usersDao.add(users);
        return users ;
    }

    public Users setupUsersForDepartments(Departments departments) {
        Users  users = new Users("Rose", "Senior","Maintenance", "rmogusu123@gmail.com",234,"IT", departments .getId()) ;
        usersDao.add(users);
        return users;
    }

    public Departments  setupDepartments() {
        Departments  departments = new Departments("IT", "Programming", 500) ;
        departmentsDao.add(departments);
        return departments;
    }
}
