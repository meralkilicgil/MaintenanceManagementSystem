import java.util.*;
import java.io.*;
public class MaintenanceManager {
	private Vector<CorrectiveMaintenanceRequest> maintenanceRequestList = new Vector<CorrectiveMaintenanceRequest>();
	private  Vector<CorrectiveMaintenanceSchedule> maintenanceScheduleList = new Vector<CorrectiveMaintenanceSchedule>();
	public static void main(String[] args) throws Exception{
		MaintenanceManager manager = new MaintenanceManager();
		String opening = "Welcome to Maintenance Management System\nPlease select your choice to continue..."
				+ "\n1.Manage Corrective Maintenance Request\n2.Manage Corrective Maintenance Schedule";
		System.out.println(opening);
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if(choice == 1) {
			manager.manageRequests();
		}
		else if(choice == 2) {
			manager.manageSchedule();
		}
		else {
			System.out.println("Invalid argument\n");
			main(null);
		}
	}
	
	public void manageSchedule() throws Exception {
		CorrectiveMaintenanceSchedule request = new CorrectiveMaintenanceSchedule();
		String intro = "Select your choice:\n1.Define a new schedule\n2.Update an available schedule\n3.Remove a schedule\n4.Assign team member to schedule\n5.Show list of available schedules\n6.Back to main menu";
		System.out.println(intro);
		Scanner scan = new Scanner(System.in);
		int ch = scan.nextInt();
		if(ch == 1) {
			defineSchedule();
		}
		else if(ch == 2) {
			updateSchedule();
		}
		else if(ch == 3) {
			removeSchedule();
		}
		else if(ch == 4) {
			assignTeamMember();
		}
		else if(ch == 5) {
			showSchedule();
		}
		else if(ch == 6) {
			main(null);
		}
		else {
			System.out.println("Invalid argument\n");
			manageSchedule();
		}
	}

	private void assignTeamMember() {
		Scanner scan = new Scanner(System.in);
		CorrectiveMaintenanceSchedule schedule = new CorrectiveMaintenanceSchedule();
		System.out.println("Enter maintenance id: ");
		int mId = scan.nextInt();
		System.out.println("Enter id of assigned team member: ");
		int memId = scan.nextInt();
		Vector<CorrectiveMaintenanceSchedule> slist = getSchedule();
		for(int i=0; i<slist.size(); i++) {
			if(mId == slist.get(i).getMaintenanceID())
				schedule = slist.get(i);
		}
		schedule.assignMember(memId);
	}

	private void showSchedule() throws Exception {
		if(maintenanceScheduleList.size() == 0) {
			System.out.println("Maintenance schedule list is empty");				
		}
		for(int i=0; i<maintenanceScheduleList.size(); i++) {
			System.out.println(maintenanceScheduleList.get(i).getMaintenanceID() + "--" + maintenanceScheduleList.get(i).getDescription() +"\n");
		}
		manageRequests();	
	}
	private Vector<CorrectiveMaintenanceSchedule> getSchedule() {
		if(maintenanceScheduleList.size() == 0) {
			System.out.println("Maintenance schedule list is empty");
			return null;
		}
		return maintenanceScheduleList;
	}
	private void removeSchedule() throws Exception {
		// TODO Auto-generated method stub
		Vector<CorrectiveMaintenanceSchedule> sList = getSchedule();
		CorrectiveMaintenanceSchedule schedule = new CorrectiveMaintenanceSchedule();
		Scanner myscan3 = new Scanner(System.in);
		System.out.println("Enter maintenance id: ");
		int mId = myscan3.nextInt();
		for(int i=0; i<sList.size(); i++) {
			if(mId == sList.get(i).getMaintenanceID())
				schedule = sList.get(i);
			else {
				schedule = null;
				System.out.println("Schedule is not found.");
				manageSchedule();
			}
		}
		schedule.removeSchedule();
		manageSchedule();
	}

	private void updateSchedule() throws Exception {
		// TODO Auto-generated method stub
		Vector<CorrectiveMaintenanceSchedule> sList = getSchedule();
		CorrectiveMaintenanceSchedule updatedSchedule = new CorrectiveMaintenanceSchedule();
		Scanner myscan2 = new Scanner(System.in);
		System.out.println("Enter maintenance id: ");
		int mId = myscan2.nextInt();
		for(int i=0; i<sList.size(); i++) {
			if(mId == sList.get(i).getMaintenanceID())
				updatedSchedule = sList.get(i);
			else {
				updatedSchedule = null;
				System.out.println("Request is not found.");
				manageRequests();
			}
		}
		System.out.println("Please enter equipment id: ");
		int eqpId = myscan2.nextInt();
		System.out.println("Please enter serial number: ");
		int sNum = myscan2.nextInt();
		System.out.println("Please enter description: ");
		String desc = myscan2.next();
		System.out.println("Please enter start date: ");
		String sDate = myscan2.next();
		System.out.println("Please enter end date: ");
		String eDate = myscan2.next();
		System.out.println("Please enter priority: 1-Critical, 2-Major, 3-Minor ");
		int priority = myscan2.nextInt();
		System.out.println("Please enter assigned team member id: ");
		int memId = myscan2.nextInt();
		updatedSchedule.updateSchedule(mId, eqpId, sNum, desc, sDate, eDate, priority, memId);
		manageSchedule();
	}

