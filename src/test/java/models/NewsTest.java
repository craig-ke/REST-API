package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class NewsTest {
    //setup
    @Before
    public void setUp() throws Exception {
    }
    //teardown
    @After
    public void tearDown() throws Exception {
    }
    //1st test
    @Test
    public void getGeneral() {
        News testNews = setupNews();
        assertEquals("Economy", testNews.getGeneral());
    }
    //2nd test
    @Test
    public void getDepartment() {
        News testNews = setupNews();
        assertEquals("Rainfall", testNews.getDepartment());
    }
    //3rd test
    @Test
    public void setGeneral() {
        News testNews = setupNews();
        testNews.setGeneral("water") ;
        assertNotEquals("Economy", testNews.getGeneral());
    }
    //4th test
    @Test
    public void setDepartments() {
        News testNews = setupNews();
        testNews.setDepartment("Sewage"); ;
        assertNotEquals("Rainfall", testNews.getDepartment());
    }
    //5th Test
    @Test
    public void setId() {
        News testNews = setupNews();
        testNews.setId(5);
        assertEquals(5, testNews.getId());
    }

    // helper
    public News  setupNews(){
        return new News("Economy","Rainfall");
    }
}