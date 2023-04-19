import arc.*;

public class midtermproject{
	public static void main(String[]args){
		Console con = new Console("Escape Room", 1280, 720);
		
		//Scene Configuration (Prevents 10 Sub-if/while/for loops for nested scenes)
		int intscene = 0; //Corresponds with scene count, "-1" to end story
		int intgamedone = 0; //0 = Not Completed, 1 = Completed, stops loop
		
		//Main Scenes Loop
		while(intgamedone < 1){
			
			//Initializing Adventure (Not a Scene - Scene 0)
			while(intscene == 0){
				String struser;
				int intcount;
				
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
				intscene = 1;
			}
			
			//Scene 1: Welcome Screen
			while(intscene == 1){
				scene1(con);
				char chrstart;
				chrstart = con.getChar();
				if(chrstart != 's'){
					con.println("TEMP - Scene 2");
					intscene = 2;
				}
				else if(chrstart == 's'){
					con.println("TEMP - Scene 3");
					intscene = 3;
				}
			}
			
			//Scene 2: END OF GAME - Went home
			while(intscene == 2){
				scene2(con);
				intscene = -1;
				intgamedone = 1;
			}
			
			//Scene 3: Escape Room Start Screen
			while(intscene == 3){
				scene3(con);
				
				int intmouseclicked = 0;
				while(intmouseclicked == 0){
					intmouseclicked = con.currentMouseButton();
				}
				//COMPLETE - Advancing to next scene
				intscene = 4;
			}
			
			//Scene 4: Puzzle Organizing Challenge
			while(intscene == 4){
				scene4(con);
				
				double dblpuzzleinput;
				double dblpuzzle1 = 0; //ZERO used as a placeholder to code will run
				double dblpuzzle2 = 0;
				double dblpuzzle3 = 0;
				double dblpuzzle4 = 0;
				double dblpuzzle5 = 0;
				int intcount;
				
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
				if(dblpuzzle1 == 5.4 && dblpuzzle2 == 4.2 && dblpuzzle3 == 3.3 && dblpuzzle4 == 2.5 && dblpuzzle5 == 1.1){
					con.println("Correct - Scene 7");
					intscene = 7;
				}
				else{
					con.println("Incorrect - Scene 5");
					intscene = 5;
				}
			}
			
			//TESTING Section
			while(intscene == 999){	
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
