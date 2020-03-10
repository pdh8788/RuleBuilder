package ruleFile;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.TableInputDataModel;
import model.TableReturnDataModel;
import model.TableRuleDataModel;

public class ruleFileController implements Initializable{
	/**
	 * rule 테이블
	 */
	@FXML
	private TableView<ruleFileModel> ruleTable;
	
	@FXML
	private TableColumn<ruleFileModel, String> result;
	@FXML
	private TableColumn<ruleFileModel, String> explain;
	@FXML
	private TableColumn<ruleFileModel, String> column1;
	@FXML
	private TableColumn<ruleFileModel, String> column2;
	
	@FXML
	private Button add;
	@FXML
	private Button del;
	
	/**
	 * 저장, commit 버튼
	 */
	@FXML
	private Button save;
	
	@FXML
	private Button commit;
	
	private final ObservableList<ruleFileModel> returnList =
            FXCollections.observableArrayList(
            		new ruleFileModel("name","String", "1","2"));
	
	public void setConfig() {
		ruleTable.setEditable(true);
		
		result.setEditable(true);
//		result.setMinWidth(150);
		result.setCellValueFactory(
	            new PropertyValueFactory<ruleFileModel, String>("result"));
		result.setCellFactory(TextFieldTableCell.forTableColumn());
		result.setOnEditCommit(
            new EventHandler<CellEditEvent<ruleFileModel, String>>() {
                @Override
                public void handle(CellEditEvent<ruleFileModel, String> t) {
                    ((ruleFileModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setResult(t.getNewValue());
                }
            }
        );
		
		explain.setEditable(true);
//		result.setMinWidth(150);
		explain.setCellValueFactory(
	            new PropertyValueFactory<ruleFileModel, String>("explain"));
		explain.setCellFactory(TextFieldTableCell.forTableColumn());
		explain.setOnEditCommit(
            new EventHandler<CellEditEvent<ruleFileModel, String>>() {
                @Override
                public void handle(CellEditEvent<ruleFileModel, String> t) {
                    ((ruleFileModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setExplain(t.getNewValue());
                }
            }
        );
		
		column1.setEditable(true);
//		result.setMinWidth(150);
		column1.setCellValueFactory(
	            new PropertyValueFactory<ruleFileModel, String>("column1"));
		column1.setCellFactory(TextFieldTableCell.forTableColumn());
		column1.setOnEditCommit(
            new EventHandler<CellEditEvent<ruleFileModel, String>>() {
                @Override
                public void handle(CellEditEvent<ruleFileModel, String> t) {
                    ((ruleFileModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setColumn1(t.getNewValue());
                }
            }
        );
		
		column2.setEditable(true);
//		result.setMinWidth(150);
		column2.setCellValueFactory(
	            new PropertyValueFactory<ruleFileModel, String>("column2"));
		column2.setCellFactory(TextFieldTableCell.forTableColumn());
		column2.setOnEditCommit(
            new EventHandler<CellEditEvent<ruleFileModel, String>>() {
                @Override
                public void handle(CellEditEvent<ruleFileModel, String> t) {
                    ((ruleFileModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setColumn2(t.getNewValue());
                }
            }
        );
		
		ruleTable.setItems(returnList);
		
		add.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Platform.runLater(()-> {
					returnList.add(new ruleFileModel("result", "explain", "condition1","condition2"));
				});
			}
		});
		
		del.setOnAction(new EventHandler<ActionEvent>() {
			
			@SuppressWarnings("unlikely-arg-type")
			@Override
			public void handle(ActionEvent event) {
				if ( returnList.size() > 0 ) {
					returnList.remove(returnList.size()-1);
				}
			}
		});
		  
	}
	
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
/*		RuleWrapper ruleWrapper = method.loadRuleDataFromFile(loadFile);
		RuleWrapper ruleWrapper = new RuleWrapper();
		List<TableInputDataModel> tidm = ruleWrapper.getTableInputDataModelList();
		List<TableReturnDataModel> trdm = ruleWrapper.getTableReturnDataModelList();
		
		if ( tidm != null && trdm != null) {
			// list 컬럼 동적할당
			for (TableInputDataModel tableInputDataModel : tidm) {
				ruleTable.getColumns().add(new TableColumn(tableInputDataModel.getName()));
			}
			
			for (TableReturnDataModel tableReturnDataModel : trdm) {
				ruleTable.getColumns().add(new TableColumn(tableReturnDataModel.getName()));
			}
			
		} else {
			// exception 발생
		}
*/
		setConfig();
		
		
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
