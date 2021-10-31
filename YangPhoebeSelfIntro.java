import java.util.Scanner;

class  YangPhoebeSelfIntro {
	static Scanner in = new Scanner(System.in);
	
	public static int getAnInt(){
		int retval = 0;
		boolean done = false;
		String dummy;
		while(!done){
			System.out.println("Enter an integer:");
			if(in.hasNextInt()){
				done = true;
				retval = in.nextInt();
			} else {
				System.out.println("Integer values only, please re-enter a valid input: ");
				dummy = in.next();
			}
		}
		return retval;
	}//getAnInt
	
	public static void hobbies(){
		System.out.println("I enjoy fitness (such as running and lifting).");
		System.out.println("I also enjoy video games and hanging out with my friends.");
		System.out.println("I also enjoy doing math and studying military history.\n\n");
	}
		
	public static void favorites(){
		System.out.println("Favorite subject: Computer Science or Math");
		System.out.println("Favorite movie/TV show genre: Action");
		System.out.println("Favorite music genre: Industrial metal/Power metal");
		System.out.println("Favorite video game: Far Cry 5");
		System.out.println("Favorite movie: Inglourious Basterds");
		System.out.println("Favorite lift: Back Squats");
		System.out.println("Favorite code language: Java");
		System.out.println("Favorite food: oreo flavored ice cream");
		System.out.println("Favorite color: navy blue, red, and white/silver");
		System.out.println("Favorite country: USA");
		System.out.println("Favorite bands: Sabaton, Rammstein\n\n");
	}
		
	public static void facts(){
		System.out.println("My enneagram is 8");
		System.out.println("My dream colleges are USAFA, West Point, and USNA");
		System.out.println("I'm on Lincoln's cheer team");
		System.out.println("I'm a paid IT intern at an e-commerce company");
		System.out.println("I want to major in cyberscience or computer science");
		System.out.println("I hate using replit because I was forced to use it back when I had a chromebook");
		System.out.println("I reply to emails very quickly");
		System.out.println("My weighted GPA is 4.542\n\n");
	}

	
	public static void main(String args[]) {
		int inputnum = -1;
		System.out.println("My name is Phoebe. Nice to meet you!");
		
		while(inputnum != 0) {
			System.out.println("Enter the number corresponding to what you'd like to know");
			System.out.println("0: Quit the program");
			System.out.println("1: Hobbies");
			System.out.println("2: Favorites");
			System.out.println("3: Extra/Random Facts\n");
			
			inputnum = getAnInt();
			
			switch (inputnum){
				case 0: break;
				case 1: hobbies();
						break;
				case 2: favorites();
						break;
				case 3: facts();
						break;
				default: System.out.println("Illegal value entered");
			}
		}
	}//main
}