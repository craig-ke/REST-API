package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DepartmentsTests {
    //Setup
    @Before
    public void setUp() throws Exception {
    }
    //Teardown
    @After
    public void tearDown() throws Exception {
    }
    //1st test
    @Test
    public void getNameReturnsCorrectName() throws Exception {
        Departments  testDepartments = setupDepartments();
        assertEquals("IT", testDepartments.getName());
    }
    //2nd test
    @Test
    public void getDescriptionReturnsCorrectDescription() throws Exception {
        Departments  testDepartments = setupDepartments();
        assertEquals("Technician support", testDepartments.getDescription());
    }
    //3rd test
    @Test
    public void getTotalNumberReturnsCorrectTotalNumber() throws Exception {
        Departments  testDepartments = setupDepartments();
        assertEquals(250, testDepartments.getTotalNumber());
    }
    //4th test
    @Test
    public void setNameSetsCorrectName() throws Exception {
        Departments  testDepartments = setupDepartments();
        testDepartments.setName("Accounts") ;
        assertNotEquals("IT",testDepartments.getName() );
    }
    //5th test
    @Test
    public void setDescriptionSetsCorrectDescription() throws Exception {
        Departments  testDepartments = setupDepartments();
        testDepartments.setDescription("Financial operations") ;
        assertNotEquals("Technician support",testDepartments.getDescription());
    }
    //6th test
    public Departments  setupDepartments (){
        return new Departments("IT", "Technician support", 250) ;
    }
}

