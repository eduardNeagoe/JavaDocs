package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.appl.annotations.MyController;
import ro.teamnet.zth.appl.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;

import java.util.List;

/**
 * Created by Eduard on 14.07.2016.
 */
@MyController(urlPath = "/employees")
public class EmployeeController {
    private  EmployeeDao employeeDao = new EmployeeDao();

//    protected List<String> getAllEmployees(){
//        List<Employee> listEmployees = employeeDao.getAllEmployees();
//        List<String> allEmployees;
//        for(Employee emp:listEmployees){
//            allEmployees.add(emp.getFirstName())
//        }
//
//    }
    @MyRequestMethod(urlPath = "/all") //methodType = "GET" este default, deci redundant
    public String getAllEmployees(){
        return "allEmployees";
    }

    @MyRequestMethod(urlPath = "/one", methodType = "GET")
    public String getOneEmployee(){
        return "oneRandomEmployee";
    }
}
