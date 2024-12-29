package com.cg.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bus.Admin;
@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer>{
	

}
