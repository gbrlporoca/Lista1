package lista1Gui;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class Teste extends Application{
	
	public static void main(String[] args){
		
			launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

        try {
           Pane root = FXMLLoader.load(getClass().getResource("/lista1Gui/GUI.fxml"));
           Scene scene = new Scene(root);
         primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
	


	
		
	}