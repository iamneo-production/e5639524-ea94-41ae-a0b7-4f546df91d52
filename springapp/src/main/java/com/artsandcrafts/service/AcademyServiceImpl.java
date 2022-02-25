package com.artsandcrafts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artsandcrafts.dao.AcademyRepo;
import com.artsandcrafts.model.Academy;

@Service
public class AcademyServiceImpl implements AcademyService {
	@Autowired
	AcademyRepo academyRepo;

	@Override
	public Academy addAcademy(Academy academy) {
		return academyRepo.save(academy);
	}

	@Override
	public List<Academy> findByAcademyName(String academyName) {
		return academyRepo.findByAcademyName(academyName);
	}
	@Override
	public List<Academy> findByAcademyId(int academyId) {
		return academyRepo.findByAcademyId(academyId);
	}

	@Override
	public List<Academy> viewAcademy() {
		return academyRepo.findAll();
	}

	@Override
	public String deleteAcademy(int id) {
		academyRepo.deleteById(id);
		return "Deleted id " +id ;
	}
	
}
