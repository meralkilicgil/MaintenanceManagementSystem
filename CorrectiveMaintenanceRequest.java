import java.io.Serializable;
import java.util.*;

public class CorrectiveMaintenanceRequest {
	private int maintenanceID;
	private int errorCode;
	private String description;
	private String equipmentName;
	private int priority;
	private Vector<CorrectiveMaintenanceRequest> maintenanceRequestList;
	
	public int getMaintenanceID() {
		return maintenanceID;
	}
	public void setMaintenanceID(int maintenanceID) {
		this.maintenanceID = maintenanceID;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Vector<CorrectiveMaintenanceRequest> getMaintenanceRequestList(){
		return this.maintenanceRequestList;
	}
	public void setMaintenanceRequestList(Vector<CorrectiveMaintenanceRequest> list) {
		this.maintenanceRequestList = list;
	}
	
	public CorrectiveMaintenanceRequest(int id, int code, String desc, String eqpName, int priority) {
		this.maintenanceID = id;
		this.errorCode = code;
		this.description = desc;
		this.equipmentName = eqpName;
		this.priority = priority;
	}
	
	public CorrectiveMaintenanceRequest() {
		// TODO Auto-generated constructor stub
	}
	public CorrectiveMaintenanceRequest updateRequest(int id, int code, String desc, String eqpName, int priority) {
		CorrectiveMaintenanceRequest updatedRequest = findRequest(id);
		updatedRequest.setErrorCode(code);
		updatedRequest.setDescription(desc);
		updatedRequest.setEquipmentName(eqpName);
		updatedRequest.setPriority(priority);
		return updatedRequest;
	}
	
	public void removeRequest() {
		maintenanceRequestList.remove(this);
	}
	
	protected CorrectiveMaintenanceRequest findRequest(int id) {
		for(int i=0; i<this.maintenanceRequestList.size(); i++) {
			if(id == this.maintenanceRequestList.get(i).getMaintenanceID())
				return this.maintenanceRequestList.get(i);
		}
		return null;
	}

} 