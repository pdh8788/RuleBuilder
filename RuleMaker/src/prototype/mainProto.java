package prototype;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class mainProto extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			System.out.println("111111111111111111111");
			System.out.println("111111111111111111111");
			System.out.println("111111111111111111111");
			System.out.println("111111111111111111111");
			System.out.println("111111111111111111111");
			Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
			Scene scene = new Scene(root);

			primaryStage.setTitle("sample");
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
