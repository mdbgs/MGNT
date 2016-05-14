package ModelPackage;

public class Reunion {
	   private int iDMeeting ;         
	   private int iDResponsable  ;     
	   private String type    ;            
	   private String  startDate;          
	   private String endDate; 
	   private String object;              
	   private int numberParticipant  ;  
	   private String  placeMeeting    ;           
	   private String report     ;    
	   private String voucher	;
	public int getiDMeeting() {
		return iDMeeting;
	}
	public void setiDMeeting(int iDMeeting) {
		this.iDMeeting = iDMeeting;
	}
	public int getiDResponsable() {
		return iDResponsable;
	}
	public void setiDResponsable(int iDResponsable) {
		this.iDResponsable = iDResponsable;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public int getNumberParticipant() {
		return numberParticipant;
	}
	public void setNumberParticipant(int numberParticipant) {
		this.numberParticipant = numberParticipant;
	}
	public String getPlaceMeeting() {
		return placeMeeting;
	}
	public void setPlaceMeeting(String placeMeeting) {
		this.placeMeeting = placeMeeting;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getVoucher() {
		return voucher;
	}
	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}
	public Reunion(int iDMeeting, int iDResponsable, String type, String startDate, String endDate, String object,
			int numberParticipant, String placeMeeting, String report, String voucher) {
		super();
		this.iDMeeting = iDMeeting;
		this.iDResponsable = iDResponsable;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.object = object;
		this.numberParticipant = numberParticipant;
		this.placeMeeting = placeMeeting;
		this.report = report;
		this.voucher = voucher;
	}
	   

}
