import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import java.lang.*;
import java.lang.Math;

public class Yang_P_lab_11 extends Application

{
	public static void main(String[]args){
		launch(args);
	}

	@Override public void start (Stage primaryStage){
		Label F = new Label("Fahrenheit:");
		TextField fahrenheit = new TextField();
		HBox fht = new HBox();
		fht.getChildren().addAll(F, fahrenheit);
		fht.setSpacing(10);
		
		Label C = new Label("Celsius:");
		TextField celsius = new TextField();
		HBox cs = new HBox();
		cs.getChildren().addAll(C, celsius);
		cs.setSpacing(10);
		
		Label K = new Label("Kelvin:");
		TextField kelvin = new TextField();
		HBox kl = new HBox();
		cs.getChildren().addAll(K, kelvin);
		cs.setSpacing(10);
		
		GridPane root = new GridPane();  
		root.addRow(0, F, fahrenheit);  
		root.addRow(1, C, celsius);  
		root.addRow(2, K, kelvin);  
			
		Scene scene=new Scene(root, 800, 200);  
		primaryStage.setScene(scene);  
		primaryStage.setTitle("Yang_P_lab_11");  
		primaryStage.show();  	
	
		fahrenheit.setOnAction(e -> {
			Double fahr = Double.valueOf(fahrenheit.getText());
			Double cel = (fahr - 32)*5/9;
			int cc = (int)Math.round(cel);
			celsius.setText(String.valueOf(cc));
			Double k = (fahr - 32)*5/9 + 273.15;
			int kk = (int)Math.round(k);
			kelvin.setText(String.valueOf(kk));
		});

		celsius.setOnAction(e -> {
			Double cel = Double.valueOf(celsius.getText());
			Double fahr = (cel*9/5) + 32;
			int ff = (int)Math.round(fahr);
			fahrenheit.setText(String.valueOf(ff));
			Double k = cel + 273.15;
			int kk = (int)Math.round(k);
			kelvin.setText(String.valueOf(kk));
		});
		
		kelvin.setOnAction(e -> {
			Double k = Double.valueOf(kelvin.getText());
			Double cel = k - 273.15;
			int cc = (int)Math.round(cel);
			celsius.setText(String.valueOf(cc));
			Double fahr = (k - 273.15)*9/5 + 32;
			int ff = (int)Math.round(fahr);
			fahrenheit.setText(String.valueOf(ff));
		});
		
	}
}