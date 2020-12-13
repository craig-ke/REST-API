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
        assertEquals("Craig", testUsers.getName());
    }

    @Test
    public void getPositionReturnsCorrectPosition() throws Exception {
        Users testUsers = setupUsers();
        assertEquals("IT Technician", testUsers.getPosition());
    }

    @Test
    public void getRoleReturnsCorrectRole() throws Exception {
        Users testUsers = setupUsers();
        assertEquals("repair", testUsers.getRole());
    }

    public Users  setupUsers (){
        return new Users("Craig", "IT Technician", "repair", "rmogusu123@gmail.com",2345,"IT",1) ;
    }
}
