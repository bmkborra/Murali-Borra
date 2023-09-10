package com.murali.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.murali.entity.Plan;
import com.murali.service.PlanService;

@RestController
public class PlanRestController {
	
	@Autowired
	private PlanService planService;
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer,String>> PlanCategories(){
		
		Map<Integer, String> planCategories = planService.getPlanCategories();
		
		return new ResponseEntity<>(planCategories, HttpStatus.OK);
	}
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		
		boolean isSaved = planService.savePlan(plan);
		
		String responseMsg = "";
		
		if(isSaved) {
			
			responseMsg = "Plan Saved";
		}
		else {
			
			responseMsg = "Plan not Saved";
		}
		
		return new  ResponseEntity <>(responseMsg, HttpStatus.CREATED);	
		
	}
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans(){
		
	   List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans,HttpStatus.OK);
			
	}
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan( @PathVariable Integer  planId){
		
		Plan plan = planService.getPlanById(planId);
		return new ResponseEntity<Plan>(plan , HttpStatus.OK);
			
	}
	   
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody   Plan plan){
		boolean isupdated = planService.updatePlan(plan);
		
         String msg = "";
		 if(isupdated) {
			
			msg = "Plan Updated";	
			}
		else {
			msg = "Plan Not Updated";
		}
		return new ResponseEntity<String>(msg , HttpStatus.OK);
		
	}
	
	
	 @DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable  Integer planId){
		
		boolean isdeleted = planService.deletePlanById(planId);
		
		String msg = "";
		
		if(isdeleted) {
			
			msg = "Plan Deleted";	
		}
		else {
			
			msg = "Plan Not deleted";
		}
		
		return new ResponseEntity<String>(msg , HttpStatus.OK);
	}
	 @PutMapping("/status-change/{planId}/{status}")
	 public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status){
		  
		 boolean isplanStatusChanged = planService.planStatusChange(planId, status);
		 
		 String msg = "";
			
			if(isplanStatusChanged) {
				
				msg = "Plan StatusChanged";	
			}
			else {
				
				msg = "Plan Not StatusChanged";
			}
			
			return new ResponseEntity<String>(msg , HttpStatus.OK);
		 
	 }
	
	
	
	
	
	
	
	
	
	

}
