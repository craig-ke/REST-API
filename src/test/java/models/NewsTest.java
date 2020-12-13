package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

    // helper
    public News  setupNews(){
        return new News("Economy","Rainfall");
    }
}