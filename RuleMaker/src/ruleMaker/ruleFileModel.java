package ruleMaker;

import javax.xml.bind.annotation.XmlElement;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ruleFileModel {
	private SimpleIntegerProperty ruleId;
	private SimpleStringProperty ruleName;
	private SimpleStringProperty ruleEx;
	private SimpleStringProperty column1;
	private SimpleStringProperty column2;
	private SimpleStringProperty column3;
	private SimpleStringProperty column4;
	private SimpleStringProperty column5;
	private SimpleStringProperty column6;
	
	public ruleFileModel(Integer ruleId, String result, String explain, String column1, String column2, String column3, String column4, String column5, String column6) {
		// TODO Auto-generated constructor stub
		this.ruleId = new SimpleIntegerProperty(ruleId);
		this.ruleName = new SimpleStringProperty(result);
		this.ruleEx = new SimpleStringProperty(explain);
		this.column1 = new SimpleStringProperty(column1);
		this.column2 = new SimpleStringProperty(column2);
		this.column3 = new SimpleStringProperty(column3);
		this.column4 = new SimpleStringProperty(column4);
		this.column5 = new SimpleStringProperty(column5);
		this.column6 = new SimpleStringProperty(column6);
	}
	
	public Integer getRuleId() {
		return ruleId.get();
	}

	public void setRuleName(Integer ruleId) {
		this.ruleId.set(ruleId);
	}

	
	public String getRuleName() {
		return ruleName.get();
	}

	public void setRuleName(String ruleName) {
		this.ruleName.set(ruleName);
	}

	public void setRuleEx(String explain) {
		this.ruleEx.set(explain);
	}
	
	public String getRuleEx() {
		return ruleEx.get();
	}

	
	public void setColumn1(String column1) {
		this.column1.set(column1);
	}
	
	public String getColumn1() {
		return column1.get();
	}

	public String getColumn2() {
		return column2.get();
	}

	public void setColumn2(String column2) {
		this.column2.set(column2);
	}
	
	
	public String getColumn3() {
		return column3.get();
	}
	
	public void setColumn3(String column3) {
		this.column3.set(column3);
	}
	
	public void setColumn4(String column4) {
		this.column4.set(column4);
	}
	
	public String getColumn4() {
		return column4.get();
	}
	
	public void setColumn5(String column5) {
		this.column5.set(column5);
	}
	
	public String getColumn5() {
		return column5.get();
	}
	
	public void setColumn6(String column6) {
		this.column6.set(column6);
	}
	
	public String getColumn6() {
		return column6.get();
	}
	
	
	//////////////////////////////

	public ruleFileModel() {
		// TODO Auto-generated constructor stub
	}
	
	
}
