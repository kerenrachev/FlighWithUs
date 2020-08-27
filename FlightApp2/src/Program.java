
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Program {
	public static ArrayList<Integer> parametersToSearchBy;
	
	public static void main(String[] args) throws FileNotFoundException {
		ManagingClass.updateFlightsFromFile();
        
        if(args.length>0&&args[0].equals("4")) {
        	CreateLandingFlight(args[1],args[2],args[3],args[4]);
        	callFlightCreatedSuccessfuly();
        	
        }
        if(args.length>0&&args[0].equals("5")){
        	CreateTakingOfFlight(args[1],args[2],args[3],args[4]);
        	callFlightCreatedSuccessfuly();
         }		
        if(args.length>0&&args[0].equalsIgnoreCase("10")) {
        	//company,takesOffFrom,destination,time ,date
        	ManagingClass.findFlights(args[1],args[2],args[3],args[4],args[5]);
        	
        	
        }
/*
		int choise;
		Scanner s=new Scanner(System.in);
		
		do {
			do {
				System.out.println("Please enter valid choise (between 0-6 ) ");
				choise = s.nextInt();
			} while (choise < 0 || choise > 6);
			switch (choise) {

			case 1:
				CreateTakingOfFlight();

				break;

			case 2:
				CreateLandingFlight();

				break;

			case 3:
				System.out.println("All the taking of flights are: \n"
						+ ManagingClass.printArrayList("takeOf"));

				break;

			case 4:
				System.out.println("All the landing flights are: \n"
						+ ManagingClass.printArrayList("land"));

				break;

			case 5:
                      saveAllFlights();
                      System.out.println("saved");
				break;
				
			case 6:
				System.out.println("Please save all your flights before searching for one, to save write 'SAVE' ,else,type anything else.");
				s.nextLine();
				String answer=s.nextLine();
				if(answer.equalsIgnoreCase("save")) {
					System.out.println();
					System.out.println("Saved, thank you. Now you can search for a flight in your updates list");
					saveAllFlights();
					System.out.println("Choose your searcing options,\nType the number of the chosen option:\n"
							+ "1)Date and Hour\n"
							+ "2)Destanation\n"
							+ "3)Date, hour and destanation.\n");
					int choice = s.nextInt();
					switch (choice) {
					case 1:
						findFlighByDateAndHour();
						break;

					case 2:
						findFlighByDestanation();
						break;
					case 3:
						findFlighByDateAndHourAndDestanation();
						break;
					}
					
					
				}
				else 
				{
					findFlighByDateAndHour();
				}
				break;
			case 7:
				System.out.println("Bye Bye!!");
			}
			
		} while (choise!=7);   */
		
	}


	private static void callFlightCreatedSuccessfuly() {
		System.out.println("<!DOCTYPE html>\r\n" + 
    			"<html lang=\"en\">\r\n" + 
    			"<head>\r\n" + 
    			"				<meta charset='windows-1255'>\r\n" + 
    			"				<title>Flight With Us</title>\r\n" + 
    			"				</head>\r\n" + 
    			"				<style>\r\n" + 
    			"				h1 {\r\n" + 
    			"				  color: white;\r\n" + 
    			"				  text-align: center;\r\n" + 
    			"				}\r\n" + 
    			"				h2{\r\n" + 
    			"				  text-align: center;\r\n" + 
    			"				  font-size: big;\r\n" + 
    			"				  color: white;\r\n" + 
    			"				}\r\n" + 
    			"				h3 {color: white}\r\n" + 
    			"				body{\r\n" + 
    			"				   background-image: url('https://monroeaerospace.com/blog/wp-content/uploads/2019/08/airplane-landing-lights-874x452.jpg') ;\r\n" + 
    			"				   background-size: cover;\r\n" + 
    			"				}\r\n" + 
    			"				div{\r\n" + 
    			"				   background-color: rgba(5,4,2,0.5);\r\n" + 
    			"				    width:850px;\r\n" + 
    			"					height: 500px;\r\n" + 
    			"					margin-left:auto;\r\n" + 
    			"				    margin-right:auto;\r\n" + 
    			"				    padding: 15px;\r\n" + 
    			"					align-content: center;\r\n" + 
    			"				}\r\n" + 
    			"\r\n" + 
    			"				</style>\r\n" + 
    			"				<body>\r\n" + 
    			"				<h1> Flight app </h1>\r\n" + 
    			"				<div>\r\n" + 
    			"				<p>\r\n" + 
    			"				<button onclick=\"window.location.href='addTakingOffFlight'\" type=\"button\" value=\"CreateTakingOffFlight\" >Create takingoff flight</button>\r\n" + 
    			"				<button onclick=\"window.location.href='addLandingFlight'\" type=\"button\" value=\"CreateLandingFlight\" >Create landing flight</button>\r\n" + 
    			"				<button onclick=\"window.location.href='showTakeOfFlight'\" type=\"button\" value=\"ShowTakeOffFlights\" >Show takingoff flights</button>\r\n" + 
    			"				<button onclick=\"window.location.href='showLandingFlight'\" type=\"button\" value=\"ShowLandingFlights\" >Show landing flights</button>\r\n" + 
    			"                <button onclick=\"window.location.href='findFlight'\" type=\"button\" value=\"findFlight\" >Find flight</button>" + 
    			"\r\n" + 
    			"\r\n" + 
    			"				<h2> File created successfully! </h2>\r\n" + 
    			"				</p>\r\n" + 
    			"				</div>\r\n" + 
    			"\r\n" + 
    			"				</body>\r\n" + 
    			"</html>");

	}



	private static void CreateLandingFlight(String company, String takesOffFrom, String time, String date) throws FileNotFoundException {
		boolean isOk = true;
		do {
			LandingFlights landings = new LandingFlights(company , takesOffFrom , "Israel", time,date);
			isOk = ManagingClass.addToLandingArray(landings);
			saveAllFlights();
		} while (!isOk);	
		
	}
	
	private static void CreateTakingOfFlight(String name, String destination , String time, String date) throws FileNotFoundException {
		boolean isOk=true;
		do {
			TakingOffFlights takingOf = new TakingOffFlights(name, "Israel",destination, time, date);
			isOk=ManagingClass.addToTakingOfArray(takingOf);
			saveAllFlights();
		} while (!isOk);
	
		
	}
	
	public static void saveAllFlights() throws FileNotFoundException {
		ManagingClass.saveAllLandings();
		ManagingClass.saveAlltakeOff();
	}

}