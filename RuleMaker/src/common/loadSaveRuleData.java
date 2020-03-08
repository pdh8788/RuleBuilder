package common;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class loadSaveRuleData {
	
	private static loadSaveRuleData method = null;

	public void loadRuleDataFromFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(RuleWrapper.class);
			Unmarshaller um = context.createUnmarshaller();

			// 파일로부터 XML을 읽은 다음 역 마샬링한다.
			RuleWrapper ruleWrapper = (RuleWrapper) um.unmarshal(file);

//			ruleWrapper.getTableInputDataModelList();
//			ruleWrapper.getTableReturnDataModelList();

		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not load data");
			alert.setContentText("Could not load data from file:\n" + file.getPath());

			alert.showAndWait();
		}
	}

	public void saveRuleDataFromFile(File file, RuleWrapper wrapper) {
		try {
			JAXBContext context = JAXBContext.newInstance(RuleWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			// 마샬링  후 xml을 파일에 저장한다.
			m.marshal(wrapper, file);
			
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not save data");
			alert.setContentText("Could not save data to file:\n" + file.getPath());

			alert.showAndWait();
		}
	}
	
	public synchronized static loadSaveRuleData getInstance() {
		if ( method == null ) {
			method = new loadSaveRuleData();
		}
		
		return method;
	}

}
