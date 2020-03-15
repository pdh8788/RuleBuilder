package newFile;

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

public class newFileController implements Initializable{
	/**
	 * return �뀒�씠釉�
	 */
	@FXML
	private TableView<TableReturnDataModel> returnTable;
	@FXML
	private TableColumn<TableReturnDataModel, String> rtnNameColumn;
	@FXML
	private TableColumn<TableReturnDataModel, String> rtnTypeColumn;
	@FXML
	private TableColumn<TableReturnDataModel, Boolean> rtnCheckColumn;
	@FXML
	private Button rtnAdd;
	@FXML
	private Button rtnDel;
	
	/**
	 * input �뀒�씠釉�
	 */
	@FXML
	private TableView<TableInputDataModel> inputTable;
	@FXML
	private TableColumn<TableInputDataModel, String> iptNameColumn;
	@FXML
	private TableColumn<TableInputDataModel, String> iptTypeColumn;
	@FXML
	private TableColumn<TableInputDataModel, Boolean> iptCheckColumn;
	@FXML
	private Button iptAdd;
	@FXML
	private Button iptDel;
	
	/**
	 * ���옣, 痍⑥냼 踰꾪듉
	 */
	@FXML
	private Button save;
	
	@FXML
	private Button cancel;
	
	private final ObservableList<TableReturnDataModel> returnList =
            FXCollections.observableArrayList(
            		new TableReturnDataModel("name","String", false));
	
	private final ObservableList<TableInputDataModel> inputList =
            FXCollections.observableArrayList(
            		new TableInputDataModel("name","String", false));
	
	
	
	void rtnTableSetConfig() {
		returnTable.setEditable(true);
		rtnNameColumn.setMinWidth(150);
		rtnNameColumn.setCellValueFactory(
	            new PropertyValueFactory<TableReturnDataModel, String>("name"));
		rtnNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		rtnNameColumn.setOnEditCommit(
            new EventHandler<CellEditEvent<TableReturnDataModel, String>>() {
                @Override
                public void handle(CellEditEvent<TableReturnDataModel, String> t) {
                    ((TableReturnDataModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setName( (t.getNewValue()));
                }
            }
        );
		 
		rtnTypeColumn.setMinWidth(120);
		rtnTypeColumn.setCellValueFactory(
	            new PropertyValueFactory<TableReturnDataModel, String>("type"));
		rtnTypeColumn.setCellFactory(ComboBoxTableCell.forTableColumn("String", "Integer", "Double"));
		rtnTypeColumn.setOnEditCommit(
            new EventHandler<CellEditEvent<TableReturnDataModel, String>>() {
                @Override
                public void handle(CellEditEvent<TableReturnDataModel, String> t) {
                    ((TableReturnDataModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setType((t.getNewValue()));
                }
            }
        );
		
		rtnCheckColumn.setMinWidth(50);
		rtnCheckColumn.setCellValueFactory(param -> param.getValue().getCheck());
		rtnCheckColumn.setCellFactory( CheckBoxTableCell.forTableColumn(rtnCheckColumn));
		
		returnTable.setItems(returnList);
		
		rtnAdd.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Platform.runLater(()-> {
					returnList.add(new TableReturnDataModel("name", "String", false));
				});
			}
		});
		
		rtnDel.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				for (TableReturnDataModel tableReturnDataModel : returnList) {
					if ( tableReturnDataModel.getCheck().get() == true ) {
						Platform.runLater(()-> {
							returnList.remove(tableReturnDataModel);
						});
					}
				}
			}
		});
	}
	void iptTableSetConfig() {
		inputTable.setEditable(true);
		iptNameColumn.setMinWidth(150);
		iptNameColumn.setCellValueFactory(
	            new PropertyValueFactory<TableInputDataModel, String>("name"));
		iptNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		iptNameColumn.setOnEditCommit(
            new EventHandler<CellEditEvent<TableInputDataModel, String>>() {
                @Override
                public void handle(CellEditEvent<TableInputDataModel, String> t) {
                    ((TableInputDataModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setName( (t.getNewValue()));
                }
            }
        );
		 
		iptTypeColumn.setMinWidth(120);
		iptTypeColumn.setCellValueFactory(
	            new PropertyValueFactory<TableInputDataModel, String>("type"));
		iptTypeColumn.setCellFactory(ComboBoxTableCell.forTableColumn("String", "Integer", "Double"));
		iptTypeColumn.setOnEditCommit(
            new EventHandler<CellEditEvent<TableInputDataModel, String>>() {
                @Override
                public void handle(CellEditEvent<TableInputDataModel, String> t) {
                    ((TableInputDataModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setType( (t.getNewValue()));
                }
            }
        );
		
		iptCheckColumn.setMinWidth(50);
		iptCheckColumn.setCellValueFactory(param -> param.getValue().getCheck());
		iptCheckColumn.setCellFactory( CheckBoxTableCell.forTableColumn(iptCheckColumn));
		
		inputTable.setItems(inputList);
		
		iptAdd.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Platform.runLater(()-> {
					inputList.add(new TableInputDataModel("name", "String", false));
				});
			}
		});
		
		iptDel.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				for (TableInputDataModel tableInputDataModel : inputList) {
					if ( tableInputDataModel.getCheck().get() == true ) {
						Platform.runLater(()-> {
							inputList.remove(tableInputDataModel);
						});
					}
				}
			}
		});
	}
	
	loadSaveRuleData method = loadSaveRuleData.getInstance();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rtnTableSetConfig();
		iptTableSetConfig();
		
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleBtnExitAction(event);
			}
		});
		
		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				File saveFolder = new File("C:\\saveFiles");
				
				if( !saveFolder.exists()) {
					try {
						saveFolder.mkdir();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				File saveFile = new File("C:\\saveFiles\\save.xml");
				
				RuleWrapper rule = new RuleWrapper(inputList, returnList);
				
				method.saveRuleDataFromFile( saveFile , rule);
//				method.saveRuleDataFromFile(file, wrapper);
			}
		});
		
		// TODO Auto-generated method stub
//		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
//		typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
	}
	
	public void handleBtnExitAction(ActionEvent e) { 
		Stage stage = (Stage) cancel.getScene().getWindow();
		stage.close();
	}
	@FXML
	public void exitApplication(ActionEvent event) {
		handleBtnExitAction(null);
	}
	
}
