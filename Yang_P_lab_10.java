import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;

public class Yang_P_lab_10 extends Application 
	implements EventHandler<ActionEvent>
{

	public static void main(String[]args){
		launch(args);
	}
	
	Button btn1;
	Button btn2;
	Button btn3;
	Label lbl;
	String combo = "";
	String rightcombo = "123";
	
	@Override public void start (Stage primaryStage){
		btn1 = new Button();
		btn1.setText("1");
		btn1.setOnAction(this);
		
		btn2 = new Button();
		btn2.setText("2");
		btn2.setOnAction(this);
		
		btn3 = new Button();
		btn3.setText("3");
		btn3.setOnAction(this);
		
		lbl = new Label();
		lbl.setText("Enter a 3-digit combination");
		
		HBox pane = new HBox(10);
		pane.getChildren().addAll(lbl, btn1, btn2, btn3);
		
		Scene scene = new Scene (pane, 300, 75);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Yang_P_lab_10");
		primaryStage.show();
	}
	
	@Override public void handle(ActionEvent e){
		if(e.getSource() == btn1)
			combo = combo + "1";
		else if (e.getSource() == btn2)
			combo = combo + "2";
		else
			combo = combo + "3";
		lbl.setText(combo);
		
		if(combo.length() == 3){
			if (rightcombo.equals(combo)){
				lbl.setText("Success! The combination was 123.");
				combo = "";
				}
			else{ 
				lbl.setText("Failure!");
				combo = "";
			}
		}
	}
}