package ro.teamnet.zth.service;

import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;

import java.util.List;

/**
 * Created by Eduard on 15.07.2016.
 */
public class EmployeeServiceImpl implements EmployeeService{
    public EmployeeDao employeeDao = new EmployeeDao();

    @Override
    public List<Employee> getAllEmployees(){
        List<Employee> listEmployees = employeeDao.getAllEmployees();
        return listEmployees;
    }

    @Override
    public Employee findOneEmployee(Long id) {
       return employeeDao.getEmployeeById(id);
    }

    @Override
    public void deleteEmployee(Long id) {
//        Long id = new Long(employee.getId());

        employeeDao.deleteEmployee(employeeDao.getEmployeeById(id));

    }

    @Override
    public Employee insertEmployee(Employee employee) {
        return employeeDao.insertEmployee(employee);
    }
}
