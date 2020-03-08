package common;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import newFile.TableInputDataModel;
import newFile.TableReturnDataModel;

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

	@XmlElement(name ="tableInputDataModel")
	public List<TableInputDataModel> getTableInputDataModelList() {
		return tableInputDataModelList;
	}
	
	@XmlElement(name ="tableReturnDataModel")
	public List<TableReturnDataModel> getTableReturnDataModelList() {
		return tableReturnDataModelList;
	}
	
	public RuleWrapper(List<TableInputDataModel> tableInputDataModelList, List<TableReturnDataModel> tableReturnDataModelList ) {
		this.tableInputDataModelList = tableInputDataModelList;
		this.tableReturnDataModelList = tableReturnDataModelList;
	}
	
}
