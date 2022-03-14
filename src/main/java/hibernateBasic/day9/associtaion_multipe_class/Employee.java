package hibernateBasic.day9.associtaion_multipe_class;

public class Employee {
    private Integer employeeId;
    private String employeeName;
    private Department department;

    public Employee() {
    }

    public Employee(String employeeName, Department department) {
        this.employeeName = employeeName;
        this.department = department;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
