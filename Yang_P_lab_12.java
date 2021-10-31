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

	int i = (int)(Math.random()*10);
	if (i == 0) circlecolor = Color.RED;
	else if (i == 1) circlecolor = Color.YELLOW;
	else if (i == 2) circlecolor = Color.GREEN;
	else if (i == 3) circlecolor = Color.BLACK;
	else if (i == 4) circlecolor = Color.PINK;
	else if (i == 5) circlecolor = Color.BLUE;
	else if (i == 6) circlecolor = Color.CYAN;
	else if (i == 7) circlecolor = Color.GRAY;
	else if (i == 8) circlecolor = Color.MAGENTA;
	else if (i == 9) circlecolor = Color.ORANGE;
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

public class Yang_P_lab_12 extends Application {

  public static void main(String[] args)
  {
    launch(args);
  }

  final private int WIDTH = 600;
  final private int HEIGHT = 500;
  final private int CIRCLE_SIZE = 10;

  public void start(final Stage primaryStage)
  {
	int i;
	int balls = (int)(Math.random()*40 + 10);
	
	Yang[] mycircles = new Yang[balls];
	FlowPane root = new FlowPane();
	Pane pane = new Pane();

	for (i = 0; i < balls; i++) {	
		mycircles[i] = new Yang(CIRCLE_SIZE, WIDTH, HEIGHT);
		pane.getChildren().add(mycircles[i]);
	}
	root.getChildren().add(pane);

    Scene scene = new Scene(root, WIDTH, HEIGHT);
    primaryStage.setTitle("Yang_P_lab_12");
    primaryStage.setScene(scene);
    primaryStage.show();

	KeyFrame k = new KeyFrame(Duration.millis(10),
			e ->
			{
              for (Yang circle : mycircles)
				  circle.move();
			});

    Timeline t = new Timeline(k);
    t.setCycleCount(Timeline.INDEFINITE);
    t.play();
  }

}
