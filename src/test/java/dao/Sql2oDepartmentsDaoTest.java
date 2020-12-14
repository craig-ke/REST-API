package dao;

import models.Departments;
import models.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertNotEquals;

public class Sql2oDepartmentsDaoTest {
    private Connection conn;
    private Sql2oDepartmentsDao departmentsDao;
    private Sql2oNewsDao newsDao;
    private Sql2oUsersDao usersDao;
//setup method
    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "Craig", "Olonyi");
        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);
        conn = sql2o.open();
    }
    //Teardown method
    @After
    public void tearDown() throws Exception {
        conn.close();
    }
    //1st test
    @Test
    public void addingDepartmentsSetsId() throws Exception {
        Departments testDepartments = setupDepartments();
        assertNotEquals(0, testDepartments.getId());
    }

    //Helpers
    public Departments  setupDepartments (){
        Departments  departments = new Departments("IT", "Programming", 500) ;
        departmentsDao.add(departments);
        return departments ;
    }
    public News setupNews(){
        return new News("Sewage","corona") ;
    }

}
