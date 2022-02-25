package com.artsandcrafts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.artsandcrafts.model.Academy;
import com.artsandcrafts.service.AcademyService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AcademyController {
	@Autowired
	AcademyService academyService;
	
	@PostMapping("/addAcademy")
	public Academy addAcademy(@RequestBody Academy academy) {
	    return academyService.addAcademy(academy);
	}
	
	@GetMapping("/viewAcademy")
	public List<Academy> viewAcademy() {
		return academyService.viewAcademy();
	}
	
	@GetMapping("/findByAcademy")
    public List<Academy> findByAcademyName(@RequestParam("name") String academyName)
    {
        return academyService.findByAcademyName(academyName);
    }
	
	@GetMapping("/findAcademy")
    public List<Academy> findByAcademyId(@RequestParam("id") int academyId)
    {
        return academyService.findByAcademyId(academyId);
    }
	
	@DeleteMapping("/deleteAcademy")
    public String deleteAcademy(@RequestParam("id") int id)
    {
        return academyService.deleteAcademy(id);
    }
	
}
