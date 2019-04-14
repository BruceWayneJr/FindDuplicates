package api.file.dupe;
/**
	Customer class holds all customer data and methods to get specific data
 */
public class Customer {

    private String id;
	private String first_name;
	private String last_name;
	private String company;
	private String email;
	private String address1;
    private String address2;
	private String zip;
	private String city;
	private String state_long;
	private String state;
	private String phone;

    public String getId() {
		return id;
	}
	public String getFirstName() {
		return first_name;
	}
	public String getLastName() {
		return last_name;
	}
	public String getCompany() {
		return company;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress1() {
		return address1;
	}
    public String getAddress2() {
        return address2;
    }
	public String getZip() {
		return zip;
	}
	public String getCity() {
		return city;
	}
	public String getStateLong() {
		return state_long;
	}
	public String getState() {
		return state;
	}
	public String getPhone() {
		return phone;
	}
	
	public Customer(String[] customerData) {
		id = customerData[0];
		first_name = customerData[1];
		last_name = customerData[2];
		company = customerData[3];
		email = customerData[4];
		address1 = customerData[5];
        address2 = customerData[6];
		zip = customerData[7];
		city = customerData[8];
		state_long = customerData[9];
		state = customerData[10];
		phone = customerData[11];
	}	
}