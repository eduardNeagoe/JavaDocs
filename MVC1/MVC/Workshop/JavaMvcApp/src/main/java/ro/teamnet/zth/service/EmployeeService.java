package ro.teamnet.zth.service;

import ro.teamnet.zth.appl.domain.Employee;

import java.util.List;

/**
 * Created by Eduard on 15.07.2016.
 */
public interface EmployeeService {

     List<Employee> getAllEmployees();
     Employee findOneEmployee(Long id);
     void deleteEmployee(Long id);
}
