package prototype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.loadSaveRuleData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
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
//            		new protoModel("1","홍길동","910821-111111", "010-1111-1111","서울시 영등포구 당산로 314-12")
//            		, new protoModel("2","박나리","880821-111111", "010-2222-1111","인천광역시 서구 웅진로 211-14")
//            		, new protoModel("3","김진수","780821-111111", "010-3333-1111","서울특별시 동작구 동작로 111-1")
            		);
	
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
            
            nameDetail.setEditable(true);
            idDetail.setEditable(true);
            numberDetail.setEditable(true);
            addressDetail.setEditable(true);
            
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
		
		System.out.println();
		
		
	}
	
	public void parseJSONData(BufferedReader bufferedReader) {
		Object obj = null;
		JSONArray array = new JSONArray();
		try {
			 JSONParser jsonParser = new JSONParser();
			 array = (JSONArray) jsonParser.parse(bufferedReader);
			 
			 for (int i = 0; i < array.size(); i++) {
				 JSONObject tempObj = (JSONObject)array.get(i);
				 list.add(new protoModel(tempObj.get("employeeNo").toString(), tempObj.get("name").toString(), tempObj.get("personId").toString() , 
						 tempObj.get("number").toString() , tempObj.get("address").toString() ));
			}
			 
//			 resultSet = array.toJSONString();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return array;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setConfig();
		
		lookUp.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					URL url = new URL("http://localhost:8080/ruleBuilder/protoType");
					HttpURLConnection conn = null;
					JSONObject responseJson = null;
					conn = (HttpURLConnection) url.openConnection();
					
					
					conn.setRequestMethod("GET");
//					conn.setRequestProperty("X-AUTH-Token", this.token);
					conn.setRequestProperty("Content-Type", "application/json");
					
					//request에 JSON data 준비
					conn.setDoOutput(true);
					
					//commands라는 JSONArray를 담을 JSONObject 생성
//					JSONObject commands = new JSONObject();
//					commands.put("commands", value);
//					bw.write(commands.toString());
					
					int responseCode = conn.getResponseCode();
					if(responseCode == 400) {
						System.out.println("400:: 해당 명령을 실행할 수 없음");
					} else if (responseCode == 401) {
						System.out.println("401:: X-Auth-Token Header가 잘못됨");
					} else if (responseCode == 500) {
						System.out.println("500:: 서버 에러");
					} else {
						BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						list.remove(0, list.size());
						parseJSONData(br);
					}
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO: handle exception
				}
				
			}
		});
		
		save.setOnAction(new EventHandler<ActionEvent>() {
			@SuppressWarnings("unchecked")
			@Override
			public void handle(ActionEvent event) {
				try {
					protoModel model = (protoModel)table.getSelectionModel().getSelectedItem();
					
					if( model == null || model.getEmployeeNum().equals("") )
					{
						return;
					}
					
					URL url = new URL("http://localhost:8080/ruleBuilder/protoType");
					HttpURLConnection conn = null;
					conn = (HttpURLConnection) url.openConnection();
					
					conn.setRequestMethod("PUT");
//					conn.setRequestProperty("X-AUTH-Token", this.token);
					conn.setRequestProperty("Content-Type", "application/json");
					
					
					//request에 JSON data 준비
					conn.setDoOutput(true);
					//String employeeNum, String name, String personId, String number, String address

					JSONObject object = new JSONObject();
					object.put("employeeNo", model.getEmployeeNum());
					object.put("name", nameDetail.getText());
					object.put("personId", idDetail.getText());
					object.put("number", numberDetail.getText());
					object.put("address",  addressDetail.getText());
					
					System.out.println(object.toJSONString());
					
			        OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
			        out.write(object.toJSONString());
			        out.close();
					
					int responseCode = conn.getResponseCode();
					if(responseCode == 400) {
						System.out.println("400:: 해당 명령을 실행할 수 없음");
					} else if (responseCode == 401) {
						System.out.println("401:: X-Auth-Token Header가 잘못됨");
					} else if (responseCode == 500) {
						System.out.println("500:: 서버 에러");
					} else {
						BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						System.out.println(br);
					}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				} catch ( Exception e ) {
					e.printStackTrace();
				}
		}});
	}
	
	public void handleBtnExitAction(ActionEvent e) { 
	}
	@FXML
	public void exitApplication(ActionEvent event) {
		handleBtnExitAction(null);
	}
	
}
