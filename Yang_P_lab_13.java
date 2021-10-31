import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.animation.*;
import javafx.util.*;
import java.util.*;

class Yang extends Circle
{
  public double x_speed;
  public double y_speed;
  public double radius;
  private double fieldWidth;
  private double fieldHeight;
  private Color circlecolor;

  public Yang(double radius, double fieldWidth, double fieldHeight)
  
 {
    super();
    this.radius = radius;
    this.fieldWidth = fieldWidth;
    this.fieldHeight = fieldHeight;
    super.setRadius(radius);
    super.setCenterX(Math.random() * (fieldWidth - this.radius) + 1);	
	super.setCenterY(Math.random() * (fieldHeight - this.radius) + 1);

	this.x_speed = (Math.random()*5);
	this.y_speed = (Math.random()*5);

	int i = (int)(Math.random()*8);
	if (i == 0) circlecolor = Color.RED;
	else if (i == 1) circlecolor = Color.YELLOW;
	else if (i == 2) circlecolor = Color.GREEN;
	else if (i == 3) circlecolor = Color.PINK;
	else if (i == 4) circlecolor = Color.BLUE;
	else if (i == 5) circlecolor = Color.CYAN;
	else if (i == 6) circlecolor = Color.ORANGE;
	else if (i == 7) circlecolor = Color.MAGENTA;
    super.setFill(circlecolor);

  }
  
    public void move()
  {
    super.setCenterX(super.getCenterX() + this.x_speed);
	super.setCenterY(super.getCenterY() + this.y_speed);

    if (super.getCenterX() <= this.radius)
    {
      super.setCenterX(this.radius);
      this.x_speed = -this.x_speed;
    }

    if (super.getCenterX() >= (this.fieldWidth - this.radius))
    {
      super.setCenterX(this.fieldWidth - this.radius);
      this.x_speed = -this.x_speed;
    }

    if (super.getCenterY() <= this.radius)
    {
      super.setCenterY(this.radius);
      this.y_speed = -this.y_speed;
    }
	
    if (super.getCenterY() >= (this.fieldHeight - this.radius))
    {
      super.setCenterY(this.fieldHeight - this.radius);
      this.y_speed = -this.y_speed;
    }
	
  }
}
  
 class Neutrino extends Circle
 {
  public double x_speed;
  public double y_speed;
  public double radius;
  private double fieldWidth;
  private double fieldHeight;
  private Color neutrinocolor;

  public Neutrino(double radius, double fieldWidth, double fieldHeight)
  {
    super();
    this.radius = radius;
    this.fieldWidth = fieldWidth;
    this.fieldHeight = fieldHeight;
    super.setRadius(radius);
    super.setCenterX(Math.random() * (fieldWidth - this.radius) + 1);	
	super.setCenterY(Math.random() * (fieldHeight - this.radius) + 1);

	this.x_speed = (Math.random()*5);
	this.y_speed = (Math.random()*5);

	neutrinocolor = Color.BLACK;
    super.setFill(neutrinocolor);

  }
 
  
  public void neutrinomove()
  {
	super.setCenterX(super.getCenterX() + this.x_speed);
	super.setCenterY(super.getCenterY() + this.y_speed);

    if (super.getCenterX() <= this.radius)
    {
      super.setCenterX(this.fieldWidth - this.radius);
	  
    }

    if (super.getCenterX() >= (this.fieldWidth - this.radius))
    {
      super.setCenterX(this.radius);
    }

    if (super.getCenterY() <= this.radius)
    {
      super.setCenterY(this.fieldHeight - this.radius);
    }
	
    if (super.getCenterY() >= (this.fieldHeight - this.radius))
    {
      super.setCenterY(this.radius);
    }
	
  }
}

public class Yang_P_lab_13 extends Application {

  public static void main(String[] args)
  {
    launch(args);
  }

	final private int WIDTH = 600;
	final private int HEIGHT = 500;
	final private int CIRCLE_SIZE = 10;
	final private int NEUTRINO_WIDTH = 600;
	final private int NEUTRINO_HEIGHT = 500;
	final private int NEUTRINO_SIZE = 10;

  public void start(final Stage primaryStage)
  {
	int i;
	int balls = 20;
	int neutrinos = 20;
	
	Yang[] mycircles = new Yang[balls];
	Neutrino[] myneutrinos = new Neutrino[neutrinos];
	FlowPane root = new FlowPane();
	Pane pane = new Pane();
	

	for (i = 0; i < balls; i++) {	
		mycircles[i] = new Yang(CIRCLE_SIZE, WIDTH, HEIGHT);
		pane.getChildren().add(mycircles[i]);
	}
	
	for (i = 0; i < neutrinos; i++) {	
		myneutrinos[i] = new Neutrino(NEUTRINO_SIZE, NEUTRINO_WIDTH, NEUTRINO_HEIGHT);
		pane.getChildren().add(myneutrinos[i]);
	}
	
	root.getChildren().add(pane);

    Scene scene = new Scene(root, WIDTH, HEIGHT);
    primaryStage.setTitle("Yang_P_lab_13");
    primaryStage.setScene(scene);
    primaryStage.show();

	KeyFrame k = new KeyFrame(Duration.millis(10),
			e ->
			{
              for (Yang circle : mycircles)
				circle.move();
			  for (Neutrino neutrino : myneutrinos)
				neutrino.neutrinomove();
			});

    Timeline t = new Timeline(k);
    t.setCycleCount(Timeline.INDEFINITE);
    t.play();
  }

}