package prototype;

public class protoJSON {
	
	private String employeeNo;
	private String name;
	private String personId;
	private String number;
	private String address;
	
	
	public protoJSON(String employeeNo, String name, String personId, String number, String address) {
		// TODO Auto-generated constructor stub
		this.employeeNo = employeeNo;
		this.name = name;
		this.personId = personId;
		this.number = number;
		this.address = address;
	}

	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	
}
