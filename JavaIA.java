import java.util.Scanner;
import java.util.ArrayList;

class StageOfTheDay {
	String tDescription;
	int nChoices;
	String[] tChoices;
	int nSelected;
	String[] tComments;

	public StageOfTheDay(String desc, int choices) {
		tDescription = desc;
		nChoices = choices;
		tChoices = new String[nChoices];
		tComments = new String[nChoices];
		nSelected = -1;
	}

	public int AddChoice(int id, String t) {
		if (id < nChoices) {
			tChoices[id] = t;
			return 0;
		} else {
			return -1;
		}
	}

	public int AddComment(int id, String t) {
		if (id < nChoices) {
			tComments[id] = t;
			return 0;
		} else {
			return -1;
		}
	}

	public void Select(int id) {
		nSelected = id;
	}
}

class Day {
	ArrayList<StageOfTheDay> lStages;

	public Day() {
		lStages = new ArrayList<StageOfTheDay>();
	}

	public int AddStage(StageOfTheDay stage) {
		lStages.add(stage);
		return lStages.size();
	}
}

public class JavaIA {
	static Scanner in =  new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Would you like to start the game?");
		System.out.println("Enter 1 to play as a highschool student.");
		int n = in.nextInt();

		if (n == 1) {
			Day myDay = new Day();

			String d = "The alarm goes off at 6:00 AM. Technically, you could be waking up at 7:00 AM instead, but you’ve been trying to get your sleep schedule more into shape. Unfortunately, you didn’t get to sleep at a good time last night because of homework. You really don’t want to sleep through class - what do you want to do?";
			StageOfTheDay wakeup = new StageOfTheDay(d, 2);
			d = "Wake up";
			wakeup.AddChoice(0, d);
			d = "You drag yourself out of your bed, helped along with music. You end up doing a cardio workout.";
			wakeup.AddComment(0, d);
			d = "Sleep in";
			wakeup.AddChoice(1, d);
			d = "You end up sleeping in some more. Staying awake in class is more important.";
			wakeup.AddComment(1, d);
			myDay.AddStage(wakeup);

			d = "You finish your assignments from the first period. Your second period is your study hall: the lack of sleep you got from last night finally has kicked in, but you really have some overdue homework that you want to finish. Do you want to do your homework, or would you rather take a nap?";
			StageOfTheDay studyhall = new StageOfTheDay(d, 2);
			d = "Finish overdue homework";
			studyhall.AddChoice(0, d);
			d = "You decide to finish your overdue homework. Honestly, it feels a million times better now that the stress of the overdue homework is gone.";
			studyhall.AddComment(0, d);
			d = "Sleep through study hall";
			studyhall.AddChoice(1, d);
			d = "You decide to sleep through study hall. You’re feeling a little less exhausted, but your overdue homework is still a problem.";
			studyhall.AddComment(1, d);
			myDay.AddStage(studyhall);

			d = "It’s lunchtime now. You could either eat the less-than-appetizing lunch that you’ve brought, or you could run down to the convenience store next to school and pick up a much more delicious lunch.";
			StageOfTheDay lunch = new StageOfTheDay(d, 2);
			d = "Eat the food you brought";
			lunch.AddChoice(0, d);
			d = "The food wasn’t as bad as it looked. The protein and carb content was really high in it, so you’re feeling much more full and energized. And - you got to save your money.";
			lunch.AddComment(0, d);
			d = "Get food from a convenience store";
			lunch.AddChoice(1, d);
			d = "The meal was pretty unhealthy, but it was pretty good-tasting. But you are a little worried about spending money. Your bank account is starting to run low, and you’re worried about your mom noticing and being disappointed in your lack of saving abilities.";
			lunch.AddComment(1, d);
			myDay.AddStage(lunch);

			d = "You remind yourself that you’re saving up your money for once you graduate highschool, so you grab your bag and head off to work. It wasn’t that boring, surprisingly. Your friendly coworker was there today (for once).";
			StageOfTheDay work = new StageOfTheDay(d, 2);
			d = "Go to work";
			work.AddChoice(0, d);
			d = "You remind yourself that you’re saving up your money for once you graduate highschool, so you grab your bag and head off to work. It wasn’t that boring, surprisingly. Your friendly coworker was there today (for once).";
			work.AddComment(0, d);
			d = "Stay at school and hang out with your friends";
			work.AddChoice(1, d);
			d = "While you are trying to save up money, this nice weather is rare where you live. You and your friends have a good time messing around downtown.";
			work.AddComment(1, d);
			myDay.AddStage(work);

			d = "It’s now 5:30 PM. You’ve got a physics exam tomorrow that’s spooking you a little, so you could head home to study it. But you also hate skipping track practice, and you're trying to get on your coach's good side. What do you choose to do?";
			StageOfTheDay workout = new StageOfTheDay(d, 2);
			d = "Go to track and field practice";
			workout.AddChoice(0, d);
			d = "You go to practice. The nice weather lasted throughout all of practice, and you got in an awesome workout. You also feel much more ready for your meet.";
			workout.AddComment(0, d);
			d = "Study for tomorrow’s exam";
			workout.AddChoice(1, d);
			d = "You end up heading home to study for your physics exam. What you don’t expect, though, is your mom noticing that you skipped your track practice. She’s pretty disappointed. She hurls a few insults at you, then leaves you alone. You don’t mind her.";
			workout.AddComment(1, d);
			myDay.AddStage(workout);

			d = "After finally getting home, you get a message from your friends. They’re asking if you want to go out to dinner with them. The restaurant they’re thinking of is probably your all-time favorite restaurant, but you do have a physics test you should probably be studying for.";
			StageOfTheDay dinner = new StageOfTheDay(d, 2);
			d = "Go out for dinner with friends";
			dinner.AddChoice(0, d);
			d = "You go out with your friends for dinner and you don’t regret it at all. It’s a good time, and the fried chicken was awesome.";
			dinner.AddComment(0, d);
			d = "Have dinner at home";
			dinner.AddChoice(1, d);
			d = "You stay at home and study for your physics exam. Probably a good choice not to spend money anyways.";
			dinner.AddComment(1, d);
			myDay.AddStage(dinner);

			d = "Your day’s nearly done, but you can’t miss the last thing you always do: hit the gym. You can’t forget about your daily strength training. Besides, you never regret a workout. But you're already super exhausted, and you do have that physics test tomorrow that you should probably rest up for. What do you do?";
			StageOfTheDay closing = new StageOfTheDay(d, 2);
			d = "Workout";
			closing.AddChoice(0, d);
			d = "You complete your workout, and you feel absolutely awesome.";
			closing.AddComment(0, d);
			d = "Sleep early";
			closing.AddChoice(1, d);
			d = "You really do want to workout, but your entire body feels way too sluggish. You end up skipping it.";
			closing.AddComment(1, d);
			myDay.AddStage(closing);

			System.out.println("The day has started.");
			Player player = new Player();
			player.day(myDay);
		} else {
			System.out.println("Invalid input.");
		}
	}
}

