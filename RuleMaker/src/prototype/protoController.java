package prototype;

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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;

public class protoController implements Initializable{
	/**
	 * rule 테이블
	 */
	@FXML
	private TableView<protoModel> table;
	
	@FXML
	private Pane detailView ;
	
	
	@FXML
	private TableColumn<protoModel, String> nameCol;

	@FXML
	private TableColumn<protoModel, String> idCol;
	
	@FXML
	private TableColumn<protoModel, String> numberCol;
	
	@FXML
	private TableColumn<protoModel, String> addressCol;
	
	@FXML
	private TextField nameDetail;

	@FXML
	private TextField addressDetail;
	
	@FXML
	private TextField idDetail;
	
	@FXML
	private TextField numberDetail;
	
	@FXML
	private Button lookUp;
	
	@FXML
	private Button save;
	
	private final ObservableList<protoModel> list =
            FXCollections.observableArrayList(
            		new protoModel("홍길동","910821-111111", "010-1111-1111","서울시 영등포구 당산로 314-12")
            		, new protoModel("박나리","880821-111111", "010-2222-1111","인천광역시 서구 웅진로 211-14")
            		, new protoModel("김진수","780821-111111", "010-3333-1111","서울특별시 동작구 동작로 111-1"));
	
	public void setConfig() {
		table.setEditable(false);
		
		table.setRowFactory(tv -> {
            TableRow<protoModel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                	protoModel rowData = row.getItem();
                	nameDetail.setText(rowData.getName());
                	idDetail.setText(rowData.getPersonId());
                	numberDetail.setText(rowData.getNumber());
                	addressDetail.setText(rowData.getAddress());
                }
            });
            return row ;
        });
		
//		detailView.setStyle("-fx-border-color: black");
		
//		result.setMinWidth(150);
		nameCol.setCellValueFactory(
	            new PropertyValueFactory<protoModel, String>("name"));
		nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

		idCol.setCellValueFactory(
	            new PropertyValueFactory<protoModel, String>("personId"));
		idCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		numberCol.setCellValueFactory(
	            new PropertyValueFactory<protoModel, String>("number"));
		numberCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		addressCol.setCellValueFactory(
	            new PropertyValueFactory<protoModel, String>("address"));
		addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		table.setItems(list);
		
	}
	
	loadSaveRuleData method = loadSaveRuleData.getInstance();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setConfig();
		
		lookUp.setOnAction(new EventHandler<ActionEvent>() {
			
			@SuppressWarnings("unlikely-arg-type")
			@Override
			public void handle(ActionEvent event) {
				
			}
		});
		
		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
			}
		});
		
		
	}
	
	public void handleBtnExitAction(ActionEvent e) { 
	}
	@FXML
	public void exitApplication(ActionEvent event) {
		handleBtnExitAction(null);
	}
	
}
