package hibernateBasic.day9.associtaion_multipe_class;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Utility;

public class EmployeeDriver {
    public static void main(String[] args) {
        addEmployeeAndDepartment();
//        Session session = Utility.getSession("day9/AssociationEmployee.hbm.xml");
//        Transaction transaction = session.beginTransaction();
//        Department department = new Department();
//        department.setDepId(200);
//        department.setDepartmentName("Development");
//        //session.persist(department);
//        session.persist(new Employee("Emp-1",department));
//        session.close();
//        transaction.commit();
    }
    private static void addEmployeeAndDepartment() {
        Session session = Utility.getSession("day9/AssociationEmployee.hbm.xml");
        Transaction transaction = session.beginTransaction();
        Department department = new Department();
        department.setDepId(1);
        department.setDepartmentName("Finance");
        Employee employee = new Employee();
        employee.setEmployeeName("Name-3");
        employee.setDepartment(department);
        session.persist(department);
        session.persist(employee);
        transaction.commit();
        session.close();
    }
}
