//Name of Game: Escape Room
//Name of Programmer: Nicholas Ching
//Version Number: 13

//Importing Libraries
import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class midtermproject{
	public static void main(String[]args){
		Console con = new Console("Escape Room", 1280, 720);
		
		//Scene Configuration Variables (Prevents Sub-if/while/for loops for nested scenes and Enables accelerated testing)
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
		int intposx;				//Scene 8
		int intposy;
		//intmouseclicked used
		//N/A						//Scene 9
		int introotvala = 0;		//Scene 10a
		int introotvalb = 0;
		int introotvalc = 0;
		double dbldiscriminant;
		int introots = 0;
		double dblroota;			//Scene 10b
		double dblrootb;
		double dblrootaans;
		double dblrootbans;
		double dblrootaansrnd;
		double dblrootbansrnd;
		double dblrootvala = 0;		//Scene 11a
		double dblrootvalb = 0;
		double dblrootvalc = 0;
		//dbldiscriminant used
		//introots used
		//dblroota used				//Scene 11b
		//dblrootb used
		//dblrootaans used
		//dblrootbans used
		//dblrootaansrnd used
		//dblrootbansrnd used
		//N/A						//Scene 12
		//N/A						//Scene 13
		//N/A						//Scene 14
		
		//Main Scenes Loop
		while(intgamedone < 1){
			
			//Initializing Adventure (Not a scene as there is no linked method - "Scene 0")
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
				//Advances to Scene 1 after Initializing
				dblscene = 1;
			}
			
			//Scene 1: Welcome Screen
			while(dblscene == 1){
				con.clear();
				scene1(con, dblscene);
				//Scene Text
				con.println("Welcome "+struser+"! You decide to go to an escape room with your friends");
				con.println("Press 's' to start and any other key to quit and head home.");
				//Scene Input
				chrstart = con.getChar();
				//Condition - Goes Home (Scene 2)
				if(chrstart != 's'){
					dblscene = 2;
				}
				//Condition - Starts the Escape Room (Scene 3)
				else if(chrstart == 's'){
					dblscene = 3;
				}
				scene1(con, dblscene);
			}
			
			//Scene 2: END OF GAME - Went home
			while(dblscene == 2){
				con.clear();
				scene2(con);
				//Scene Text
				con.println("You decided to go home and not play, game over");
				
				//End Game 
				dblscene = -1;
				intgamedone = 1;
			}
			
			//Scene 3: Escape Room Start Screen
			while(dblscene == 3){
				con.clear();
				scene3(con);
				//Scene Text
				con.println("You have decided to play the escape room, you have 45 minutes to successfully escape.");
				con.println("You will be challenged with puzzles, complete them correctly to go down the right path and win the game!");
				con.println("Click anywhere to start your first challenge!");
				intmouseclicked = 0;
				//Condition - Must Complete to Advance to Scene 4
				while(intmouseclicked == 0){
					intmouseclicked = con.currentMouseButton();
				}
				dblscene = 4;
			}
			
			//Scene 4: Puzzle Organizing Challenge
			while(dblscene == 4){
				con.clear();
				scene4(con, dblscene);
				//Scene Text
				con.println("Organize the following puzzle pieces in the proper order to form a connected line.");
				con.println("The puzzle pieces are each currently placed in a location, assume pieces 4 and 5 are placed after piece 3.");
				con.println("To rearrange the puzzle pieces, input the new rearrangement in the following format.");
				con.println("EXAMPLE: Piece 1 to Location 3: Input '1.3'; Piece 2 to Location 1: Input '2.1'");
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
				//Condition (CR) - Advances to Palindrome Challenge (Scene 7)
				if(dblpuzzle1 == 5.4 && dblpuzzle2 == 4.2 && dblpuzzle3 == 3.3 && dblpuzzle4 == 2.5 && dblpuzzle5 == 1.1){
					dblscene = 7;
				}
				//Condition (IR) - Advances to Guessing a Random Number (Scene 5)
				else{
					dblscene = 5;
				}
				scene4(con, dblscene);
			}
			
			//Scene 5: Random Number Guessing Challenge
			while(dblscene == 5){
				con.clear();
				scene5(con, dblscene);
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
				//Condition (CR) - Advances to Two Door Scene (Scene 8b)
				if(inttries <= 10){
					con.println("Number guessed in "+inttries+" tries");
					dblscene = 8.2;
				}
				//Condition (IR) - Game over, no time (Scene 6)
				else if(inttries > 10){
					con.println("Number guessed in "+inttries+" tries, that is too many tries!");
					dblscene = 6;
				}
				scene5(con, dblscene);
			}
			
			//Scene 6: END OF GAME - Random Number
			while(dblscene == 6){
				con.clear();
				scene6(con);
				con.println("Unfortunately, you ran out of time and lost, try again!");
				
				//End Game
				dblscene = -1;
				intgamedone = 1;
			}
			
			//Scene 7: Palindrome Challenge
			while(dblscene == 7){
				con.clear();
				scene7(con,dblscene);
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
						con.println("Correct, "+strpalword+" is a palindrome. "+intpalcount+" palindromes inputted.");
					}
					//Condition (IR) - Advances to Two Door Scene (Scene 8b)
					else{
						con.println("Incorrect, "+strpalword+" is not a palindrome.");
						intpalcount = 999;
						dblscene = 8.2;
					}
				}
				//Condition (CR) - Advances to Two Door Scene (Scene 8a)
				if(intpalcount == 6){
					dblscene = 8.1;
				}	
				scene7(con, dblscene);
			}
			
			//Scene8(a): The Door Dilemma
			while(dblscene == 8.1){
				con.clear();
				scene8a(con, dblscene);
				//Scene Text
				con.println("You have two doors to choose from. One will be good, and one will be bad.");
				con.println("Position your mouse over the door you want to choose and click. Choose Wisely!");
				//Loop to repeat code until a door has been chosen
				while(dblscene == 8.1){
					intmouseclicked = con.currentMouseButton();
					intposx = con.currentMouseX();
					intposy = con.currentMouseY();
					//For now, assume full left side is the left door, and full right side is the right door
					//Condition (CR) - Advances to Integer Number Quadratic (Scene 10a)
  					if(intposx < 720 && intmouseclicked > 0){
						dblscene = 10.1;
					}
					//Condition (IR) - Advances to Double Number Quadratic (Scene 11a)
					else if(intposx > 720 && intmouseclicked > 0){
						dblscene = 11.1;
					}
				}
				scene8a(con, dblscene);
			}
			
			//Scene8(b): The Door Dilemma
			while(dblscene == 8.2){
				con.clear();
				scene8b(con, dblscene);
				//Scene Text
				con.println("You have two doors to choose from. One will be good, and one will be bad.");
				con.println("Position your mouse over the door you want to choose and click. Choose Wisely!");
				//Loop to repeat code until a door has been chosen
				while(dblscene == 8.2){
					intmouseclicked = con.currentMouseButton();
					intposx = con.currentMouseX();
					intposy = con.currentMouseY();
					//For now, assume full left side is the left door, and full right side is the right door
					//Condition (CR) - Advances to Double Number Quadratic (Scene 11a)
  					if(intposx < 720 && intmouseclicked > 0){
						dblscene = 11.1;
					}
					//Condition (IR) - Game Over, Wrong Door (Scene 9)
					else if(intposx > 720 && intmouseclicked > 0){
						dblscene = 9;
					}
				}
				scene8b(con, dblscene);
			}

			//Scene 9: END OF GAME - Wrong Door
			while(dblscene == 9){
				con.clear();
				scene9(con);
				con.println("Game over, you chose the wrong door and lost. Try again!");
				
				//End Game
				dblscene = -1;
				intgamedone = 1;
			}
			
			//Scene 10(a): Integer Quadratic Challenge (Input)
			while(dblscene == 10.1){
				con.clear();
				scene10a(con, dblscene);
				//Scene Text
				con.println("Enter 3 Integer Numbers to proceed!");
				//Scene Input
				introotvala = con.readInt();
				introotvalb = con.readInt();
				introotvalc = con.readInt();
				//Scene Calculation
				dbldiscriminant = (Math.pow(introotvalb, 2) - 4*introotvala*introotvalc);
				
				//Condition (CRs) - Advances to Solving the Quadratic (Scene 10b)
				if(dbldiscriminant > 0){
					introots = 2;
					dblscene = 10.2;
				}
				else if(dbldiscriminant == 0){
					introots = 1;
					dblscene = 10.2;
				}
				//Condition (IR) - Game Over, No Roots (Scene 12)
				else if(dbldiscriminant < 0){
					dblscene = 12;
				}
				scene10a(con, dblscene);
			}
			
			//Scene 10(b): Integer Quadratic Challenge (Response)
			while(dblscene == 10.2){
				con.clear();
				scene10b(con, dblscene);
				//Scene Text
				con.println("You entered 3 Integer numbers, they will now be your a, b, and c values in a quadratic equation.");
				con.println("Now, solve for the roots of the equation to unlock the final door (round to 2 decimal places)");
				con.println("For your first input, add the discriminant, for the second, subtract (if applicable)");
				//Condition to allow inputs based on number of roots
				if(introots == 2){
					dblroota = con.readDouble();
					dblrootb = con.readDouble();
					dblrootaans = ((-introotvalb + Math.sqrt(Math.pow(introotvalb, 2) - 4 * introotvala * introotvalc)) / 2 * introotvala);
					dblrootbans = ((-introotvalb - Math.sqrt(Math.pow(introotvalb, 2) - 4 * introotvala * introotvalc)) / 2 * introotvala);
					dblrootaansrnd = Math.round(dblrootaans*100);
					dblrootaansrnd = dblrootaansrnd/100;
					dblrootbansrnd = Math.round(dblrootbans*100);
					dblrootbansrnd = dblrootbansrnd/100;
					//Condition (CR) - Advances and SUCCESSFULLY ESCAPES (Scene 14)
					if(dblroota == dblrootaansrnd && dblrootb == dblrootbansrnd){
						dblscene = 14;
					}
					//Condition (IR) - Game Over, Wrong Roots (Scene 13)
					else if(dblroota != dblrootaansrnd || dblrootb != dblrootbansrnd){
						dblscene = 13;
					}
				}
				else if(introots == 1){
					dblroota = con.readDouble();
					dblrootaans = ((-introotvalb + Math.sqrt(Math.pow(introotvalb, 2) - 4 * introotvala * introotvalc)) / 2 * introotvala);
					dblrootaansrnd = Math.round(dblrootaans*100);
					dblrootaansrnd = dblrootaansrnd/100;
					//Condition (CR) - Advances and SUCCESSFULLY ESCAPES (Scene 14)
					if(dblroota == dblrootaansrnd){
						dblscene = 14;
					}
					//Condition (IR) - Game Over, Wrong Roots (Scene 13)
					else if(dblroota != dblrootaansrnd){
						dblscene = 13;
					}
				}
				scene10b(con, dblscene);
			}
			
			//Scene 11(a): Double Quadratic Challenge (Input)
			while(dblscene == 11.1){
				con.clear();
				scene11a(con, dblscene);
				//Scene Text
				con.println("Enter 3 Double Numbers to proceed!");
				//Scene Input
				dblrootvala = con.readDouble();
				dblrootvalb = con.readDouble();
				dblrootvalc = con.readDouble();
				//Scene Calculation
				dbldiscriminant = (Math.pow(dblrootvalb, 2) - 4*dblrootvala*dblrootvalc);
				
				//Condition (CRs) - Advances to Solving the Quadratic (Scene 11b)
				if(dbldiscriminant > 0){
					introots = 2;
					dblscene = 11.2;
				}
				else if(dbldiscriminant == 0){
					introots = 1;
					dblscene = 11.2;
				}
				//Condition (IR) - Game Over, No Roots (Scene 12)
				else if(dbldiscriminant < 0){
					dblscene = 12;
				}
				scene11a(con, dblscene);
			}
			
			//Scene 11(b): Double Quadratic Challenge (Response)
			while(dblscene == 11.2){
				con.clear();
				scene11b(con, dblscene);
				//Scene Text
				con.println("You entered 3 Double numbers, they will now be your a, b, and c values in a quadratic equation.");
				con.println("Now, solve for the roots of the equation to unlock the final door (round to 2 decimal places)");
				con.println("For your first input, add the discriminant, for the second, subtract (if applicable)");
				//Condition to allow inputs based on number of roots
				if(introots == 2){
					dblroota = con.readDouble();
					dblrootb = con.readDouble();
					dblrootaans = ((-dblrootvalb + Math.sqrt(Math.pow(dblrootvalb, 2) - 4 * dblrootvala * dblrootvalc)) / 2 * dblrootvala);
					dblrootbans = ((-dblrootvalb - Math.sqrt(Math.pow(dblrootvalb, 2) - 4 * dblrootvala * dblrootvalc)) / 2 * dblrootvala);
					dblrootaansrnd = Math.round(dblrootaans*100);
					dblrootaansrnd = dblrootaansrnd/100;
					dblrootbansrnd = Math.round(dblrootbans*100);
					dblrootbansrnd = dblrootbansrnd/100;
					//Condition (CR) - Advances and SUCCESSFULLY ESCAPES (Scene 14)
					if(dblroota == dblrootaansrnd && dblrootb == dblrootbansrnd){
						dblscene = 14;
					}
					//Condition (IR) - Game Over, Wrong Roots (Scene 13)
					else if(dblroota != dblrootaansrnd || dblrootb != dblrootbansrnd){
						dblscene = 13;
					}
				}
				else if(introots == 1){
					dblroota = con.readDouble();
					dblrootaans = ((-dblrootvalb + Math.sqrt(Math.pow(dblrootvalb, 2) - 4 * dblrootvala * dblrootvalc)) / 2 * dblrootvala);
					dblrootaansrnd = Math.round(dblrootaans*100);
					dblrootaansrnd = dblrootaansrnd/100;
					//Condition (CR) - Advances and SUCCESSFULLY ESCAPES (Scene 14)
					if(dblroota == dblrootaansrnd){
						dblscene = 14;
					}
					//Condition (IR) - Game Over, Wrong Roots (Scene 13)
					else if(dblroota != dblrootaansrnd){
						dblscene = 13;
					}
				}
				scene11b(con, dblscene);
			}
			
			//Scene 12: END OF GAME - No Quadratic
			while(dblscene == 12){
				con.clear();
				scene12(con);
				con.println("Game over, you needed to solve for the root of those 3 numbers.");
				con.println("Unfortunately you cannot get the square root of a negative number, you ran out of time. Try again!");
				
				//End Game
				dblscene = -1;
				intgamedone = 1;
			}
			
			//Scene 13: END OF GAME - Wrong Values
			while(dblscene == 13){
				con.clear();
				scene13(con);
				con.println("Game over, you entered the wrong roots and lost. Try again!");
				
				//End Game
				dblscene = - 1;
				intgamedone = 1;
			}
			
			//Scene 14: END OF GAME - Win!
			while(dblscene == 14){
				con.clear();
				scene14(con);
				con.println("CONGRATULATIONS "+struser+"!!! YOU HAVE SUCCESSFULLY ESCAPED!");
				
				//End Game
				dblscene = -1;
				intgamedone = 1;
			}
			
		}
	}
	
	//Scene 1 Graphics (TEXT & DISTINCT PICTURE + ANIMATED)
	public static void scene1(Console con, double dblscene){
		//Scene Images
		BufferedImage imgScene1BG = con.loadImage("Scene1BG.png");
		BufferedImage imgPerson1 = con.loadImage("Person1.png");
		BufferedImage imgPerson2 = con.loadImage("Person2.png");
		BufferedImage imgPerson3 = con.loadImage("Person3.png");
		
		//Scene Variables
		int intpersonxadj = 0;
		
		//Main Scene Drawing (IN)
		con.drawImage(imgScene1BG,0,0);
		con.drawImage(imgPerson1, 500, 270);
		con.drawImage(imgPerson2, 700, 300);
		con.drawImage(imgPerson3, 900, 330);
		con.repaint();
		
		//Main Scene Drawing (OUT)
		if(dblscene == 2){
			for(intpersonxadj = 0; intpersonxadj < 700; intpersonxadj = intpersonxadj + 5){
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene1BG,0,0);
				con.drawImage(imgPerson1, 500 + intpersonxadj, 270);
				con.drawImage(imgPerson2, 700 + intpersonxadj, 300);
				con.drawImage(imgPerson3, 900 + intpersonxadj, 330);
				con.repaint();
				con.sleep(17);
			}
		}
		else if(dblscene == 3){
			for(intpersonxadj = 0; intpersonxadj > -1280; intpersonxadj = intpersonxadj - 5){
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene1BG,0,0);
				con.drawImage(imgPerson1, 500 + intpersonxadj, 270);
				con.drawImage(imgPerson2, 700 + intpersonxadj, 300);
				con.drawImage(imgPerson3, 900 + intpersonxadj, 330);
				con.repaint();
				con.sleep(17);
			}
		}
		
	}
	
	//Scene 2 Graphics (TEXT & DISTINCT PICTURE + ANIMATED)
	public static void scene2(Console con){
		//Scene Images
		BufferedImage imgScene2BG = con.loadImage("Scene2BG.png");
		BufferedImage imgPerson1Flip = con.loadImage("Person1Flip.png");
		BufferedImage imgPerson2Flip = con.loadImage("Person2Flip.png");
		BufferedImage imgPerson3Flip = con.loadImage("Person3Flip.png");
		
		//Scene Variables
		int intpersonxadj = 0;
		
		//Main Scene Drawing (IN AND STAY)
		for(intpersonxadj = -600; intpersonxadj < 0; intpersonxadj = intpersonxadj + 5){
			con.setDrawColor(Color.BLACK);
			con.fillRect(0, 0, 1280, 720);
			con.drawImage(imgScene2BG, 0,0);
			con.drawImage(imgPerson3Flip, 0 + intpersonxadj, 350);
			con.drawImage(imgPerson2Flip, 200 + intpersonxadj, 300);
			con.drawImage(imgPerson1Flip, 400 + intpersonxadj, 330);
			con.repaint();
			con.sleep(17);
		}
	}
	
	//Scene 3 Graphics (TEXT & DISTINCT PICTURE)
	public static void scene3(Console con){
		//Scene Images
		BufferedImage imgScene3BG = con.loadImage("Scene3-4BG.png");
		
		//Main Scene Drawing
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 0, 1280, 720);
		con.drawImage(imgScene3BG, 0, 0);
		con.repaint();
		
	}
	
	//Scene 4 Graphics (TEXT & DISTINCT PICTURE + ANIMATED)
	public static void scene4(Console con, double dblscene){
		//Scene Images
		BufferedImage imgScene4BG = con.loadImage("Scene3-4BG.png");
		BufferedImage imgPuzzle1 = con.loadImage("Puzzle1.png");
		BufferedImage imgPuzzle2 = con.loadImage("Puzzle2.png");
		BufferedImage imgPuzzle3 = con.loadImage("Puzzle3.png");
		BufferedImage imgPuzzle4 = con.loadImage("Puzzle4.png");
		BufferedImage imgPuzzle5 = con.loadImage("Puzzle5.png");
		BufferedImage imgCorrect = con.loadImage("Correct.png");
		BufferedImage imgWrong = con.loadImage("Wrong.png");
		
		//Scene Variables
		int intcount;
		int intimg2posx = 365;
		int intimg2posy = 375;
		int intimg4posx = 665;
		int intimg5posx = 515;
		int intimg5posy = 100;
		int intcororwroposx = 1280;
		
		//Main Scene Drawing (IN)
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 0, 1280, 720);
		con.drawImage(imgScene4BG, 0, 0);
		con.drawImage(imgPuzzle1, 215, 100);
		con.drawImage(imgPuzzle5, 515, 100);
		con.drawImage(imgPuzzle3, 815, 100);
		con.drawImage(imgPuzzle2, 365, 375);
		con.drawImage(imgPuzzle4, 665, 375);
		con.repaint();
		
		//Main Scene Drawing (OUT)
		if(dblscene == 7){
			for(intcount = 0; intcount < 100; intcount++){
				if(intimg2posx != 515){
					intimg2posx = intimg2posx + 5;
				}
				if(intimg2posy != 100){
					intimg2posy = intimg2posy - 5;
				}
				if(intimg4posx != 365){
					intimg4posx = intimg4posx - 5;
				}
				if(intimg5posx != 665){
					intimg5posx = intimg5posx + 5;
				}
				if(intimg5posy != 375){
					intimg5posy = intimg5posy + 5;
				}
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene4BG, 0, 0);
				con.drawImage(imgPuzzle1, 215, 100);
				con.drawImage(imgPuzzle2, intimg2posx, intimg2posy);
				con.drawImage(imgPuzzle3, 815, 100);
				con.drawImage(imgPuzzle4, intimg4posx, 375);
				con.drawImage(imgPuzzle5, intimg5posx, intimg5posy);
				con.repaint();
				con.sleep(17);
			}
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene4BG, 0, 0);
				con.drawImage(imgPuzzle1, 215, 100);
				con.drawImage(imgPuzzle2, intimg2posx, intimg2posy);
				con.drawImage(imgPuzzle3, 815, 100);
				con.drawImage(imgPuzzle4, intimg4posx, 375);
				con.drawImage(imgPuzzle5, intimg5posx, intimg5posy);
				con.drawImage(imgCorrect, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
		if(dblscene == 5){
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene4BG, 0, 0);
				con.drawImage(imgPuzzle1, 215, 100);
				con.drawImage(imgPuzzle5, 515, 100);
				con.drawImage(imgPuzzle3, 815, 100);
				con.drawImage(imgPuzzle2, 365, 375);
				con.drawImage(imgPuzzle4, 665, 375);
				con.drawImage(imgWrong, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
	}
	
	//Scene 5 Graphics (TEXT & DISTINCT PICTURE + DUPLICATED ANIMATION)
	public static void scene5(Console con, double dblscene){
		//Scene Images
		BufferedImage imgScene5BG = con.loadImage("Scene5BG.png");
		BufferedImage imgCorrect = con.loadImage("Correct.png");
		BufferedImage imgWrong = con.loadImage("Wrong.png");
		
		//Scene Variables
		int intcount;
		int intcororwroposx = 1280;
		
		//Main Scene Drawing (IN)
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 0, 1280, 720);
		con.drawImage(imgScene5BG, 0, 0);
		con.repaint();
		
		//Main Scene Drawing (OUT)
		if(dblscene == 8.2){
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene5BG, 0, 0);
				con.drawImage(imgCorrect, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
		if(dblscene == 6){
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene5BG, 0, 0);
				con.drawImage(imgWrong, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
	}
	
	//Scene 6 Graphics (TEXT & DISTINCT PICTURE + ANIMATED)
	public static void scene6(Console con){
		//Scene Images
		BufferedImage imgScene6BG = con.loadImage("Scene6and12BG.png");
		
		//Scene Variables
		int intcount;
		int intsceneadjx = 0;
		int intscenevelox = 5;
		
		//Main Scene Drawing (IN AND STAY)
		for(intcount = 0; intcount < 250; intcount++){
			if(intsceneadjx == 0){
				intscenevelox = -5;
			}
			else if(intsceneadjx == -50){
				intscenevelox = 5;
			}
			intsceneadjx = intsceneadjx + intscenevelox;
			con.setDrawColor(Color.BLACK);
			con.fillRect(0, 0, 1280, 720);
			con.drawImage(imgScene6BG, -25 + intsceneadjx, 0);
			con.repaint();
			con.sleep(17);
		}
	}
	
	//Scene 7 Graphics (TEXT & DISTINCT PICTURE + DUPLICATED ANIMATION)
	public static void scene7(Console con, double dblscene){
		//Scene Images
		BufferedImage imgScene7BG = con.loadImage("Scene7BG.png");
		BufferedImage imgCorrect = con.loadImage("Correct.png");
		BufferedImage imgWrong = con.loadImage("Wrong.png");
		
		//Scene Variables
		int intcount;
		int intcororwroposx = 1280;
		
		//Main Scene Drawing (IN)
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 0, 1280, 720);
		con.drawImage(imgScene7BG, 0, 0);
		con.repaint();
		
		//Main Scene Drawing (OUT)
		if(dblscene == 8.1){
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene7BG, 0, 0);
				con.drawImage(imgCorrect, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
		if(dblscene == 8.2){
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene7BG, 0, 0);
				con.drawImage(imgWrong, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
	}
	
	//Scene 8 Graphics (TEXT & DISTINCT PICTURE + DUPLICATED ANIMATION) [8b is duplicate of 8a, but allows the CORRECT AND WRONG indicators to work]
	public static void scene8a(Console con, double dblscene){
		//Scene Images
		BufferedImage imgScene8BG = con.loadImage("Scene8BG.png");
		BufferedImage imgCorrect = con.loadImage("Correct.png");
		BufferedImage imgWrong = con.loadImage("Wrong.png");
		
		//Scene Variables
		int intcount;
		int intcororwroposx = 1280;
		
		//Main Scene Drawing (IN)
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 0, 1280, 720);
		con.drawImage(imgScene8BG, 0, 0);
		con.repaint();
		
		//Main Scene Drawing (OUT)
		if(dblscene == 10.1){
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene8BG, 0, 0);
				con.drawImage(imgCorrect, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
		if(dblscene == 11.1){
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene8BG, 0, 0);
				con.drawImage(imgWrong, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
	}
	public static void scene8b(Console con, double dblscene){
		//Scene Images
		BufferedImage imgScene8BG = con.loadImage("Scene8BG.png");
		BufferedImage imgCorrect = con.loadImage("Correct.png");
		BufferedImage imgWrong = con.loadImage("Wrong.png");
		
		//Scene Variables
		int intcount;
		int intcororwroposx = 1280;
		
		//Main Scene Drawing (IN)
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 0, 1280, 720);
		con.drawImage(imgScene8BG, 0, 0);
		con.repaint();
		
		//Main Scene Drawing (OUT)
		if(dblscene == 11.1){
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene8BG, 0, 0);
				con.drawImage(imgCorrect, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
		if(dblscene == 9){
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene8BG, 0, 0);
				con.drawImage(imgWrong, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
	}
	
	//Scene 9 Graphics (TEXT & DISTINCT PICTURE + DUPLICATED ANIMATION)
	public static void scene9(Console con){
		//Scene Images
		BufferedImage imgScene9BG = con.loadImage("Scene9BG.png");
		BufferedImage imgWrongWay = con.loadImage("WrongWay.png");
		
		//Scene Variables
		int intcount;
		int intsceneadjx = 0;
		int intscenevelox = 5;
		
		//Main Scene Drawing (IN AND STAY)
		for(intcount = 0; intcount < 250; intcount++){
			if(intsceneadjx == 25){
				intscenevelox = -5;
			}
			else if(intsceneadjx == -25){
				intscenevelox = 5;
			}
			intsceneadjx = intsceneadjx + intscenevelox;
			con.setDrawColor(Color.BLACK);
			con.fillRect(0, 0, 1280, 720);
			con.drawImage(imgScene9BG, 0, 0);
			con.drawImage(imgWrongWay, 265 + intsceneadjx, 110);
			con.repaint();
			con.sleep(17);
		}
	}
	
	//Scene 10 Graphics (TEXT & DISTINCT PICTURE + DUPLICATED ANIMATION)
	public static void scene10a(Console con, double dblscene){
		//Scene Images
		BufferedImage imgScene10aBG = con.loadImage("Scene10-11aBG.png");
		BufferedImage imgCorrect = con.loadImage("Correct.png");
		BufferedImage imgWrong = con.loadImage("Wrong.png");
		
		//Scene Variables
		int intcount;
		int intcororwroposx = 1280;
		
		//Main Scene Drawing (IN)
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 0, 1280, 720);
		con.drawImage(imgScene10aBG, 0, 0);
		con.repaint();
		
		//Main Scene Drawing (OUT)
		if(dblscene == 12){
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene10aBG, 0, 0);
				con.drawImage(imgWrong, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
	}
	public static void scene10b(Console con, double dblscene){
		//Scene Images
		BufferedImage imgScene10bBG = con.loadImage("Scene10-11band13BG.png");
		BufferedImage imgCorrect = con.loadImage("Correct.png");
		BufferedImage imgWrong = con.loadImage("Wrong.png");
		
		//Scene Variables
		int intcount;
		int intcororwroposx = 1280;
		
		//Main Scene Drawing (IN)
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 0, 1280, 720);
		con.drawImage(imgScene10bBG, 0, 0);
		con.repaint();
		
		//Main Scene Drawing (OUT)
		if(dblscene == 14){
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene10bBG, 0, 0);
				con.drawImage(imgCorrect, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
		if(dblscene == 13){
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene10bBG, 0, 0);
				con.drawImage(imgWrong, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
	}
	
	//Scene 11 Graphics (TEXT & DISTINCT PICTURE + DUPLICATED ANIMATION)
	public static void scene11a(Console con, double dblscene){
		//Scene Images
		BufferedImage imgScene11aBG = con.loadImage("Scene10-11aBG.png");
		BufferedImage imgCorrect = con.loadImage("Correct.png");
		BufferedImage imgWrong = con.loadImage("Wrong.png");
		
		//Scene Variables
		int intcount;
		int intcororwroposx = 1280;
		
		//Main Scene Drawing (IN)
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 0, 1280, 720);
		con.drawImage(imgScene11aBG, 0, 0);
		con.repaint();
		
		//Main Scene Drawing (OUT)
		if(dblscene == 12){
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene11aBG, 0, 0);
				con.drawImage(imgWrong, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
	}
	public static void scene11b(Console con, double dblscene){
		//Scene Images
		BufferedImage imgScene11bBG = con.loadImage("Scene10-11band13BG.png");
		BufferedImage imgCorrect = con.loadImage("Correct.png");
		BufferedImage imgWrong = con.loadImage("Wrong.png");
		
		//Scene Variables
		int intcount;
		int intcororwroposx = 1280;
		
		//Main Scene Drawing (IN)
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 0, 1280, 720);
		con.drawImage(imgScene11bBG, 0, 0);
		con.repaint();
		
		//Main Scene Drawing (OUT)
		if(dblscene == 14){
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene11bBG, 0, 0);
				con.drawImage(imgCorrect, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
		if(dblscene == 13){
			for(intcount = 0; intcount <= 173; intcount++){
				intcororwroposx = intcororwroposx - 5;
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720);
				con.drawImage(imgScene11bBG, 0, 0);
				con.drawImage(imgWrong, intcororwroposx, 135);
				con.repaint();
				con.sleep(17);
			}
			con.sleep(5000);
		}
	}
	
	//Scene 12 Graphics (TEXT & PICTURE + DUPLICATED ANIMATION)
	public static void scene12(Console con){
		//Scene Images
		BufferedImage imgScene12BG = con.loadImage("Scene6and12BG.png");
		
		//Scene Variables
		int intcount;
		int intsceneadjx = 0;
		int intscenevelox = 5;
		
		//Main Scene Drawing (IN AND STAY)
		for(intcount = 0; intcount < 250; intcount++){
			if(intsceneadjx == 0){
				intscenevelox = -5;
			}
			else if(intsceneadjx == -50){
				intscenevelox = 5;
			}
			intsceneadjx = intsceneadjx + intscenevelox;
			con.setDrawColor(Color.BLACK);
			con.fillRect(0, 0, 1280, 720);
			con.drawImage(imgScene12BG, -25 + intsceneadjx, 0);
			con.repaint();
			con.sleep(17);
		}
	}
	
	//Scene 13 Graphics (TEXT & DISTINCT PICTURE + ANIMATION)
	public static void scene13(Console con){
		//Scene Images
		BufferedImage imgScene13BG = con.loadImage("Scene10-11band13BG.png");
		BufferedImage imgLock = con.loadImage("Lock.png");
		
		//Scene Variables
		int intcount;
		int intsceneadjy = 560;
		
		//Main Scene Drawing (IN AND STAY)
		for(intcount = 0; intcount < 112; intcount++){
			intsceneadjy = intsceneadjy - 5;
			con.setDrawColor(Color.BLACK);
			con.fillRect(0, 0, 1280, 720);
			con.drawImage(imgScene13BG, 0, 0);
			con.drawImage(imgLock, 440, 160 + intsceneadjy);
			con.repaint();
			con.sleep(17);
		}
	}
	
	//Scene 14 Graphics (TEXT & DISTINCT PICTURE)
	public static void scene14(Console con){
		//Scene Images
		BufferedImage imgScene14BG = con.loadImage("Scene14BG.png");
		BufferedImage imgLock = con.loadImage("Lock.png");
		
		//Main Scene Drawing (IN AND STAY)
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 0, 1280, 720);
		con.drawImage(imgScene14BG, 0, 0);
		con.repaint();
	}
	
}
