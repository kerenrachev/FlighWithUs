package natabag2020;

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
	public static List<Flights> flightsThatHaveBeenFound = new ArrayList<>();

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
		File fileToDisplay = new File("landingsDisplayHtml.txt");
		PrintWriter print1 = new PrintWriter(fileToDisplay);
		print1.write(
				"<h3><center>Landing flights table:</center></h3>\r\n" + "\r\n" + "<h4><table style=\"width:100%\">");
		print1.write("<tr>\r\n" + "    <th>Company name</th>\r" + "    <th>Taking Off from</th> \r"
				+ "    <th>Destination</th>\r" + "    <th>Time</th>\r" + "    <th>Date</th>\r" + "  </tr>");
		for (int i = 0; i < landingFlights.size(); i++) {
			print1.write("<tr>");
			landingFlights.get(i).saveHTML(print1);
			print1.write("</tr>");
		}
		print1.write("</table></h4>");
		print1.close();

		File file = new File("Landings.txt");
		PrintWriter print = new PrintWriter(file);
		for (int i = 0; i < landingFlights.size(); i++) {
			landingFlights.get(i).save(print);
		}
		print.close();

	}

	private static void putFlightsInTextFile() throws FileNotFoundException {
		File file = new File("FlightsThatHaveBeenFound.txt");
		PrintWriter print = new PrintWriter(file);
		print.write("<h3><center>Flights that have been found </center></h3>\r\n" + "\r\n"
				+ "<h4><table style=\"width:100%\">");
		print.write("<tr>\r\n" + "    <th>Company name</th>\r" + "    <th>Taking Off from</th> \r"
				+ "    <th>Destination</th>\r" + "    <th>Time</th>\r" + "    <th>Date</th>\r" + "  </tr>");
		for (int i = 0; i < flightsThatHaveBeenFound.size(); i++) {
			print.write("<tr>");
			flightsThatHaveBeenFound.get(i).saveHTML(print);
			print.write("</tr>");
		}
		print.close();

	}

	public static void saveAlltakeOff() throws FileNotFoundException {
		File fileToDisplay = new File("takeOffDisplayHtml.txt");
		PrintWriter print1 = new PrintWriter(fileToDisplay);
		print1.write("<h3><center>Taking Off flights table:</center></h3>\r\n" + "\r\n"
				+ "<h4><table style=\"width:100%\">");
		print1.write("<tr>\r\n" + "    <th>Company name</th>\r" + "    <th>Taking Off from</th> \r"
				+ "    <th>Destination</th>\r" + "    <th>Time</th>\r" + "    <th>Date</th>\r" + "  </tr>");
		for (int i = 0; i < takingOfFlights.size(); i++) {
			print1.write("<tr>");
			takingOfFlights.get(i).saveHTML(print1);
			print1.write("</tr>");
		}
		print1.write("</table></h4>");
		print1.close();

		File file = new File("takeOff.txt");
		PrintWriter print2 = new PrintWriter(file);
		for (int i = 0; i < takingOfFlights.size(); i++) {
			takingOfFlights.get(i).save(print2);
		}
		print2.close();
	}

	static void updateFlightsFromFile() throws FileNotFoundException {
		File file = new File("takeOff.txt");
		Scanner s = new Scanner(file);
		while (s.hasNext()) {
			String company = s.nextLine();
			String from = s.nextLine();
			String to = s.nextLine();
			String time = s.nextLine();
			String date = s.nextLine();
			numOfTakeOffFlights++;
			TakingOffFlights takeOff = new TakingOffFlights(company, from, to, time, date);
			takingOfFlights.add(takeOff);

		}
			sortTakingOfFlights();

		File file1 = new File("Landings.txt");
		s = new Scanner(file1);
		while (s.hasNext()) {
			String company = s.nextLine();
			String from = s.nextLine();
			String to = s.nextLine();
			String time = s.nextLine();
			String date = s.nextLine();
			numOflandingFlights++;
			LandingFlights landings = new LandingFlights(company, from, to, time, date);
			landingFlights.add(landings);
			
		}
		sortLandingFlights();
	}

	public static void sortTakingOfFlights() {
		for (int i = 1; i < takingOfFlights.size(); i++ ){
			for (int j = i; j> 0 && takingOfFlights.get(j).isItLater(takingOfFlights.get(j-1)); j--) {
				TakingOffFlights temp =  takingOfFlights.get(j);
				takingOfFlights.set(j, takingOfFlights.get(j-1));
				takingOfFlights.set(j-1, temp);
			}
		}
	}
	
	public static void sortLandingFlights() {
		for (int i = 1; i < landingFlights.size(); i++ ){
			for (int j = i; j> 0 && landingFlights.get(j).isItLater(landingFlights.get(j-1)); j--) {
				LandingFlights temp =  landingFlights.get(j);
				landingFlights.set(j, landingFlights.get(j-1));
				landingFlights.set(j-1, temp);
			}
		}
	}
	
	public static void findFlights(String company, String takesOffFrom, String destination, String time, String date)
			throws FileNotFoundException {
		for (int i = 0; i < landingFlights.size(); i++) {
			if (landingFlights.get(i).compareParameters(company, takesOffFrom, destination, time, date)) {
				flightsThatHaveBeenFound.add(landingFlights.get(i));
			}
		}
		for (int i = 0; i < takingOfFlights.size(); i++) {
			if (takingOfFlights.get(i).compareParameters(company, takesOffFrom, destination, time, date)) {
				flightsThatHaveBeenFound.add(takingOfFlights.get(i));
			}
		}
		putFlightsInTextFile();

	}

}
