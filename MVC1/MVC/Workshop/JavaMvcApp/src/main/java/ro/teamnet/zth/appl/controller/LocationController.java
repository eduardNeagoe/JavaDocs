package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.appl.annotations.MyController;
import ro.teamnet.zth.appl.annotations.MyRequestMethod;

/**
 * Created by Eduard on 15.07.2016.
 */


@MyController(urlPath =  "/locations")
public class LocationController {

    @MyRequestMethod(urlPath = "/all", methodType = "GET")
    public String getAllLocations(){
        return "allLocations";
    }

    @MyRequestMethod(urlPath = "/one", methodType = "GET")
    public String getOneLocation(){
        return "oneRandomLocation";
    }
}
