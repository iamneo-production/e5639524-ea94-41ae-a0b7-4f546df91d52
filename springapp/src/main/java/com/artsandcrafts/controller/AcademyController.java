
package com.artsandcrafts.controller;
import com.springbootbidyut.springbootdemo.entity.AcademyModel;

import com.springbootbidyut.springbootdemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000")
@RestController
public class AcademyController {

    @Autowired
   private AdminService AdminService;

    @PostMapping("/admin/addInstitute")
    public AcademyModel addAcademy(@RequestBody AcademyModel myAcademy){
        return AdminService.AddAcademy(myAcademy);
    }


}

