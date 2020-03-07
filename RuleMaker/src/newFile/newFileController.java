package newFile;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class newFileController implements Initializable{
	@FXML
	private TableView<TableReturnDataModel> returnTable;
	
	@FXML
	private TableColumn<TableReturnDataModel, String> nameColumn;
	
	@FXML
	private TableColumn<TableReturnDataModel, String> typeColumn;
	
	ObservableList<TableReturnDataModel> returnList = FXCollections.observableArrayList(
			new TableReturnDataModel(
					new SimpleStringProperty("name1") , new SimpleStringProperty("type") )
	);
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
		returnTable.setItems(returnList);
	}
}
