package com.policy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.policy.Exception.PolicyNotFoundException;
import com.policy.Exception.TokenExpireException;
import com.policy.Main.PolicyProvider;
import com.policy.Service.PolicyService;

@RestController
public class PolicyController {
	@Autowired
	PolicyService service;
	@GetMapping(value="/geteligibleclaimamount/{policyId}")
	public Integer getEligibleClaimAmount(@PathVariable("policyId") Integer policyId) throws PolicyNotFoundException {
		return service.getEligibleClaimAmount(policyId);
	}
	
	@GetMapping(value="/geteligiblebenefits/{policyId}")
	public String getEligibleBenefits(@PathVariable("policyId") Integer policyId,
			@RequestHeader("Authorization") String token) throws PolicyNotFoundException, TokenExpireException{
		return service.getEligibleBenefits(policyId,token);
	}
	@GetMapping(value="/getallproviders/{policyId}")
	public List<PolicyProvider> getAllPolicyProviders(@PathVariable("policyId")Integer policyId){
		return service.getAllPolicyProviders(policyId);
	}
}