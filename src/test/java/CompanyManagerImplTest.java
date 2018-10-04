import org.junit.Test;

import java.util.*;
import java.text.*;
//import java.text.SimpleDateFormat;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CompanyManagerImplTest {
    CompanyManager companyManager;
    Employee employee;
    Company company;

    @org.junit.Before
    public void setUp(){
        //String date = "Sat, 23 Jun 2012 00:00:00 +0000";

        //SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
        //SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
        //Date datex = df2.format(date);

        this.companyManager = new CompanyManagerImpl();
        this.companyManager.addCompany("VM","companyVM");
        //this.companyManager.addEmployee("Victor","Pinon",26/05/1997,1000,"VM");
    }



    @Test
    public void employees() {
        List<Employee> employeeList =this.companyManager.employees("VM");

    }

    @org.junit.After
    public void tearDown(){
        companyManager = new CompanyManagerImpl();
    }
}