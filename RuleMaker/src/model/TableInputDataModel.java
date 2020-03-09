package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableBooleanValue;

public class TableInputDataModel {
	private SimpleStringProperty name;
	private SimpleStringProperty type;
	private SimpleBooleanProperty check;
	
	public TableInputDataModel() {
		// TODO Auto-generated constructor stub
	}
	
	public TableInputDataModel(String name, String type, Boolean check)
	{
		this.name = new SimpleStringProperty(name);
		this.type = new SimpleStringProperty(type);
		this.check = new SimpleBooleanProperty(check);
	}
	
	public String getName() {
		return name.get();
	}

	@XmlElement(name ="name")
	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getType() {
		return type.get();
	}

	@XmlElement(name ="type")
	public void setType(String type) {
		this.type.set(type); 
	}
	
	public SimpleBooleanProperty getCheck() {
		return check;
	}
	
	@XmlElement(name ="check")
	public void setCheck(Boolean check) {
		this.check.set(check); 
	}
	
}
