package com.luv2code.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor:" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!!!!!!";
    }








    // I wrote this part
    @Override
    public void getBreakfast(){
        System.out.println("get some sandwiches");
    }
    @Override
    public void getStars(){
        for(int i = 5;i > 0;i--){
            int a = i;
            while (a>0){
                System.out.print("*");
                a--;
            }
            System.out.println();
        }
    }

}
