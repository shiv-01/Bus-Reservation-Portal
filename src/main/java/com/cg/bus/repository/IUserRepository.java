package com.cg.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bus.Users;

@Repository
public interface IUserRepository extends JpaRepository<Users, Integer>{

}
