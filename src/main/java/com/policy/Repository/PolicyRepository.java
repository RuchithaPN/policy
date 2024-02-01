package com.policy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.policy.Main.ClientPolicy;

public interface PolicyRepository extends JpaRepository<ClientPolicy, Integer>{
	
}