import java.util.*;

public class CompanyManagerImpl implements CompanyManager {
    private Map<String,Company> companyMap = new HashMap<String, Company>();
    private List<Employee> employeeList = new LinkedList<Employee>();

    public void addCompany(String companyName, String description){
        Company x = new Company(companyName,description);
        companyMap.put(x.getCompanyName(), x);
    }

    public void addEmployee(String name, String surname, Date birthday, double salary, String companyName){

        if (companyMap.get(companyName) == null){
            throw new MyException("Could not find this company");
        } else {
            Employee e = new Employee(name,surname,birthday,salary,companyName);
            employeeList.add(e);
        }
    }

    public List<Employee> findAllEmployeesOrderedByName(){
        List<Employee> employeesOrderedByName = new LinkedList<Employee>();
        for(Employee employee:employeeList)
        {
            employeesOrderedByName.add(employee);
        }
        Collections.sort(employeesOrderedByName, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
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
        List<Employee> employees = new LinkedList<Employee>();
        for (Employee e:employeeList){
            if (e.getCompanyName()==company){
                employees.add(e);
            }
        }
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