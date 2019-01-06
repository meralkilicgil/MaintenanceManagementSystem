import java.io.Serializable;
import java.util.*;

public class CorrectiveMaintenanceSchedule {
	private int maintenanceID;
	private int equipmentID;
	private int equipmentSerialNumber;
	private String description;
	private String startDate;
	private String endDate;
	private int priority;
	private int memberID;
	private Vector<CorrectiveMaintenanceSchedule> maintenanceScheduleList;
	
	public int getMaintenanceID() {
		return maintenanceID;
	}

	public void setMaintenanceID(int maintenanceID) {
		this.maintenanceID = maintenanceID;
	}

	public int getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(int equipmentID) {
		this.equipmentID = equipmentID;
	}

	public int getEquipmentSerialNumber() {
		return equipmentSerialNumber;
	}

	public void setEquipmentSerialNumber(int equipmentSerialNumber) {
		this.equipmentSerialNumber = equipmentSerialNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public Vector<CorrectiveMaintenanceSchedule> getMaintenanceScheduleList() {
		return maintenanceScheduleList;
	}

	public void setMaintenanceScheduleList(Vector<CorrectiveMaintenanceSchedule> maintenanceScheduleList) {
		this.maintenanceScheduleList = maintenanceScheduleList;
	}
	
	public CorrectiveMaintenanceSchedule() {}
	public CorrectiveMaintenanceSchedule(int id, int eqpId, int sNum, String desc, String sDate, String eDate, int priority) {
		this.maintenanceID = id;
		this.equipmentID = eqpId;
		this.equipmentSerialNumber = sNum;
		this.description = desc;
		this.startDate = sDate;
		this.endDate = eDate;
		this.priority = priority;
	}
	
	public CorrectiveMaintenanceSchedule updateSchedule(int id, int eqpId, int sNum, String desc, String sDate, String eDate, int priority, int memberId) {
		CorrectiveMaintenanceSchedule updatedSchedule = selectSchedule(id);
		updatedSchedule.setDescription(desc);
		updatedSchedule.setEndDate(eDate);
		updatedSchedule.setEquipmentID(eqpId);
		updatedSchedule.setEquipmentSerialNumber(sNum);
		updatedSchedule.setMemberID(memberId);
		updatedSchedule.setPriority(priority);
		updatedSchedule.setStartDate(sDate);
		return updatedSchedule;
	}
	
	public void removeSchedule() {
		maintenanceScheduleList.remove(this);
	}
	
	public void assignMember(int teamMemberId) {
		this.setMemberID(teamMemberId);
	}
	
	protected CorrectiveMaintenanceSchedule selectSchedule(int id) {
		for(int i=0; i<this.maintenanceScheduleList.size(); i++) {
			if(id == this.maintenanceScheduleList.get(i).getMaintenanceID())
				return this.maintenanceScheduleList.get(i);
		}
		return null;
	}
} 