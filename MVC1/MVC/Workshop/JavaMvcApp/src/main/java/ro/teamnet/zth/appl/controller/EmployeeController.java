package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.appl.annotations.MyController;
import ro.teamnet.zth.appl.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.annotations.MyRequestParam;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.service.EmployeeService;
import ro.teamnet.zth.service.EmployeeServiceImpl;
import java.util.List;

/**
 * Created by Eduard on 14.07.2016.
 */

//Test for Jenkins
@MyController(urlPath = "/employees")
public class EmployeeController {
//    private  EmployeeDao employeeDao = new EmployeeDao();
private final EmployeeService employeeService  = new EmployeeServiceImpl();


    @MyRequestMethod(urlPath = "/all") //methodType = "GET" este default, deci redundant
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @MyRequestMethod(urlPath = "/one", methodType = "GET")
    public Employee getOneEmployee(@MyRequestParam(name = "id") Long employeeId){
        return employeeService.findOneEmployee(employeeId);
    }

    @MyRequestMethod(urlPath = "/delete", methodType = "DELETE")
    public void deleteOneEmployee(@MyRequestParam(name = "id") Long id){
         employeeService.deleteEmployee(id);
    }

    @MyRequestMethod(urlPath = "/insert", methodType = "POST")
    public Employee saveEmployee(Employee employee){
        return employeeService.insertEmployee(employee);
    }
}
