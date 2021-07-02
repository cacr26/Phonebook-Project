package phonebookproject.real;

public class Address extends Person {

	private String streetAddress;
	private String cityName;
	private String stateName;
	private String zipCode;

	
	

	public Address(String fullName, String streetAddress, String cityName, String stateName, String zipCode) {
		super(fullName);
		this.streetAddress = streetAddress;
		this.cityName = cityName;
		this.stateName = stateName;
		this.zipCode = zipCode;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getCityName() {
		return cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	

}
