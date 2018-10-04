import java.util.Date;
import java.util.List;

public interface CompanyManager {
    public void addCompany(String companyName, String description);
    public void addEmployee(String name, String surname, Date birthday, double salary, String companyName) throws CompanyNotFoundException;
    public List<Employee> findAllEmployeesOrderedByName();
    public List<Employee> findAllEmployeesOrderedBySalary();
    public List<Employee> employees(String company);
    public List<Company> findAllCompanies();
}
