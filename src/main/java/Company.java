import java.util.LinkedList;
import java.util.List;

public class Company {
    public String companyName;
    public String description;
    private List<Employee> employeeList;

    public Company(String companyName, String description){
        this.companyName = companyName;
        this.description = description;
        this.employeeList=new LinkedList<Employee>();
    }

    public Company(){

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addEmployee(Employee e) {
        this.employeeList.add(e);
    }

    public List<Employee> getEmployees() {
        return this.employeeList;
    }
}
