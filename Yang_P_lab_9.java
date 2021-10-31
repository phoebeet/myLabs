import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Yang_P_lab_9 extends Application {
	
	public static void main(String[]args){
		launch(args);
	}
	
	public void start(Stage myStage) {
		myStage.setTitle("Demonstrate A Simple Scene Graph");
		FlowPane rootNode = new FlowPane();
		Scene myScene = new Scene(rootNode, 300, 200);
		myStage.setScene(myScene);
		Label myLabel = new Label ("A simple JavaFX label.");
		rootNode.getChildren().add(myLabel);
		myStage.show();
	}
}