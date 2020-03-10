package ruleFile;

import javax.xml.bind.annotation.XmlElement;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class ruleFileModel {
	
	private SimpleStringProperty result;
	private SimpleStringProperty explain;
	private SimpleStringProperty column1;
	private SimpleStringProperty column2;

	public ruleFileModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ruleFileModel(String result, String explain, String column1, String column2) {
		// TODO Auto-generated constructor stub
		this.result = new SimpleStringProperty(result);
		this.explain = new SimpleStringProperty(explain);
		this.column1 = new SimpleStringProperty(column1);
		this.column2 = new SimpleStringProperty(column2);
	}

	public String getResult() {
		return result.get();
	}

	public void setResult(String result) {
		this.result.set(result);
	}

	public String getExplain() {
		return explain.get();
	}

	public void setExplain(String explain) {
		this.explain.set(explain);
	}

	public String getColumn1() {
		return column1.get();
	}

	public void setColumn1(String column1) {
		this.column1.set(column1);;
	}

	public String getColumn2() {
		return column2.get();
	}

	public void setColumn2(String column2) {
		this.column2.set(column2);;
	}
	
	
}
