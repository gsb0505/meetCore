package com.kd.core.dto;

public class Config  implements Comparable<Config>{
	
	private String accountId;
	
	private String discount;
	
	private String weight;
	
	private String speed_ratio;
	
	private String quality_ratio;
	
	private String oper_name;
	
	private String onOff;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}



	public String getSpeed_ratio() {
		return speed_ratio;
	}

	public void setSpeed_ratio(String speed_ratio) {
		this.speed_ratio = speed_ratio;
	}

	public String getQuality_ratio() {
		return quality_ratio;
	}

	public void setQuality_ratio(String quality_ratio) {
		this.quality_ratio = quality_ratio;
	}
	
	public String getOper_name() {
		return oper_name;
	}

	public void setOper_name(String oper_name) {
		this.oper_name = oper_name;
	}

	
	public String getOnOff() {
		return onOff;
	}

	public void setOnOff(String onOff) {
		this.onOff = onOff;
	}

	public Config(String accountId, String discount, String weight,
			String speed_ratio, String quality_ratio, String oper_name,String onOff) {
		super();
		this.accountId = accountId;
		this.discount = discount;
		this.weight = weight;
		this.speed_ratio = speed_ratio;
		this.quality_ratio = quality_ratio;
		this.oper_name = oper_name;
		this.onOff=onOff;
	}

	@Override
	public int compareTo(Config config) {
		if(config.getOper_name().equals("1101")){  
			if(this.quality_ratio.compareTo(config.getQuality_ratio())<0){
				return 1;
			}else if(this.quality_ratio.compareTo(config.getQuality_ratio())>0){
				return -1;
			}else{
				if(this.weight.compareTo(config.getWeight())<0){
					return 1;
				}else{
					return -1;
				}
			}
		}else if(config.getOper_name().equals("1102")){
			if(this.discount.compareTo(config.getDiscount())>0){
				return 1;
			}else if(this.discount.compareTo(config.getDiscount())<0){
				return -1;
			}else{
				if(this.weight.compareTo(config.getWeight())<0){
					return 1;
				}else{
					return -1;
				}
			}
		}else{
			if(this.speed_ratio.compareTo(config.getSpeed_ratio())<0){
				return 1;
			}else if(this.speed_ratio.compareTo(config.getSpeed_ratio())>0){
				return -1;
			}else{
				if(this.weight.compareTo(config.getWeight())<0){
					return 1;
				}else{
					return -1;
				}
			}
		}
	}

	public Config() {
		super();
	}
	
}
