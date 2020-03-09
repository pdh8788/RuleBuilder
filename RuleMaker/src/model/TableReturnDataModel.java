package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableBooleanValue;

public class TableReturnDataModel {
	private SimpleStringProperty name;
	private SimpleStringProperty type;
	private SimpleBooleanProperty check;
	
	public TableReturnDataModel() {
		// TODO Auto-generated constructor stub
	}
	
	public TableReturnDataModel(String name, String type, Boolean check)
	{
		this.name = new SimpleStringProperty(name);
		this.type = new SimpleStringProperty(type);
		this.check = new SimpleBooleanProperty(check);
	}
	
	
	@XmlElement(name ="name")
	public String getName() {
		return name.get();
	}



	public void setName(String name) {
		this.name.set(name);
	}


	@XmlElement(name ="type")
	public String getType() {
		return type.get();
	}



	public void setType(String type) {
		this.type.set(type); 
	}
	
	@XmlElement(name ="check")
	public SimpleBooleanProperty getCheck() {
		return check;
	}
	
	public void setCheck(Boolean check) {
		this.check.set(check); 
	}
	
}
