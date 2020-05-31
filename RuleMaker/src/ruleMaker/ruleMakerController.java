package ruleMaker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ruleMakerController implements Initializable{
	/**
	 * rule 테이블
	 */
	@FXML
	private TableView<ruleFileModel> ruleTable;
	

	/**
	 * Component
	 */
	@FXML
	private TableColumn<ruleFileModel, String> ruleName;
	@FXML
	private TableColumn<ruleFileModel, String> ruleEx;
	@FXML
	private TableColumn<ruleFileModel, String> column1;
	@FXML
	private TableColumn<ruleFileModel, String> column2;
	@FXML
	private TableColumn<ruleFileModel, String> column3;
	@FXML
	private TableColumn<ruleFileModel, String> column4;
	@FXML
	private TableColumn<ruleFileModel, String> column5;
	@FXML
	private TableColumn<ruleFileModel, String> column6;
	
	@FXML
	private Button commitBtn;
	
	private final ObservableList<ruleFileModel> returnList =
            FXCollections.observableArrayList();
	
	final BooleanProperty ctrlPressed = new SimpleBooleanProperty(false);
	final BooleanProperty sPressed = new SimpleBooleanProperty(false);
	final BooleanBinding ctrlAndSpressed = ctrlPressed.and(sPressed);
	
	public void setConfig() {
		
		commitBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
				try {
					URL url = new URL("http://localhost:8080/ruleBuilder/protoType");
					HttpURLConnection conn = null;
					conn = (HttpURLConnection) url.openConnection();
					
					conn.setRequestMethod("PUT");
					conn.setRequestProperty("Content-Type", "application/json");
					
					//request에 JSON data 준비
					conn.setDoOutput(true);
					//String employeeNum, String name, String personId, String number, String address

					JSONObject object = new JSONObject();
					object.put("rule", returnList);
					
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
				} catch (IOException ioe) {
					// TODO: handle exception
					ioe.printStackTrace();
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
			
		});
		
		ruleTable.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if ( event.getCode() == KeyCode.CONTROL) {
					ctrlPressed.set(true);
				} else if ( event.getCode() == KeyCode.S) {
					sPressed.set(true);
				}
			}
		});
		
		ruleTable.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if ( event.getCode() == KeyCode.CONTROL) {
					ctrlPressed.set(false);
				} else if ( event.getCode() == KeyCode.S) {
					sPressed.set(false);
				}
			}
		});
		ctrlAndSpressed.addListener(new ChangeListener<Boolean>() {
			
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if( oldValue == false && newValue == true ) {
					saveRuleDataToFile();
				}
				
			}
		});
		
		ruleName.setCellValueFactory(
	            new PropertyValueFactory<ruleFileModel, String>("ruleName"));
		ruleName.setCellFactory(TextFieldTableCell.forTableColumn());
		ruleName.setOnEditCommit(
            new EventHandler<CellEditEvent<ruleFileModel, String>>() {
                @Override
                public void handle(CellEditEvent<ruleFileModel, String> t) {
                    ((ruleFileModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setRuleName(t.getNewValue());
                }
            }
        );
		
		ruleEx.setCellValueFactory(
	            new PropertyValueFactory<ruleFileModel, String>("ruleEx"));
		ruleEx.setCellFactory(TextFieldTableCell.forTableColumn());
		ruleEx.setOnEditCommit(
            new EventHandler<CellEditEvent<ruleFileModel, String>>() {
                @Override
                public void handle(CellEditEvent<ruleFileModel, String> t) {
                    ((ruleFileModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setRuleEx(t.getNewValue());
                }
            }
        );
		
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
		
		column3.setCellValueFactory(
	            new PropertyValueFactory<ruleFileModel, String>("column3"));
		column3.setCellFactory(TextFieldTableCell.forTableColumn());
		column3.setOnEditCommit(
            new EventHandler<CellEditEvent<ruleFileModel, String>>() {
                @Override
                public void handle(CellEditEvent<ruleFileModel, String> t) {
                    ((ruleFileModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setColumn3(t.getNewValue());
                }
            }
        );
		
		column4.setCellValueFactory(
	            new PropertyValueFactory<ruleFileModel, String>("column4"));
		column4.setCellFactory(TextFieldTableCell.forTableColumn());
		column4.setOnEditCommit(
            new EventHandler<CellEditEvent<ruleFileModel, String>>() {
                @Override
                public void handle(CellEditEvent<ruleFileModel, String> t) {
                    ((ruleFileModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setColumn4(t.getNewValue());
                }
            }
        );
		
		column5.setCellValueFactory(
	            new PropertyValueFactory<ruleFileModel, String>("column5"));
		column5.setCellFactory(TextFieldTableCell.forTableColumn());
		column5.setOnEditCommit(
            new EventHandler<CellEditEvent<ruleFileModel, String>>() {
                @Override
                public void handle(CellEditEvent<ruleFileModel, String> t) {
                    ((ruleFileModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setColumn5(t.getNewValue());
                }
            }
        );
		
		column6.setCellValueFactory(
	            new PropertyValueFactory<ruleFileModel, String>("column6"));
		column6.setCellFactory(TextFieldTableCell.forTableColumn());
		column6.setOnEditCommit(
            new EventHandler<CellEditEvent<ruleFileModel, String>>() {
                @Override
                public void handle(CellEditEvent<ruleFileModel, String> t) {
                    ((ruleFileModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setColumn6(t.getNewValue());
                }
            }
        );
		
		ruleTable.getItems().addAll(
			new ruleFileModel(1,"","","","","","","",""),
			new ruleFileModel(1,"","","","","","","",""),
			new ruleFileModel(1,"","","","","","","",""),
			new ruleFileModel(1,"","","","","","","",""),
			new ruleFileModel(1,"","","","","","","",""),
			new ruleFileModel(1,"","","","","","","","")
			
        );
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setConfig();
	}
	
	@FXML
	private void handleOpenAction ( ActionEvent event ) {
   	    FileChooser fileChooser = new FileChooser();
   	    fileChooser.setInitialDirectory(new File("C:\\Users\\user\\Desktop\\sts-4.5.1.RELEASE\\ruleFile"));
        // 확장자 필터를 설정한다.
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "JSON files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);

        // Save File Dialog를 보여준다.
        File file = fileChooser.showOpenDialog(ruleTable.getScene().getWindow());

        if (file != null) {
            loadRuleDataFromFile(file);
        }
	}
	
	@FXML
	public void exitApplication(ActionEvent event) {
		Platform.exit();
		System.exit(0);
	}
	
	/**
	 * 연락처 파일 환경설정을 반환한다.
	 * 즉 파일은 마지막으로 열린 것이고, 환경설정은 OS 특정 레지스트리로부터 읽는다.
	 * 만일 preference를 찾지 못하면 null을 반환한다.
	 *
	 * @return
	 */
	public File getPersonFilePath() {
	    Preferences prefs = Preferences.userNodeForPackage(launcher.class);
	    String filePath = prefs.get("filePath", null);
	    if (filePath != null) {
	        return new File(filePath);
	    } else {
	        return null;
	    }
	}

	/**
	 * 현재 불러온 파일의 경로를 설정한다. 이 경로는 OS 특정 레지스트리에 저장된다.
	 *
	 * @param file the file or null to remove the path
	 */
	public void setPersonFilePath(File file, Stage primaryStage) {
	    Preferences prefs = Preferences.userNodeForPackage(launcher.class);
	    if (file != null) {
	        prefs.put("filePath", file.getPath());

	        // Stage 타이틀을 업데이트한다.
	        primaryStage.setTitle("AddressApp - " + file.getName());
	    } else {
	        prefs.remove("filePath");

	        // Stage 타이틀을 업데이트한다.
	        primaryStage.setTitle("AddressApp");
	    }
	}
	
	/**
	 * 지정한 파일로부터 연락처 데이터를 가져온다. 현재 연락처 데이터로 대체된다.
	 *
	 * @param file
	 */
	public void loadRuleDataFromFile(File file) {
		JSONParser parser = new JSONParser();
	    try {
	    	Object obj = parser.parse(new FileReader(file));
	    	
	    	JSONObject jsonObject = (JSONObject) obj;
	    	
	    	JSONArray jsonArray =  (JSONArray) jsonObject.get("result");
	    	
	    	@SuppressWarnings("unchecked")
			Iterator<JSONObject> iterator = jsonArray.iterator();
	    	while( iterator.hasNext() ) {
	    		JSONObject object = iterator.next();
	    		returnList.add(new ruleFileModel(
	    				(int)(long)object.get("ruleId"),
	    				String.valueOf(object.get("ruleName")), 
	    				String.valueOf(object.get("ruleEx")), 
	    				String.valueOf(object.get("column1")),
	    				String.valueOf(object.get("column2")), 
	    				String.valueOf(object.get("column3")), 
	    				String.valueOf(object.get("column4")), 
	    				String.valueOf(object.get("column5")), 
	    				String.valueOf(object.get("column6"))));
	    	}
	    	
	    	ruleTable.setItems(returnList);
	    	
	    } catch (Exception e) { // 예외를 잡는다
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText("Could not load data");
	        alert.setContentText("Could not load data from file:\n" + file.getPath());
	        e.printStackTrace();
	        alert.showAndWait();
	    }
	}

	/**
	 * 현재 연락처 데이터를 지정한 파일에 저장한다.
	 *
	 * @param file
	 */
	@SuppressWarnings("unchecked")
	public void saveRuleDataToFile() {
		File file = new File("C:\\Users\\user\\Desktop\\sts-4.5.1.RELEASE\\ruleFile\\test.json");
	    try {
	    	JSONArray jsonArray = new JSONArray();
			JSONObject resultJson = new JSONObject();
			List<ruleFileModel> items = ruleTable.getItems();
			for (int i = 0; i < items.size(); i++) {
				JSONObject object = new JSONObject();
				object.put("ruleId",(Integer)items.get(i).getRuleId());
				object.put("ruleName",items.get(i).getRuleName());
				object.put("ruleEx",items.get(i).getRuleEx());
				object.put("column1",items.get(i).getColumn1());
				object.put("column2",items.get(i).getColumn2());
				object.put("column3",items.get(i).getColumn3());
				object.put("column4",items.get(i).getColumn4());
				object.put("column5",items.get(i).getColumn5());
				object.put("column6",items.get(i).getColumn6());
				jsonArray.add(object);
				returnList.add(items.get(i));
			}
			
			resultJson.put("result", jsonArray);
			
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(resultJson.toJSONString());
			fileWriter.flush();
			fileWriter.close();
	    } catch (Exception e) { // 예외를 잡는다.
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText("Could not save data");
	        alert.setContentText("Could not save data to file:\n" + file.getPath());
	        e.printStackTrace();
	        alert.showAndWait();
	    }
	}
	
}
