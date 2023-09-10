package com.murali.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murali.entity.Plan;

public interface PlaneRepo extends JpaRepository<Plan, Integer> {

}
