package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsersTest {
    @Before
    public void  setUp() throws Exception{
    }

    @After
    public void teardown() throws Exception{
    }

    @Test
    public void getNameReturnsCorrectName() throws Exception {
        Users  testUsers = setupUsers();
        assertEquals("Faith", testUsers.getName());
    }

    public Users  setupUsers (){
        return new Users("Faith", "IT Technician", "repair", "rmogusu123@gmail.com",2345,"IT",1) ;
    }
}
