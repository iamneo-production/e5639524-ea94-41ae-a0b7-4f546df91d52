package com.artsandcrafts.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artsandcrafts.dao.AcademyRepo;
import com.artsandcrafts.dao.CourseRepo;
import com.artsandcrafts.model.Academy;
import com.artsandcrafts.model.Course;

@Service
public class AcademyServiceImpl implements AcademyService {
	@Autowired
	AcademyRepo academyRepo;
	@Autowired
	CourseRepo courseRepo;

	@Override
	public Academy addAcademy(Academy academy) {
		return academyRepo.save(academy);
	}

	@Override
	public Academy findByAcademyName(String academyName) {
		return academyRepo.findByAcademyName(academyName);
	}
	@Override
	public Academy findByAcademyId(int academyId) {
		return academyRepo.findByAcademyId(academyId);
	}

	@Override
	public List<Academy> viewAcademy() {
		return academyRepo.findAll();
	}

	@Override
	public String deleteAcademy(int id) {
		List<Course> course = courseRepo.findByAcademyAcademyId(id);
		courseRepo.deleteAll(course);
		academyRepo.deleteById(id);
		return "Deleted id " +id ;
	}

	@Override
	public Academy editAcademy(int academyId, Academy academy) {
		Academy update = academyRepo.findByAcademyId(academyId);

		if(Objects.nonNull(academy.getAcademyName())&&
				!"".equalsIgnoreCase(academy.getAcademyName()))
		{  update.setAcademyName(academy.getAcademyName());
		}
		
		
		if(Objects.nonNull(academy.getAcademyDescription())&&
				!"".equalsIgnoreCase(academy.getAcademyDescription()))
		{  update.setAcademyDescription(academy.getAcademyDescription());
		}
	

		if(Objects.nonNull(academy.getAcademyLocation())&&
				!"".equalsIgnoreCase(academy.getAcademyLocation()))
		{  update.setAcademyLocation(academy.getAcademyLocation());
		}
	

		if(Objects.nonNull(academy.getAcademyMobileNo())&&
				!"".equalsIgnoreCase(academy.getAcademyMobileNo()))
		{  update.setAcademyMobileNo(academy.getAcademyMobileNo());
		}
	

		if(Objects.nonNull(academy.getAcademyEmail())&&
				!"".equalsIgnoreCase(academy.getAcademyEmail()))
		{  update.setAcademyEmail(academy.getAcademyEmail());
		}
	

		if(Objects.nonNull(academy.getAcademyImageUrl())&&
				!"".equalsIgnoreCase(academy.getAcademyImageUrl()))
		{  update.setAcademyImageUrl(academy.getAcademyImageUrl());
		}
	
		return academyRepo.save(update);
	}

	@Override
	public Boolean existsByAcademyName(String academyName) {
		return academyRepo.existsByAcademyName(academyName);
	}
	
}