	private void defineSchedule() throws Exception {
		// TODO Auto-generated method stub
		Scanner myscan = new Scanner(System.in);
		System.out.println("Please enter maintenance id: ");
		int id = myscan.nextInt();
		System.out.println("Please enter equipment id: ");
		int eqpId = myscan.nextInt();
		System.out.println("Please enter serial number: ");
		int sNum = myscan.nextInt();
		System.out.println("Please enter description: ");
		String desc = myscan.next();
		System.out.println("Please enter start date: ");
		String sDate = myscan.next();
		System.out.println("Please enter end date: ");
		String eDate = myscan.next();
		System.out.println("Please enter priority: 1-Critical, 2-Major, 3-Minor ");
		int priority = myscan.nextInt();
		CorrectiveMaintenanceSchedule schedule = new CorrectiveMaintenanceSchedule(id, eqpId, sNum, desc, sDate, eDate, priority);
		maintenanceScheduleList.addElement(schedule);
		manageSchedule();
	}
	
	public void manageRequests() throws Exception {
		CorrectiveMaintenanceRequest request = new CorrectiveMaintenanceRequest();
		String intro = "Select your choice:\n1.Define a new request\n2.Update an available request\n3.Remove a request\n4.Show list of available requests\n5.Back to main menu";
		System.out.println(intro);
		Scanner scan = new Scanner(System.in);
		int ch = scan.nextInt();
		if(ch == 1) {
			defineRequest();
		}
		else if(ch == 2) {
			updateRequest();
		}
		else if(ch == 3) {
			removeRequest();
		}
		else if(ch == 4) {
			showRequests();
		}
		else if(ch == 5) {
			main(null);
		}
		else {
			System.out.println("Invalid argument\n");
			manageRequests();
		}
	}

	private void showRequests() throws Exception {
		if(maintenanceRequestList.size() == 0) {
			System.out.println("Maintenance request list is empty");				
		}
		for(int i=0; i<maintenanceRequestList.size(); i++) {
			System.out.println(maintenanceRequestList.get(i).getMaintenanceID() + "---" + maintenanceRequestList.get(i).getDescription() +"\n");
		}
		manageRequests();	
	}
	private Vector<CorrectiveMaintenanceRequest> getRequests() {
		if(maintenanceRequestList.size() == 0) {
			System.out.println("Maintenance request list is empty");
			return null;
		}
		return maintenanceRequestList;
	}
	private void removeRequest() throws Exception {
		// TODO Auto-generated method stub
		Vector<CorrectiveMaintenanceRequest> rList = getRequests();
		CorrectiveMaintenanceRequest request = new CorrectiveMaintenanceRequest();
		Scanner myscan3 = new Scanner(System.in);
		System.out.println("Enter maintenance id: ");
		int mId = myscan3.nextInt();
		for(int i=0; i<rList.size(); i++) {
			if(mId == rList.get(i).getMaintenanceID())
				request = rList.get(i);
			else {
				request = null;
				System.out.println("Request is not found.");
				manageRequests();
			}
		}
		request.removeRequest();
		manageRequests();
	}

	private void updateRequest() throws Exception {
		// TODO Auto-generated method stub
		Vector<CorrectiveMaintenanceRequest> rList = getRequests();
		CorrectiveMaintenanceRequest updatedRequest = new CorrectiveMaintenanceRequest();
		Scanner myscan2 = new Scanner(System.in);
		System.out.println("Enter maintenance id: ");
		int mId = myscan2.nextInt();
		for(int i=0; i<rList.size(); i++) {
			if(mId == rList.get(i).getMaintenanceID())
				updatedRequest = rList.get(i);
			else {
				updatedRequest = null;
				System.out.println("Request is not found.");
				manageRequests();
			}
		}
		System.out.println("Please enter error code: ");
		int errCode = myscan2.nextInt();
		System.out.println("Please enter description: ");
		String desc = myscan2.next();
		System.out.println("Please enter equipment name: ");
		String eqpName = myscan2.next();
		System.out.println("Please enter priority: 1-Critical, 2-Major, 3-Minor ");
		int priority = myscan2.nextInt();
		updatedRequest.updateRequest(mId, errCode, desc, eqpName, priority);
		manageRequests();
	}

	private void defineRequest() throws Exception {
		// TODO Auto-generated method stub
		Scanner myscan = new Scanner(System.in);
		System.out.println("Please enter maintenance id: ");
		int id = myscan.nextInt();
		System.out.println("Please enter error code: ");
		int errCode = myscan.nextInt();
		System.out.println("Please enter description: ");
		String desc = myscan.next();
		System.out.println("Please enter equipment name: ");
		String eqpName = myscan.next();
		System.out.println("Please enter priority: 1-Critical, 2-Major, 3-Minor ");
		int priority = myscan.nextInt();
		CorrectiveMaintenanceRequest request = new CorrectiveMaintenanceRequest(id, errCode, desc, eqpName, priority);
		maintenanceRequestList.addElement(request);
		manageRequests();
	}
}
