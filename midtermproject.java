import arc.*;

public class midtermproject{
	public static void main(String[]args){
		Console con = new Console("Escape Room", 1280, 720);
		
		//Scene Configuration (Prevents 10 Sub-if/while/for loops for nested scenes)
		int intscene = 0; //Corresponds with scene count
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
			
			//Game Completed
			intgamedone = 1;
		}
	}
	public static void scene1(Console con){
		
	}
}
