public class Company {
    String companyName;
    String description;

    public Company(String companyName, String description){
        this.companyName = companyName;
        this.description = description;
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
}
