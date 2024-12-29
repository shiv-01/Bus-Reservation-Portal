package com.cg.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bus.Feedback;
@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {
	
}
