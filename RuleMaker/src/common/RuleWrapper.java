package common;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import model.TableInputDataModel;
import model.TableReturnDataModel;
import model.TableRuleDataModel;

/**
 * 
 * rule을 감싸는 핼퍼 클래스이다.
 * xml로 저장하는 데 사용된다.
 *
 */
@XmlRootElement(name= "rule")
public class RuleWrapper {
	
	private List<TableInputDataModel> tableInputDataModelList;
	
	private List<TableReturnDataModel> tableReturnDataModelList;
	
//	private List<TableRuleDataModel> tableRuleDataModelList;
	
	public List<TableInputDataModel> getTableInputDataModelList() {
		return tableInputDataModelList;
	}

	public List<TableReturnDataModel> getTableReturnDataModelList() {
		return tableReturnDataModelList;
	}
	
	@XmlElementWrapper(name="tableInputDataModelList")
	@XmlElement(name ="tableInputDataModel")
	public void setTableInputDataModelList(List<TableInputDataModel> tableInputDataModelList) {
		this.tableInputDataModelList = tableInputDataModelList;
	}
	
	@XmlElementWrapper(name="tableReturnDataModelList")
	@XmlElement(name ="tableReturnDataModel")
	public void setTableReturnDataModelList(List<TableReturnDataModel> tableReturnDataModelList) {
		this.tableReturnDataModelList = tableReturnDataModelList;
	}

	public RuleWrapper() {
		// TODO Auto-generated constructor stub
	}
	
	public RuleWrapper(List<TableInputDataModel> tableInputDataModelList, List<TableReturnDataModel> tableReturnDataModelList ) {
		this.tableInputDataModelList = tableInputDataModelList;
		this.tableReturnDataModelList = tableReturnDataModelList;
	}
	
}
