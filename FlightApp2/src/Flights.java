
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Flights {
//test
	protected String time;
	protected String date;
	protected boolean ifLanding = false;
	protected String companyName;
	protected String takeOffFrom;
	protected String landingTo;

	public Flights() {

		this("NoName", "", "", "none", "none");
	}

	public Flights(String name, String takeOffFrom, String destination, String time, String date) {
		this.companyName = name;
		this.time = time;
		this.landingTo = destination;
		this.takeOffFrom = takeOffFrom;
		this.date = date;
	}

	public void save(PrintWriter print) throws FileNotFoundException {
		print.write(companyName + "\n");
		print.write(takeOffFrom + "\n");
		print.write(landingTo + "\n");
		print.write(time + "\n");
		print.write(date + "\n");

	}

	public void saveHTML(PrintWriter print) {
		print.write("<td>" + companyName + "</td>");
		print.write("<td>" + takeOffFrom + "</td>");
		print.write("<td>" + landingTo + "</td>");
		print.write("<td>" + time + "</td>");
		print.write("<td>" + date + "</td>");

	}

	public boolean compareParameters(String company, String takesOffFrom, String destination, String time,
			String date) {
		boolean isSameFlight = true;
		if (!company.isEmpty()) {
			if (!companyName.equalsIgnoreCase(company)) {
				return false;
			}
		}
		if (!takesOffFrom.isEmpty()) {
			if (!this.takeOffFrom.equalsIgnoreCase(takesOffFrom)) {
				return false;
			}
		}
		if (!destination.isEmpty()) {
			if (!destination.equalsIgnoreCase(landingTo)) {
				return false;
			}
		}
		if (!time.isEmpty()) {
			if (!this.time.equalsIgnoreCase(time)) {
				return false;
			}
		}
		if (!date.isEmpty()) {
			if (!this.date.equalsIgnoreCase(date)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "company: " + companyName + " destination: " + landingTo + " time: " + time + " date: " + date;
	}

	public boolean isIfLanding() {
		return ifLanding;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getTakeOff() {
		return takeOffFrom;
	}

	public String getLanding() {
		return landingTo;
	}

	public Boolean isItLater(Flights flightToCompare) {
		String[] dataFlight1 = this.date.split("-");
		String[] dataFlight2 = flightToCompare.date.split("-");
		int parameter1, parameter2;
		for (int i = 0; i < dataFlight2.length; i++) {
			parameter1 = Integer.parseInt(dataFlight1[i]);
			parameter2 = Integer.parseInt(dataFlight2[i]);
			if (parameter1 < parameter2) {
				return true;
			} else if (parameter1 > parameter2) {
				return false;
			}
		}
		dataFlight1 = this.time.split(":");
		dataFlight2 = flightToCompare.time.split(":");
		for (int i = 0; i < dataFlight2.length; i++) {
			parameter1 = Integer.parseInt(dataFlight1[i]);
			parameter2 = Integer.parseInt(dataFlight2[i]);
			if (parameter1 < parameter2) {
				return true;
			} else if (parameter1 > parameter2) {
				return false;
			}
		}
		return false;
	}
}
