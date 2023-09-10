package com.murali.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murali.entity.Plan;
import com.murali.entity.PlanCategory;
import com.murali.repo.PlanCategoryRepo;
import com.murali.repo.PlaneRepo;
@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	private PlaneRepo planrepo;
	@Autowired
	private PlanCategoryRepo planCategoryrepo;

	@Override	
	public Map<Integer, String> getPlanCategories() {
		
		List<PlanCategory> catagories = planCategoryrepo.findAll();
		
		Map<Integer,String> catagoryMap = new HashMap<>();
		
		catagories.forEach(catagory -> {
			
			catagoryMap.put(catagory.getCategoryID(),catagory.getCategoryname());
			
		});
		
		return catagoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		
		Plan saved = planrepo.save(plan);
		
//		if(saved.getPlanId()!= null) {
//			
//			return true;
//		}
//		else {
//			
//			return false;
//		}
		//return saved.getPlanId() != null ? true : false;
		
		return saved.getPlanId() != null;
	}

	@Override
	public List<Plan> getAllPlans() {
		 
		return planrepo.findAll();
		
	}

	@Override
	public Plan getPlanById(Integer planId) {
		
		Optional<Plan> findById = planrepo.findById(planId);
		
		if(findById.isPresent()) {
			
			return findById.get();
		}
		
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		Plan save = planrepo.save(plan);//upsert
		return save.getPlanId()!=null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		
		boolean status = false;
		try {
			planrepo.deleteById(planId);
			status = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		Optional<Plan> findById = planrepo.findById(planId);
		 if(findById.isPresent()) {
			 Plan plan = findById.get();
			 plan.setActiveSw(status);
			 planrepo.save(plan);
			 return true;
			 
		 }
		    return false;
		
	}

}
