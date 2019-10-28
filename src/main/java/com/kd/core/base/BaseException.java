package com.kd.core.base;

import javax.xml.bind.annotation.XmlAccessType;   
import javax.xml.bind.annotation.XmlAccessorType;   
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.ws.WebFault;   

@XmlAccessorType(XmlAccessType.FIELD)   
@WebFault(name="BaseFault")   
public class BaseException  extends RuntimeException  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BaseFault details;
	public BaseException(String msg) {
		super(msg);
	}
	public BaseException(String msg, BaseFault details){
		super(msg);
		this.details = details;
	}
	
	public BaseException(BaseFault details) {
		super();
		this.details = details;
	}
	
	public BaseFault getFaultInfo() {
	return details;
	}

	
	
	@XmlRootElement(name = "BaseFault")
	public static class BaseFault {
		private String t;
		public BaseFault() {
		}
		public BaseFault(String t) {
			this.t = t;
		}
		public String getT() {
			return t;
		}
		public void setT(String t) {
			this.t = t;
		}
	}

}

