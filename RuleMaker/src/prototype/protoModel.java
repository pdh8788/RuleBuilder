package prototype;

import javax.xml.bind.annotation.XmlElement;

import javafx.beans.property.SimpleStringProperty;

public class protoModel {
	
	private SimpleStringProperty name;
	private SimpleStringProperty personId;
	private SimpleStringProperty number;
	private SimpleStringProperty address;
	
	public protoModel() {
		// TODO Auto-generated constructor stub
	}
	
	public protoModel(String name, String personId, String number, String address) {
		this.name = new SimpleStringProperty(name);
		this.personId = new SimpleStringProperty(personId);
		this.number = new SimpleStringProperty(number);
		this.address = new SimpleStringProperty(address);
		
	}
	
	
	public String getName() {
		return name.get();
	}

	@XmlElement(name ="name")
	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getPersonId() {
		return personId.get();
	}

	@XmlElement(name ="personId")
	public void setPersonId(String personId) {
		this.name.set(personId);
	}
	
	public String getNumber() {
		return number.get();
	}

	@XmlElement(name ="number")
	public void setNumber(String number) {
		this.number.set(number);
	}
	
	public String getAddress() {
		return address.get();
	}

	@XmlElement(name ="address")
	public void setAddress(String address) {
		this.address.set(address);
	}
	
}
