package com.policy.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.Client.AuthClient;
import com.policy.Exception.PolicyNotFoundException;
import com.policy.Exception.TokenExpireException;
import com.policy.Main.ClientPolicy;
import com.policy.Main.PolicyProvider;
import com.policy.Repository.PolicyProviderRepository;
import com.policy.Repository.PolicyRepository;

@Service
public class PolicyService {
	@Autowired
	PolicyRepository policyrepo;
	@Autowired
	PolicyProviderRepository policyProviderRepository;
	@Autowired
	AuthClient authClient;
	public Integer getEligibleClaimAmount(Integer policyId) throws PolicyNotFoundException {
		ClientPolicy policy = policyrepo.findById(policyId).orElse(null);
		if(policy==null)
			throw new PolicyNotFoundException("Policy not found");
		else
			return policy.getTenure();
	}
	public String getEligibleBenefits(Integer policyId, String token) throws PolicyNotFoundException, TokenExpireException {
		if(authClient.authorizeTheRequest(token)) {
		ClientPolicy policy = policyrepo.findById(policyId).orElse(null);
		if(policy==null)
			throw new PolicyNotFoundException("Policy not found");
		else
			return policy.getPolicyBenefits();
		}
		else
		{
			throw new TokenExpireException("Token is expired");
		}
	}
	//PolicyProviderRepository policyProviderRepository;
	public List<PolicyProvider> getAllPolicyProviders(Integer policyId){
		List<PolicyProvider> list= policyProviderRepository.getAllPolicyProviders(policyId);
		return list;
		
	}

}
