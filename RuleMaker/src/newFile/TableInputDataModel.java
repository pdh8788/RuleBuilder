package newFile;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableBooleanValue;

public class TableInputDataModel {
	private SimpleStringProperty name;
	private SimpleStringProperty type;
	private SimpleBooleanProperty check;
	
	public TableInputDataModel(String name, String type, Boolean check)
	{
		this.name = new SimpleStringProperty(name);
		this.type = new SimpleStringProperty(type);
		this.check = new SimpleBooleanProperty(check);
	}
	
	
	
	public String getName() {
		return name.get();
	}



	public void setName(String name) {
		this.name.set(name);
	}



	public String getType() {
		return type.get();
	}



	public void setType(String type) {
		this.type.set(type); 
	}
	
	public ObservableBooleanValue getCheck() {
		return check;
	}
	
	public void setCheck(Boolean check) {
		this.check.set(check); 
	}
	
}
