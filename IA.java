import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.*;
import javafx.application.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text;

//Defining classes in the game

//each question where there's a choice is a stage of the day
class StageOfTheDay {
	String tDescription; //text description for the stage
	int nChoices; //number of choices in that stage
	String[] tChoices; //text descriptions of each choice in the stage
	int nSelected; //which choice is selected
	String[] tComments; //comments that accompany each choice
	ChoiceBox<String> cb;

	public StageOfTheDay(String desc, int choices) {
		tDescription = desc;
		nChoices = choices;
		tChoices = new String[nChoices];
		tComments = new String[nChoices];
		cb = new ChoiceBox<>();
		nSelected = -1;
	}

	//method to add a choice into the stage
	public int AddChoice(int id, String t) {
		if (id < nChoices) {
			tChoices[id] = t;
			return 0;
		} else {
			return -1;
		}
	}

	//method to add a comment into each choice in the stage
	public int AddComment(int id, String t) {
		if (id < nChoices) {
			tComments[id] = t;
			return 0;
		} else {
			return -1;
		}
	}

	//method to make a selection of the choice
	public int Selected() {
		String s = cb.getValue();
		for (int i = 0; i < nChoices; i++) {
			if (s.equals(tChoices[i]))
				return i + 1;
		}
		return 1;
	}
}


//define a day
class Day {
	int index;
	ArrayList<StageOfTheDay> lStages; //arraylist of stages in the day

	//constructor to build the arraylist
	public Day() {
		lStages = new ArrayList<StageOfTheDay>();
		index = 0;
	}

	//add a stage to the arraylist
	public int AddStage(StageOfTheDay stage) {
		lStages.add(stage);
		return lStages.size();
	}

	public StageOfTheDay GetNextStage() {
		if (index >= lStages.size())
			index = 0;
		return lStages.get(index++);
	}

	public int GetCurrentIndex() {
		return index;
	}

	public void SetCurrentIndex(int id) {
		index = id;
	}

	public StageOfTheDay GetStage(int id) {
		if (id >= lStages.size())
			id = 0;
		return lStages.get(id);
	}
}


public class IA extends Application {

	Day myDay;
	boolean bRestart = false;
	boolean bInitialized = false;

