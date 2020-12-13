package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UsersTest {
    //setup
    @Before
    public void  setUp() throws Exception{
    }
   //Teardown
    @After
    public void teardown() throws Exception{
    }
//1st Test
    @Test
    public void getNameReturnsCorrectName() throws Exception {
        Users  testUsers = setupUsers();
        assertEquals("Craig", testUsers.getName());
    }
//2nd Test
    @Test
    public void getPositionReturnsCorrectPosition() throws Exception {
        Users testUsers = setupUsers();
        assertEquals("IT Technician", testUsers.getPosition());
    }
//3rd
    @Test
    public void getRoleReturnsCorrectRole() throws Exception {
        Users testUsers = setupUsers();
        assertEquals("repair", testUsers.getRole());
    }
//4th
    @Test
    public void getEmailReturnsCorrectEmail() throws Exception {
        Users testUsers = setupUsers();
        assertEquals("rmogusu123@gmail.com", testUsers.getEmail());
    }
//5th
    @Test
    public void getBadgeNoReturnsCorrectBadgeNo() throws Exception {
        Users testUsers = setupUsers();
        assertEquals(2345, testUsers.getBadgeNo());
    }
//6th
    @Test
    public void getDepartmentReturnsCorrectDepartment() throws Exception {
        Users testUsers = setupUsers();
        assertEquals("IT", testUsers.getDepartment());
    }
//7th
    @Test
    public void setNameSetsCorrectName() throws Exception {
        Users  testUsers = setupUsers();
        testUsers.setName("Rose");
        assertNotEquals("Faith",testUsers.getName());
    }
//8th
    @Test
    public void setPositionSetsCorrectPosition() throws Exception {
        Users  testUsers = setupUsers();
        testUsers.setPosition("Accountant") ;
        assertNotEquals("IT Technician",testUsers.getPosition());
    }
//9th
    @Test
    public void setRoleSetsCorrectRole() throws Exception {
        Users  testUsers = setupUsers();
        testUsers.setRole("Financial operations") ;
        assertNotEquals("repair",testUsers.getRole());
    }
//10th
    @Test
    public void setBadgeNoSetsCorrectBadgeNo() throws Exception {
        Users  testUsers = setupUsers();
        testUsers.setBadgeNo(5432) ;
        assertNotEquals(2345,testUsers.getBadgeNo());
    }
//11th
    @Test
    public void setDepartmentSetsCorrectDepartment() throws Exception {
        Users  testUsers = setupUsers();
        testUsers.setDepartment("Accountant") ;
        assertNotEquals("IT",testUsers.getDepartment() );
    }
//12th
    @Test
    public void getDepartmentId() {
        Users  testUsers = setupUsers();
        assertEquals(1, testUsers.getDepartmentId());
    }
//13th
@Test
public void setDepartmentId() {
    Users  testUsers = setupUsers();
    testUsers.setDepartmentId(10);
    assertNotEquals(1, testUsers.getDepartmentId());
}
//14th
@Test
public void setId() {
    Users  testUsers = setupUsers();
    testUsers.setId(5);
    assertEquals(5, testUsers .getId());
}
//pairs with first test(Helper)
    public Users  setupUsers (){
        return new Users("Craig", "IT Technician", "repair", "rmogusu123@gmail.com",2345,"IT",1) ;
    }
}
