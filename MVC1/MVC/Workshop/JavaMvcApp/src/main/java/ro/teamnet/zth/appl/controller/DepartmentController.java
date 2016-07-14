package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.appl.annotations.MyController;
import ro.teamnet.zth.appl.annotations.MyRequestMethod;

/**
 * Created by Eduard on 14.07.2016.
 */
@MyController(urlPath =  "/departments")
public class DepartmentController {

    @MyRequestMethod(urlPath = "/all", methodType = "GET")
    public String getAllDepartments(){
        return "allDepartments";
    }

    @MyRequestMethod(urlPath = "/one", methodType = "GET")
    public String getOneDepartment(){
        return "oneRandomDepartment";
    }
}