	//GUI portion of the game
	@Override
	public void start(Stage primaryStage) {
		Day myDay = dayInit();

		VBox vbox = new VBox(10);

		Label comment = new Label();
		comment.setWrapText(true);
		comment.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.ITALIC, 20));

		Label desc = new Label();
		desc.setWrapText(true);
		desc.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 20));
		desc.setText("Would you like to start the game?");
		
		Button next = new Button();
		next.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 20));
		next.setText("Begin my day");

		next.setOnAction(new EventHandler<ActionEvent>() {
 
			@Override
			public void handle(ActionEvent event) {
				vbox.getChildren().clear();

				if (bRestart) {
					desc.setText("Would you like to start the game?");
					vbox.getChildren().add(desc);
					next.setText("Begin my day");
					vbox.getChildren().add(next);
					bRestart = false;
					myDay.SetCurrentIndex(0);
					return;
				}

				int cid = myDay.GetCurrentIndex();

				if (cid >=1) {
					String c = new String();
					for (int i = 0; i < cid; i++) {
						StageOfTheDay stage = myDay.GetStage(i);
						int sel = stage.Selected();
						c += stage.tChoices[sel - 1] + ": " + stage.tComments[sel - 1] + "\r\n";
					}
					comment.setText(c);
					vbox.getChildren().add(comment);
				}

				if (cid < myDay.lStages.size()) {
					StageOfTheDay stage = myDay.GetNextStage();

					desc.setText(stage.tDescription);
					vbox.getChildren().add(desc);
					if (!bInitialized) {
						for (int i = 0; i < stage.nChoices; i++)
							stage.cb.getItems().add(stage.tChoices[i]);
					}
					stage.cb.setValue(stage.tChoices[0]);
					vbox.getChildren().add(stage.cb);
					next.setText("Next");
					vbox.getChildren().add(next);
				} else {
					int points1 = 0;
					int points2 = 0;
					for (StageOfTheDay stage: myDay.lStages) {
						if (stage.Selected() == 1)
							points1++;
						else
							points2++;
					}
					System.out.println("points1 = " + points1 + ", " + "points2 = " + points2);

					//replace endings according to narrative

					if (points2 > 5) {
						String d = new String("You're about to turn in for the day, but your mom shows up at your bedroom door and decides to yell at you for being unproductive that day and also blowing your paycheck. You argue a little with her even though she's right.");
						d = d + "\r\n" + "You go to sleep feeling like a total loser.";
						desc.setText(d);
					} else if (points1 > 5) {
						String e = new String("It's not even midnight, and you're already going to sleep. Your sleep schedule is finally fixing itself. Getting enough sleep is important for the gains, so you're pretty proud of yourself. You made some pretty solid choices throughout the day.");
						e = e + "\r\n" + "You go to sleep feeling cool.";
						desc.setText(e);
					} else {
						String f = new String("The day is finally over. You had a very average day. You think about all the AP and IB tests you'll have to deal with. You think about how your CS IA is not getting turned in on time.");
						f = f + "\r\n" + "You go to sleep feeling average.";
						desc.setText(f);
					}
					vbox.getChildren().add(desc);
					next.setText("Play Again");
					vbox.getChildren().add(next);
					bRestart = true;
					bInitialized = true;
				}
			}
		});

		vbox.getChildren().addAll(desc, next);

		Scene scene = new Scene(vbox, 950, 700);
		primaryStage.setTitle("Day in Life: Text-Based Game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}


	public Day dayInit() {
		Day md = new Day();

		//choices and text editing: replace text according to narrative
		//AddStage to add another situation, use AddChoice to edit number of choices

		String d = "The alarm goes off at 6:00 AM. Technically, you could be waking up at 7:00 AM instead, but you've been trying to get your sleep schedule together. Unfortunately, you didn't get to sleep at a good time last night because of homework. What do you want to do?";
		StageOfTheDay wakeup = new StageOfTheDay(d, 2);
		d = "Wake up";
		wakeup.AddChoice(0, d);
		d = "You drag yourself out of your bed and do a cardio workout. It puts your shins in crippling agony, but it's worth it.";
		wakeup.AddComment(0, d);
		d = "Sleep in";
		wakeup.AddChoice(1, d);
		d = "You end up sleeping in until 7:00 AM. You pray that you don't fall asleep in class later and get points knocked off your participation.";
		wakeup.AddComment(1, d);
		md.AddStage(wakeup);

		d = "You finish your assignments from the first period. Your second period is your study hall: the lack of sleep and the absence of hyper-caffeinated energy drinks has kicked in, but you really have some overdue homework that you want to finish. Do you want to do your homework, or would you rather take a nap?";
		StageOfTheDay studyhall = new StageOfTheDay(d, 2);
		d = "Finish overdue homework";
		studyhall.AddChoice(0, d);
		d = "You decide to finish your overdue homework (for once). Maybe your mom won't notice it was overdue in the first place.";
		studyhall.AddComment(0, d);
		d = "Sleep through study hall";
		studyhall.AddChoice(1, d);
		d = "You decide to sleep through study hall. While you do feel more energized, you can already see the overdue homework being a problem for you down the road.";
		studyhall.AddComment(1, d);
		md.AddStage(studyhall);

		d = "It's lunchtime now. You could either eat the less-than-appetizing protein-loaded lunch that you've brought, or you could run down to the convenience store next to school and pick up a much more delicious lunch. ";
		StageOfTheDay lunch = new StageOfTheDay(d, 2);
		d = "Eat the food you brought";
		lunch.AddChoice(0, d);
		d = "It tasted pretty awful. But you saved money AND hit your protein requirements for the day.";
		lunch.AddComment(0, d);
		d = "Get food from a convenience store";
		lunch.AddChoice(1, d);
		d = "The meal was pretty unhealthy, but it was pretty good-tasting. But you are a little worried about spending money. Your bank account is starting to run low, and your mom is probably going to lecture you on saving your money.";
		lunch.AddComment(1, d);
		md.AddStage(lunch);

		d = "After a few more classes, school is finally over. You could either go to work - or you could take the time to hang out with your friends for once. The weather's way too good to stay inside doing some boring part-time job. What do you decide to do?";
		StageOfTheDay work = new StageOfTheDay(d, 2);
		d = "Go to work";
		work.AddChoice(0, d);
		d = "You remind yourself that you're saving up for a sick pair of Pit Vipers, so you grab your bag and head off to work.";
		work.AddComment(0, d);
		d = "Stay at school and hang out with your friends";
		work.AddChoice(1, d);
		d = "Although you ARE trying to save money, this nice weather is rare where you live. You and your friends have a good time messing around downtown.";
		work.AddComment(1, d);
		md.AddStage(work);

		d = "It's now 5:30 PM. You've got a physics exam tomorrow that's spooking you a little, so you could head home to study it. But you also hate skipping track practice, and you're trying to get on your coach's good side. What do you choose to do?";
		StageOfTheDay practice = new StageOfTheDay(d, 2);
		d = "Go to track and field practice";
		practice.AddChoice(0, d);
		d = "You go to practice. The nice weather lasted throughout all of practice, and even though you nearly decked your friend in the jaw with a discus, you feel ready for the meet.";
		practice.AddComment(0, d);
		d = "Study for tomorrow's exam";
		practice.AddChoice(1, d);
		d = "You end up heading home to study for your physics exam. What you don't expect, though, is your mom noticing that you skipped your track practice. She's pretty disappointed. Whoops.";
		practice.AddComment(1, d);
		md.AddStage(practice);

		d = "After finally getting home, you get a message from your friends. They're asking if you want to go out to dinner with them. The restaurant they're thinking of sounds real good, but you DO have that physics test you should probably be studying for.";
		StageOfTheDay dinner = new StageOfTheDay(d, 2);
		d = "Stay home";
		dinner.AddChoice(0, d);
		d = "You stay at home and study for your physics exam. Probably a good choice not to spend money anyways.";
		dinner.AddComment(0, d);
		d = "Go out for dinner with friends";
		dinner.AddChoice(1, d);
		d = "You go out with your friends for dinner. You had pretty overpriced fried chicken.";
		dinner.AddComment(1, d);
		md.AddStage(dinner);

		d = "Your day's nearly done, but you can't miss the last thing you always do: hit the gym. Gotta get those gains. But you also gotta get those physics grade gains and sleep early for tomorrow's test. What do you do?";
		StageOfTheDay workout = new StageOfTheDay(d, 2);
		d = "Workout";
		workout.AddChoice(0, d);
		d = "You do your workout. You feel cool.";
		workout.AddComment(0, d);
		d = "Sleep early";
		workout.AddChoice(1, d);
		d = "Despite the iron plates practically calling your name, you go straight to bed.";
		workout.AddComment(1, d);
		md.AddStage(workout);

		return md;
	}
}
