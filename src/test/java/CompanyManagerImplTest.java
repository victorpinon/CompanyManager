import org.apache.log4j.Logger;
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

    //aixo es pel warning amb log4j
    final Logger log = Logger.getLogger(CompanyManagerImpl.class);

    @org.junit.Before
    public void setUp(){
        //String date = "Sat, 23 Jun 2012 00:00:00 +0000";

        //SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
        //SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
        //Date datex = df2.format(date);

        this.companyManager = new CompanyManagerImpl();

        this.companyManager.addCompany("VM", "companyVM");
        this.companyManager.addCompany("Pastanaga","PastanagaDelCampSL");
        this.companyManager.addCompany("Patata","PatataFregidaSA");

        try {
            this.companyManager.addEmployee("Victor", "Pinon", new Date(), 1100, "VM");
            this.companyManager.addEmployee("Meritxell", "Basart", new Date(), 1000, "VM");
            this.companyManager.addEmployee("Pep","Perez",new Date(),1500,"Pastanaga");
            this.companyManager.addEmployee("Marta","Blanca",new Date(),1400,"Pastanaga");
            this.companyManager.addEmployee("Lucia","Martinez",new Date(),1300,"Patata");
            this.companyManager.addEmployee("Josep","Casavella",new Date(),900,"Patata");
        } catch (CompanyNotFoundException e){
            log.warn("Error en els employees" +e.getMessage());
        }
    }

    @Test
    public void employees() {
        List<Employee> employeeList =this.companyManager.employees("VM");
        assertEquals(employeeList.get(0).name,"Victor");
        assertEquals(employeeList.get(1).name,"Meritxell");
    }

    @Test
    public void findAllCompanies(){
        List<Company> companyList = this.companyManager.findAllCompanies();
        assertEquals(companyList.get(0).companyName,"Pastanaga");
        assertEquals(companyList.get(1).companyName,"VM");
        assertEquals(companyList.get(2).companyName,"Patata");
    }

    @Test
    public void findAllEmployeesOrderedBySalary(){
        List<Employee> employeeList2 = this.companyManager.findAllEmployeesOrderedBySalary();
        assertNotEquals(employeeList2.get(0).salary,800,0);
        assertEquals(employeeList2.get(1).salary,1000,0);
        assertEquals(employeeList2.get(2).salary,1100,0);
        assertNotEquals(employeeList2.get(3).salary,1200,0);
        assertEquals(employeeList2.get(4).salary,1400,0);
        assertNotEquals(employeeList2.get(5).salary,1600,0);
    }

    @Test
    public void findAllEmployeesOrderedByName(){
        List<Employee> employeeList3 = this.companyManager.findAllEmployeesOrderedByName();
        assertEquals(employeeList3.get(0).name,"Josep");
        assertEquals(employeeList3.get(1).name,"Lucia");
        assertEquals(employeeList3.get(2).name,"Marta");
        assertEquals(employeeList3.get(3).name,"Meritxell");
        assertEquals(employeeList3.get(4).name,"Pep");
        assertEquals(employeeList3.get(5).name,"Victor");
    }

    @org.junit.After
    public void tearDown(){
        companyManager = null;
    }
}