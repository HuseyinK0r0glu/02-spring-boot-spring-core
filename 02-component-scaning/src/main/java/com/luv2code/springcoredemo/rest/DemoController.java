package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;

    // define a constructor for dependency injection
    @Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }







    // I wrote this part
    // When I reload the page(http://localhost:8080/breakfast) get some sandwiches got written on the screen
    @GetMapping("/breakfast")
    public void getBreakfast(){
        myCoach.getBreakfast();
    }
    @GetMapping("/starGame")
    public void getStars(){
        myCoach.getStars();
    }


}
