package newFile;

import javafx.beans.property.StringProperty;

public class TableReturnDataModel {
	private StringProperty name;
	private StringProperty type;
	
	public TableReturnDataModel(StringProperty name, StringProperty type)
	{
		this.name = name;
		this.type = type;
	}

	public StringProperty nameProperty() {
		return name;
	}

	public StringProperty typeProperty() {
		return type;
	}
	
}
