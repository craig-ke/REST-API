package dao;

import models.Departments;
import models.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oNewsDaoTest {

    private Sql2oNewsDao newsDao;
    private Sql2oDepartmentsDao departmentsDao;
    private Connection conn;
    //Setup method
    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "rose", "wambua");
        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }
    //Teardown
    @After
    public void tearDown() throws Exception {
        conn.close();
    }
    //1st test
    @Test
    public void addingNewsSetsId() throws Exception {
        News testNews = setupNews();
        int originalNewsId = testNews.getId();
        newsDao.add(testNews);
        assertNotEquals(originalNewsId,testNews.getId());
    }
    //2nd test
    @Test
    public void addedNewsAreReturnedFromGetAll() throws Exception {
        News testNews = setupNews();
        newsDao.add(testNews);
        assertEquals(1, newsDao.getAll().size());
    }
    //3rd Test
    @Test
    public void noNewsReturnsEmptyList() throws Exception {
        assertEquals(0, newsDao.getAll().size());
    }
    //4th test
    @Test
    public void deleteByIdDeletesCorrectNews() throws Exception {
        News news = setupNews();
        newsDao.add(news);
        newsDao.deleteById(news.getId());
        assertEquals(0, newsDao.getAll().size());
    }
    //5th test
    @Test
    public void clearAll() throws Exception {
        News testNews = setupNews();
        News otherNews = setupNews();
        newsDao.clearAll();
        assertEquals(0, newsDao.getAll().size());
    }
    //6th tets
    @Test
    public void addNewsToDepartmentAddsTypeCorrectly() throws Exception {
        Departments  testDepartments = setupDepartments();
        departmentsDao.add(testDepartments);
        News testNews = setupNews();
        newsDao.add(testNews);
        newsDao.addNewsToDepartments(testNews, testDepartments ) ;
        assertEquals(1, newsDao.getAllDepartmentsByNews(testNews.getId()).size());
    }
    //7th test
    @Test
    public void deletingDepartmentAlsoUpdatesJoinTable() throws Exception {
        News testNews = setupNews();
        newsDao.add(testNews);
        Departments  testDepartments = setupDepartments();
        departmentsDao.add(testDepartments);
        departmentsDao.addDepartmentsToNews(testDepartments ,testNews);
        departmentsDao.deleteById(testDepartments.getId());
        assertEquals(0, departmentsDao.getAllNewsByDepartments(testDepartments.getId()) .size());
    }
    //Helpers
    public News setupNews(){
        return new News("Sewage","corona") ;
    }
    public Departments setupDepartments (){
        Departments  departments = new Departments("IT", "Programming", 500) ;
        departmentsDao.add(departments);
        return departments ;
    }
}

