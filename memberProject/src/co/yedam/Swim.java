package co.yedam;

public class Swim {
	private int memNumber;
	private String memName;
	private String memPhone;
	private String memDay;
	private String gender;
	private String memDate;
	private String weight;
	public String getMemDate() {
		return memDate;
	}
	public void setMemDate(String memDate) {
		this.memDate = memDate;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public int getMemNumber() {
		return memNumber;
	}
	public void setMemNumber(int memNumber) {
		this.memNumber = memNumber;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemDay() {
		return memDay;
	}
	public void setMemDay(String memDay) {
		this.memDay = memDay;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return String.format("%2d %5s %-12s %10s %4s",memNumber,memName,memPhone,memDay,gender);
	}
	
}
