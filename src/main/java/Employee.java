import java.util.Date;

public class Employee {
    public String name;
    public String surname;
    public Date birthday;
    //public String birthday;
    public double salary;
    public String companyName;

    public Employee(String name, String surname, Date birthday, double salary, String companyName) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.salary = salary;
        this.companyName = companyName;
    }

    public Employee(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /*public String getBirthday(){return birthday;}*/

    /*public void setBirthday(String birthday){this.birthday = birthday;}*/

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
