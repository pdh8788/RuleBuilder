package newFile;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class newFileController implements Initializable{
	@FXML
	private TableView<TableReturnDataModel> returnTable;
	
	@FXML
	private TableColumn<TableReturnDataModel, String> nameColumn;
	
	@FXML
	private TableColumn<TableReturnDataModel, String> typeColumn;
	
	@FXML
	private Button rtnAdd;
	
	@FXML
	private Button rtnDel;
	
	
	
	
	private final ObservableList<TableReturnDataModel> returnList =
            FXCollections.observableArrayList(
            		new TableReturnDataModel("name","String"));
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		returnTable.setEditable(true);
		
		nameColumn.setMinWidth(150);
		nameColumn.setCellValueFactory(
	            new PropertyValueFactory<TableReturnDataModel, String>("name"));
		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		nameColumn.setOnEditCommit(
            new EventHandler<CellEditEvent<TableReturnDataModel, String>>() {
                @Override
                public void handle(CellEditEvent<TableReturnDataModel, String> t) {
                    ((TableReturnDataModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setName( (t.getNewValue()));
                }
            }
        );
		 
		typeColumn.setMinWidth(120);
		typeColumn.setCellValueFactory(
	            new PropertyValueFactory<TableReturnDataModel, String>("type"));
		typeColumn.setCellFactory(ComboBoxTableCell.forTableColumn("String", "Integer", "Double"));
		typeColumn.setOnEditCommit(
            new EventHandler<CellEditEvent<TableReturnDataModel, String>>() {
                @Override
                public void handle(CellEditEvent<TableReturnDataModel, String> t) {
                    ((TableReturnDataModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setName( (t.getNewValue()));
                }
            }
        );
		
		returnTable.setItems(returnList);
		
		rtnAdd.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				returnList.add(new TableReturnDataModel("abcd", "11"));
				System.out.println("1111111111111");
			}
		});
		
		
		// TODO Auto-generated method stub
//		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
//		typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
	}
	
	
}
