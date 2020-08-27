
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
	protected LocalDateTime dateTime;
	protected String time;
	protected String date;
	protected boolean ifLanding=false;
	protected int numOfFligh;
	protected String companyName;
	protected String takeOffFrom;
	protected String landingTo;

    public Flights() {
		
		this("NoName","","","none","none");
	}
	public Flights(String name, String takeOffFrom, String destination, String time, String date) {
		this.companyName=name;
		this.time=time;
		this.landingTo=destination;
		this.takeOffFrom=takeOffFrom;
		this.date=date;
	}
//	public Flights(String companyName, int hour,int min, String takeOffFrom,String landingTo, int day, int month,int year) {
//        setTime(year, month, day, hour, min);
//		this.companyName=companyName;
//		this.takeOffFrom= takeOffFrom;
//		this.landingTo=landingTo;
//		
//	}
//	
//	public Flights(String companyName, String landingTo,String takeOffFrom, LocalDateTime dateTime) {
//		this.companyName=companyName;
//		this.takeOffFrom=takeOffFrom;
//		this.landingTo=landingTo;
//		this.dateTime=dateTime;
//	}   

	private void setTime(int year, int month, int day, int hour, int min) {
		boolean isOk=true;
		try {
			this.dateTime = LocalDateTime.of(year, month, day, hour, min); 
		}catch(Exception e){
			isOk=false;
			System.out.println("Exception has been thrown : "+e.getMessage());
		}
		
	}
    public void save (PrintWriter print) throws FileNotFoundException {
    	print.write(companyName+"\n");
    	print.write(takeOffFrom+"\n");
    	print.write(landingTo+"\n");
    	print.write(time+"\n");
    	print.write(date + "\n");

    }

    public boolean compareParameters(String company, String takesOffFrom, String destination, String time, String date) {
    	boolean isSameFlight=true;
    	if(!company.isEmpty()) {
    		if(!companyName.equalsIgnoreCase(company)) {
    			return false;
    		}
    	}
    	if(!takesOffFrom.isEmpty()) {
    		if(!this.takeOffFrom.equalsIgnoreCase(takesOffFrom)) {
    			return false;
    		}
    	}
    	if(!destination.isEmpty()) {
    		if(!destination.equalsIgnoreCase(landingTo)) {
    			return false;
    		}
    	}
    	if(!time.isEmpty()) {
    		if(!this.time.equalsIgnoreCase(time)) {
    			return false;
    		}
    	}
    	if(!date.isEmpty()) {
    		if(!this.date.equalsIgnoreCase(date)) {
    			return false;
    		}
    	}
    	return true;
    }
	@Override
	public String toString() {
		return "company: " + companyName +" destination: "+ landingTo + " time: "+ time + " date: "+ date;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public boolean isIfLanding() {
		return ifLanding;
	}
	public int getNumOfFligh() {
		return numOfFligh;
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
}
