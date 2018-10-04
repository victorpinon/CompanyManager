import java.util.*;
import org.apache.log4j.Logger;

public class CompanyManagerImpl implements CompanyManager {
    private Map<String,Company> companyMap = new HashMap<String, Company>();
    private List<Employee> employeeList = new LinkedList<Employee>();

    //aixo es pel warning amb log4j
    final Logger log = Logger.getLogger(CompanyManagerImpl.class);

    public void addCompany(String companyName, String description){
        Company x = new Company(companyName,description);
        companyMap.put(x.getCompanyName(), x);
    }

    public void addEmployee(String name, String surname, Date birthday, double salary, String companyName) throws CompanyNotFoundException{
        Company c = this.companyMap.get(companyName);
        if (c== null){
            // log.warn()
            log.warn("Error! This company do no exist");
            throw new CompanyNotFoundException("Could not find this company");
        } else {
            Employee e = new Employee(name,surname,birthday,salary,companyName);
            employeeList.add(e);
            c.addEmployee(e);
        }
    }

    public List<Employee> findAllEmployeesOrderedByName(){
        List<Employee> employeesOrderedByName = new LinkedList<Employee>();
        employeesOrderedByName.addAll(this.employeeList);
        return employeesOrderedByName;
    }

    public List<Employee> findAllEmployeesOrderedBySalary(){
        List<Employee> employeesOrderedBySalary = new LinkedList<Employee>();
        for(Employee employee:employeeList)
        {
            employeesOrderedBySalary.add(employee);
        }
        Collections.sort(employeesOrderedBySalary, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {

                return (int)(o1.getSalary()-o2.getSalary());
            }
        });
        return employeesOrderedBySalary;
    }

    public List<Employee> employees(String company){
        //faltaria fer una expecio per si la empresa no existeix
        Company c = this.companyMap.get(company);
        List<Employee> employees = c.getEmployees();
        return employees;
    }

    public List<Company> findAllCompanies(){
        List<Company> companies = new LinkedList<Company>();
        for(Map.Entry<String, Company> entry : companyMap.entrySet()) {
            Company x = entry.getValue();
            companies.add(x);
        }
        return companies;
    }

}