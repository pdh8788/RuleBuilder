package newFile;

import javafx.beans.property.SimpleStringProperty;

public class TableReturnDataModel {
	private SimpleStringProperty name;
	private SimpleStringProperty type;
	
	public TableReturnDataModel(String name, String type)
	{
		this.name = new SimpleStringProperty(name);
		this.type = new SimpleStringProperty(type);
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
}