class Player {
	static Scanner in =  new Scanner(System.in);
	
	int points1; //point system to decide ending.
	int points2; //point system to decide ending.
	
	public Player() {
		this.points1 = 0;//health
		this.points2 = 0;//anger
	}
	
	public void day(Day myDay) {
		for (StageOfTheDay stage: myDay.lStages) {
			System.out.println(stage.tDescription);
			for (int i = 0; i < stage.nChoices; i++)
				System.out.println((i + 1) + ": " + stage.tChoices[i]);

			int a = in.nextInt();
			System.out.println(stage.tComments[a -1]);
			if (a == 1)
				points1++;
			else if (a == 2)
				points2++;
			else
				System.out.println("Invalid input.");
		}
		
		//go to ending depending on the choices you made
		ending(points1, points2);
	}

	
	public void ending(int points1, int points2) {
		if (points2 > 5) {
			System.out.println("You're ready to wind down and fall asleep, but you hear footsteps coming from outside your bedroom.");
			System.out.println("Your mother enters the bedroom, face red in anger. She’s angry about the lack of effort you put into your day. You become defensive, wanting to argue against her screaming, but also knowing that she’s right.");
			System.out.println("Sometimes, days aren’t great. But you know that everyone has to deal with problems. And that nobody ever gets everything they want, even if they deserve better than the treatment they get. The only thing you can do is try to make tomorrow better.");
			System.out.println("You go to sleep. You can make tomorrow better than today.");
		}
		
		else if (points1 == 5) {
			System.out.println("You get into bed, ready for the next day. It’s not even midnight yet - a good start to cleaning up your sleep schedule for tomorrow. Hopefully, you’ll wake up on time again. There are always bad days, but sometimes, there are good days too. But you don’t just wait for the good days to happen by chance - you make them good days. You’re proud of yourself today.");
			System.out.println("You go to sleep. You can make tomorrow even better than today.");
		}
		
		else {
			System.out.println("You get into bed. You wonder if you worked hard enough today, if you improved at all. You think about the AP and IB tests you have to deal with in a few weeks, and the pile of IAs you still have to write. You think about the college applications weighing down on you. A small part of you wants to just sleep forever and give up on it all. But you remind yourself that while growth is painful, nothing is as painful as regret. Folding in on yourself because of some hard times is a recipe for failure.");
			System.out.println("You go to sleep. You can make tomorrow better than today.");
		}
	}
}
