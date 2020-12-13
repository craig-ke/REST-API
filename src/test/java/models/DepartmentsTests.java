package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    //3rd test
    //4th test
    //5th test
    //6th test
    public Departments  setupDepartments (){
        return new Departments("IT", "Technician support", 250) ;
    }
}

