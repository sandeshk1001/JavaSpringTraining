package hibernateBasic.day9.associtaion_multipe_class;

public class Department {
    private Integer depId;
    private String departmentName;

    public Department() {
    }

    public Department(Integer depId, String departmentName) {
        this.depId = depId;
        this.departmentName = departmentName;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer id) {
        this.depId = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

}
