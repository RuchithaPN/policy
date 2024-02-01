package com.policy.Main;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="Policy")
public class ClientPolicy {
	
	@Id
	private Integer policyNo;
	private String policyName;
	private String policyBenefits;
	private Integer tenure;
	private Integer premium;
	public Integer getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(Integer policyNo) {
		this.policyNo = policyNo;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyBenefits() {
		return policyBenefits;
	}
	public void setPolicyBenefits(String policyBenefits) {
		this.policyBenefits = policyBenefits;
	}
	public Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	public Integer getPremium() {
		return premium;
	}
	public void setPremium(Integer premium) {
		this.premium = premium;
	}
	
}