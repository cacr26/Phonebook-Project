package phonebookproject.real;

public class ContactInfo extends Address {
	
	private String phoneNumber;

	

	public ContactInfo(String fullName, String streetAddress, String cityName, String stateName, String zipCode,
			String phoneNumber) {
		super(fullName, streetAddress, cityName, stateName, zipCode);
		this.phoneNumber = phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhone() {
		return "(" + phoneNumber.charAt(1) + phoneNumber.charAt(2) +
				phoneNumber.charAt(3) + ")-" + phoneNumber.charAt(4) +
				phoneNumber.charAt(5) + phoneNumber.charAt(6) + "-" +
				phoneNumber.charAt(7) + phoneNumber.charAt(8) + 
				phoneNumber.charAt(9) + phoneNumber.charAt(10);
	}

	

	@Override
	public String toString() {
		return getFullName() + "," 
				+ getStreetAddress() +"," + getCityName() + "," + getStateName()+
				"," + getZipCode() + ", " + getPhone();
				
	}

	
}
