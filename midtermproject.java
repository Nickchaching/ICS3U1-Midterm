import arc.*;

public class midtermproject{
	public static void main(String[]args){
		Console con = new Console("Escape Room", 1280, 720);
		
		//Scene Configuration Variables (Prevents 10 Sub-if/while/for loops for nested scenes)
		double dblscene = 0; //Corresponds with scene count, "-1" to end story, ".1" to represent a path and ".2" to represent b path if possible
		int intgamedone = 0; //0 = Not Completed, 1 = Completed, stops loop
		
		//Main Function Variables
		String struser = ""; 		//Scene 0
		int intcount;
		char chrstart; 				//Scene 1
		//N/A						//Scene 2
		int intmouseclicked;		//Scene 3
		double dblpuzzleinput;		//Scene 4
		double dblpuzzle1 = 0; 
		double dblpuzzle2 = 0;
		double dblpuzzle3 = 0;
		double dblpuzzle4 = 0;
		double dblpuzzle5 = 0;
		int intrandom;				//Scene 5
		int intrandominput = 0;
		int inttries = 0;
		//N/A						//Scene 6
		String strpalword;			//Scene 7
		String strpalwordback = "";
		String strpalletter;
		int intstrpalwordlength;
		int intpalcount;
		
		
		//Main Scenes Loop
		while(intgamedone < 1){
			
			//Initializing Adventure (Not a Scene - Scene 0)
			while(dblscene == 0){
				con.println("What is your name?");
				struser = con.readLine();
				for(intcount = 1; intcount <= 5; intcount++){
					con.clear();
					con.println("Initializing Code");
					con.sleep(250);
					con.clear();
					con.println("Initializing Code.");
					con.sleep(250);
					con.clear();
					con.println("Initializing Code..");
					con.sleep(250);
					con.clear();
					con.println("Initializing Code...");
					con.sleep(250);
					con.clear();
				}
				dblscene = 1;
			}
			
			//Scene 1: Welcome Screen
			while(dblscene == 1){
				scene1(con);
				con.println("TEMP - Scene 1");
				//Scene Text
				con.println("Welcome "+struser+"! You decide to go to an escape room with your friends");
				con.println("Press 's' to start and any other key to quit and head home.");
				//Scene Input
				chrstart = con.getChar();
				//Condition - Goes Home 
				if(chrstart != 's'){
					dblscene = 2;
				}
				//Condition - Starts the Escape Room
				else if(chrstart == 's'){
					dblscene = 3;
				}
			}
			
			//Scene 2: END OF GAME - Went home
			while(dblscene == 2){
				scene2(con);
				con.println("TEMP - Scene 2");
				con.println("You decided to go home and not play, game over");
				
				//End Game 
				dblscene = -1;
				intgamedone = 1;
			}
			
			//Scene 3: Escape Room Start Screen
			while(dblscene == 3){
				scene3(con);
				con.println("TEMP - Scene 3");
				//Scene Text
				con.println("You have decided to play the escape room, you have 45 minutes to successfully escape.");
				con.println("You will be challenged with puzzles, complete them correctly to go down the right path and win the game!");
				con.println("Click anywhere to start your first challenge!");
				intmouseclicked = 0;
				//Condition - Must Complete to Advance
				while(intmouseclicked == 0){
					intmouseclicked = con.currentMouseButton();
				}
				dblscene = 4;
			}
			
			//Scene 4: Puzzle Organizing Challenge
			while(dblscene == 4){
				scene4(con);
				con.println("TEMP - Scene 4");
				//Scene Text
				con.println("Organize the following puzzle pieces in the proper order to form a connected line.");
				con.println("The puzzle pieces are each currently placed in a location");
				con.println("To rearrange the puzzle pieces, input the new rearrangement in the following format");
				con.println("Piece 1 to Location 3: Input '1.3'; Piece 2 to Loaction 1: Input '2.1'");
				//Loop to Input and Sort Numbers into correct order
				for(intcount = 1; intcount <= 5; intcount++){
					dblpuzzleinput = con.readDouble();
					con.println("Piece #"+intcount+" LOCKED");
					if(intcount == 1){
						dblpuzzle1 = dblpuzzleinput;
					}
					else if(intcount == 2){
						dblpuzzle2 = Math.min(dblpuzzle1, dblpuzzleinput);
						dblpuzzle1 = Math.max(dblpuzzle1, dblpuzzleinput);
					}
					else if(intcount == 3){
						if(dblpuzzleinput > dblpuzzle1){
							dblpuzzle3 = dblpuzzle2;
							dblpuzzle2 = dblpuzzle1;
							dblpuzzle1 = dblpuzzleinput;
						}
						else{
							dblpuzzle3 = Math.min(dblpuzzle2, dblpuzzleinput);
							dblpuzzle2 = Math.max(dblpuzzle2, dblpuzzleinput);
						}
					}
					else if(intcount == 4){
						if(dblpuzzleinput > dblpuzzle1){
							dblpuzzle4 = dblpuzzle3;
							dblpuzzle3 = dblpuzzle2;
							dblpuzzle2 = dblpuzzle1;
							dblpuzzle1 = dblpuzzleinput;
						}
						else if(dblpuzzleinput > dblpuzzle2){
							dblpuzzle4 = dblpuzzle3;
							dblpuzzle3 = dblpuzzle2;
							dblpuzzle2 = dblpuzzleinput;
						}
						else if(dblpuzzleinput > dblpuzzle3){
							dblpuzzle4 = dblpuzzle3;
							dblpuzzle3 = dblpuzzleinput;
						}
						else{
							dblpuzzle4 = dblpuzzleinput;
						}	
					}
					else if(intcount == 5){
						if(dblpuzzleinput > dblpuzzle1){
							dblpuzzle5 = dblpuzzle4;
							dblpuzzle4 = dblpuzzle3;
							dblpuzzle3 = dblpuzzle2;
							dblpuzzle2 = dblpuzzle1;
							dblpuzzle1 = dblpuzzleinput;
						}
						else if(dblpuzzleinput > dblpuzzle2){
							dblpuzzle5 = dblpuzzle4;
							dblpuzzle4 = dblpuzzle3;
							dblpuzzle3 = dblpuzzle2;
							dblpuzzle2 = dblpuzzleinput;
						}
						else if(dblpuzzleinput > dblpuzzle3){
							dblpuzzle5 = dblpuzzle4;
							dblpuzzle4 = dblpuzzle3;
							dblpuzzle3 = dblpuzzleinput;
						}
						else if(dblpuzzleinput > dblpuzzle4){
							dblpuzzle5 = dblpuzzle4;
							dblpuzzle4 = dblpuzzleinput;
						}
						else{
							dblpuzzle5 = dblpuzzleinput;
						}
					}
				}
				//Condition (CR) - Advances to Palindrome Challenge
				if(dblpuzzle1 == 5.4 && dblpuzzle2 == 4.2 && dblpuzzle3 == 3.3 && dblpuzzle4 == 2.5 && dblpuzzle5 == 1.1){
					dblscene = 7;
				}
				//Condition (IR) - Advances to Guessing a Random Number
				else{
					dblscene = 5;
				}
			}
			
			//Scene 5: Random Number Guessing Challenge
			while(dblscene == 5){
				scene5(con);
				con.println("TEMP - Scene 5");
				//RNG
				intrandom = (int)(Math.random()*100+1);
				//Scene Text
				con.println("An integer between 1 - 100 is generated, the number of guesses you need");
				con.println("will determine your fate! You will know if your answer is higher or lower");
				con.println("Make a guess!");
				//Looping until guessed correct answer
				while(intrandominput != intrandom){
					intrandominput = con.readInt();
					if(intrandominput == intrandom){
						con.println("You guessed the correct number!!!");
					}
					else if(intrandominput > intrandom){
						con.println("Too High! Guess again!");
					}
					else if(intrandominput < intrandom){
						con.println("Too Low! Guess again!");
					}
					inttries = inttries + 1;
				}
				//Condition (CR) - Advances to Two Door Scene (b)
				if(inttries <= 10){
					con.println("Number guessed in "+inttries+" tries");
					dblscene = 8.2;
				}
				//Condition (IR) - Game over (no time)
				else if(inttries > 10){
					con.println("Number guessed in "+inttries+" tries");
					dblscene = 6;
				}
			}
			
			//Scene 6: END OF GAME - Random Number
			while(dblscene == 6){
				scene6(con);
				con.println("TEMP - Scene 6");
				con.println("Unfortunately, you ran out of time and lost, try again!");
				
				//End Game
				dblscene = -1;
				intgamedone = 1;
			}
			
			//Scene 7: Palindrome Challenge
			while(dblscene == 7){
				scene7(con);
				con.println("TEMP - Scene 7");
				//Scene Text
				con.println("A palindrome is a word that can be spelled the same both backwards and forwards.");
				con.println("Give me 5 palindromes!");
				//Loop to repeat code to allow input for 5 palindromes
				for(intpalcount = 1; intpalcount <= 5; intpalcount++){
					strpalwordback = "";
					con.println("Enter a word");
					strpalword = con.readLine();
					intstrpalwordlength = strpalword.length();
					
					//Loop to reverse inputted word
					for(intcount = intstrpalwordlength; intcount >= 1; intcount--){
						strpalletter = strpalword.substring(intcount - 1, intcount);
						strpalwordback = strpalwordback + strpalletter;
					}
					
					//Condition (CR) - Repeats Loop
					if(strpalwordback.equals(strpalword)){
						con.println("Correct, "+strpalword+" is a pallindrome. "+intpalcount+" pallindrome inputted.");
					}
					//Condition (IR) - Advances to Two Door Scene (b)
					else{
						con.println("Incorrect, "+strpalword+" is not a pallindrome.");
						intpalcount = 999;
						dblscene = 8.2;
					}
				}
				//Condition (CR) - Advances to Two Door Scene (a)
				if(intpalcount != 1000){
					dblscene = 8.1;
				}	
			}


			//TESTING Section
			while(dblscene == 999){	
				int inttest;
				inttest = con.currentMouseButton();
				con.println(inttest);
			}
		}
	}
	
	//Scene 1 Graphics
	public static void scene1(Console con){
		
	}
	//Scene 2 Graphics
	public static void scene2(Console con){
		
	}
	//Scene 3 Graphics
	public static void scene3(Console con){
		
	}
	//Scene 4 Graphics
	public static void scene4(Console con){
		
	}
	//Scene 5 Graphics
	public static void scene5(Console con){
		
	}
	//Scene 6 Graphics
	public static void scene6(Console con){
		
	}
	//Scene 7 Graphics
	public static void scene7(Console con){
		
	}
	//Scene 8 Graphics
	public static void scene8(Console con){
		
	}
	//Scene 9 Graphics
	public static void scene9(Console con){
		
	}
	//Scene 10 Graphics
	public static void scene10(Console con){
		
	}
	//Scene 11 Graphics
	public static void scene11(Console con){
		
	}
	//Scene 12 Graphics
	public static void scene12(Console con){
		
	}
	//Scene 13 Graphics
	public static void scene13(Console con){
		
	}
	//Scene 14 Graphics
	public static void scene14(Console con){
		
	}
	
}
