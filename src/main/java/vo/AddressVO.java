package vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class AddressVO {
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	@Lob
	@Column(name="address_line")
	private String addressLine;
	
	public AddressVO() {}
	
	public AddressVO(String city, String state, String pincode, String addressLine) {
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.addressLine = addressLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
}
