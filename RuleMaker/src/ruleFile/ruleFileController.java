package ruleFile;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import common.RuleWrapper;
import common.loadSaveRuleData;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import model.TableInputDataModel;
import model.TableReturnDataModel;
import model.TableRuleDataModel;

public class ruleFileController implements Initializable{
	/**
	 * rule 테이블
	 */
	@FXML
	private TableView<TableRuleDataModel> ruleTable;
	
	private Button rtnAdd;
	@FXML
	private Button rtnDel;
	
	/**
	 * 저장, commit 버튼
	 */
	@FXML
	private Button save;
	
	@FXML
	private Button commit;
	
//	private final ObservableList<TableRuleDataModel> returnList =
//            FXCollections.observableArrayList(
//            		new TableReturnDataModel("name","String", false));
	
	loadSaveRuleData method = loadSaveRuleData.getInstance();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		commit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleBtnExitAction(event);
			}
		});
		
		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
			}
		});
		
		File loadFile = new File("C:\\saveFiles\\save.xml");
		RuleWrapper ruleWrapper = method.loadRuleDataFromFile(loadFile);
		
		TableInputDataModel tidm = (TableInputDataModel) ruleWrapper.getTableInputDataModelList();
		TableReturnDataModel trdm = (TableReturnDataModel) ruleWrapper.getTableReturnDataModelList();
		
		if ( tidm != null && trdm != null) {
			// list 컬럼 동적할당
		} else {
			// exception 발생
		}
		
		// TODO Auto-generated method stub
//		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
//		typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
	}
	
	public void handleBtnExitAction(ActionEvent e) { 
	}
	@FXML
	public void exitApplication(ActionEvent event) {
		handleBtnExitAction(null);
	}
	
}
