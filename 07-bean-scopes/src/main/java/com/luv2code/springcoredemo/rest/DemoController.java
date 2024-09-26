package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;

    // define a constructor for dependency injection


    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("In constructor:" + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;

        // I wrote this part
        // if the scope is singleton myCoach and anotherCoach are the same but if the scope is prototype then they are different
        // because singleton creates a single shared instance, prototype creates a new bean for each request
        /*if (myCoach == anotherCoach) {
            System.out.println("it is same");
        }else{
            System.out.println("it is different");
        }*/
    }

    /*
    @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }*/

    // we can use any method name it does not have to be set
    // it would work as well
    /*@Autowired
    public void hk(Coach theCoach){
        myCoach = theCoach;
    }*/

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    // for singleton(default) (myCoach == anotherCoach) is going to be true but for prototype it is going to be false
    @GetMapping("/check")
    public String check(){
        return "Comparing Beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
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
