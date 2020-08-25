
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagingClass {

	public static List<LandingFlights> landingFlights = new ArrayList<>();
	public static int numOflandingFlights = 0;
	public static int numOfTakeOffFlights = 0;
	public static List<TakingOffFlights> takingOfFlights = new ArrayList<>();

	

	public void setCurrenTakinfOff(int num) {
		this.numOfTakeOffFlights = num;
	}

	public void setCurrentLanding(int num) {
		this.numOflandingFlights = num;
	}

	public static boolean addToTakingOfArray(TakingOffFlights takingOf) {
		boolean isOk = true;
		try {
			   takingOfFlights.add(takingOf);
			   numOfTakeOffFlights++;
			return isOk = true;
		} catch (Exception e) {
			return isOk = false;
		}
	}

	public static boolean addToLandingArray(LandingFlights landingFlight) { 
		boolean isOk = true;
		try {
			   landingFlights.add(landingFlight);
			   numOflandingFlights++;
			return isOk = true;
		} catch (Exception e) {
			return isOk = false;
		}
	}

	public static String printArrayList(String string) {
		String str = "";
		if (string.equalsIgnoreCase("takeOf")) {
			for (int i = 0; i < takingOfFlights.size(); i++) {
				str += takingOfFlights.get(i).toString() + "\n";
			}
		} else {
			for (int i = 0; i < landingFlights.size(); i++) {
				str += landingFlights.get(i).toString() + "\n";
			}
		}
		return str;
	}

	public static void saveAllLandings() throws FileNotFoundException {
//		updateFlightsFromFile();
		File file = new File("Landings.txt");
		PrintWriter print = new PrintWriter(file);
		for (int i = 0; i < landingFlights.size(); i++) {
			landingFlights.get(i).save(print);
		}
		print.close();

	}

	public static void saveAlltakeOff() throws FileNotFoundException {
//		updateFlightsFromFile();
		File file = new File("takeOff.txt");
		PrintWriter print = new PrintWriter(file);
		for (int i = 0; i < takingOfFlights.size(); i++) {
			takingOfFlights.get(i).save(print);
		}
		print.close();
	}

	// 1=landing,2=takeoff,3=both
	public static boolean findFlight(LocalDateTime searchDate, int typeOfFlight) throws FileNotFoundException {
		updateFlightsFromFile();
		boolean hasFoundFlights = false;
		if (typeOfFlight == 1 || typeOfFlight == 3) {
			for (int i = 0; i < landingFlights.size(); i++) {
				if (landingFlights.get(i).dateTime.compareTo(searchDate) == 0) {
					hasFoundFlights = true;
					System.out.println(landingFlights.get(i));
				}
			}
		}
		if (typeOfFlight == 2 || typeOfFlight == 3) {
			for (int i = 0; i < takingOfFlights.size(); i++) {
				if (takingOfFlights.get(i).dateTime.compareTo(searchDate) == 0) {
					hasFoundFlights = true;
					System.out.println(takingOfFlights.get(i));
				}
			}
		}

		return hasFoundFlights;
	}
	public static boolean findFlight(String destanation, int typeOfFlight) throws FileNotFoundException {
		updateFlightsFromFile();
		boolean hasFoundFlights = false;
		if (typeOfFlight == 1 || typeOfFlight == 3) {
			for (int i = 0; i < landingFlights.size(); i++) {
				if (landingFlights.get(i).takeOffFrom.equalsIgnoreCase(destanation)) {
					hasFoundFlights = true;
					System.out.println(landingFlights.get(i));
				}
			}
		}
		if (typeOfFlight == 2 || typeOfFlight == 3) {
			for (int i = 0; i < takingOfFlights.size(); i++) {
				if (takingOfFlights.get(i).landingTo.equalsIgnoreCase(destanation)) {
					hasFoundFlights = true;
					System.out.println(takingOfFlights.get(i));
				}
			}
		}
		return hasFoundFlights;
	}

	public static boolean findFlight(LocalDateTime localDate, String destanation, int typeOfFlight)
			throws FileNotFoundException {
		updateFlightsFromFile();
		boolean hasFoundFlights = false;
		if (typeOfFlight == 1 || typeOfFlight == 3) {
			for (int i = 0; i < landingFlights.size(); i++) {
				if ((landingFlights.get(i).takeOffFrom.equalsIgnoreCase(destanation))
						&& (landingFlights.get(i).getDateTime().compareTo(localDate)) == 0) {
					hasFoundFlights = true;
					System.out.println(landingFlights.get(i));
				}
			}
		}
		if (typeOfFlight == 2 || typeOfFlight == 3) {
			for (int i = 0; i < takingOfFlights.size(); i++) {
				if ((takingOfFlights.get(i).landingTo.equalsIgnoreCase(destanation))
						&& (takingOfFlights.get(i).getDateTime().compareTo(localDate)) == 0) {
					hasFoundFlights = true;
					System.out.println(takingOfFlights.get(i));
				}
			}
		}
		

		return hasFoundFlights;
	}

	static void updateFlightsFromFile() throws FileNotFoundException {
		File file = new File("takeOff.txt");
		Scanner s = new Scanner(file);
		while (s.hasNext()) {
			String compony = s.nextLine();
			String from = s.nextLine();
			String to = s.nextLine();
			String time = s.nextLine();
			String date= s.nextLine();
			numOfTakeOffFlights++;
			TakingOffFlights takeOff = new TakingOffFlights(compony,from, to, time,date);
			takingOfFlights.add(takeOff);
		}
		
		File file1 = new File("Landings.txt");
		s = new Scanner(file1);
		while (s.hasNext()) {
			String compony = s.nextLine();
			String from = s.nextLine();
			String to = s.nextLine();
			String time = s.nextLine();
			String date= s.nextLine();
			numOflandingFlights++;
			LandingFlights landings = new LandingFlights(compony,from, to, time,date);
			landingFlights.add(landings);
		}
	}

}
