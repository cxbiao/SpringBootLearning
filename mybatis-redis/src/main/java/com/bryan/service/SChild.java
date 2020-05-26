package com.bryan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SChild extends  SCParent{

;

    @Autowired
    public void testB(List<Student> ls){
        System.out.println(ls);
    }

}
