package com.cafe24.memory.domain;

public class AnimalDisposal {
	private String animalDisposalCode;
	private String animalDisposalResult;
	private String animalDisposalDate;
	private String animalDisposalPastureInfo;
	private String animalDisposalDieInfo;
	private AnimalCenter animalCneter;
	private Staff staff;
	private Adoptee adoptee;
	private CenterReturn centerReturn;
	
	public String getAnimalDisposalCode() {
		return animalDisposalCode;
	}
	public void setAnimalDisposalCode(String animalDisposalCode) {
		this.animalDisposalCode = animalDisposalCode;
	}
	public String getAnimalDisposalResult() {
		return animalDisposalResult;
	}
	public void setAnimalDisposalResult(String animalDisposalResult) {
		this.animalDisposalResult = animalDisposalResult;
	}
	public String getAnimalDisposalDate() {
		return animalDisposalDate;
	}
	public void setAnimalDisposalDate(String animalDisposalDate) {
		this.animalDisposalDate = animalDisposalDate;
	}
	public String getAnimalDisposalPastureInfo() {
		return animalDisposalPastureInfo;
	}
	public void setAnimalDisposalPastureInfo(String animalDisposalPastureInfo) {
		this.animalDisposalPastureInfo = animalDisposalPastureInfo;
	}
	public String getAnimalDisposalDieInfo() {
		return animalDisposalDieInfo;
	}
	public void setAnimalDisposalDieInfo(String animalDisposalDieInfo) {
		this.animalDisposalDieInfo = animalDisposalDieInfo;
	}
	public AnimalCenter getAnimalCneter() {
		return animalCneter;
	}
	public void setAnimalCneter(AnimalCenter animalCneter) {
		this.animalCneter = animalCneter;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Adoptee getAdoptee() {
		return adoptee;
	}
	public void setAdoptee(Adoptee adoptee) {
		this.adoptee = adoptee;
	}
	public CenterReturn getCenterReturn() {
		return centerReturn;
	}
	public void setCenterReturn(CenterReturn centerReturn) {
		this.centerReturn = centerReturn;
	}
	@Override
	public String toString() {
		return "AnimalDisposal [animalDisposalCode=" + animalDisposalCode + ", animalDisposalResult="
				+ animalDisposalResult + ", animalDisposalDate=" + animalDisposalDate + ", animalDisposalPastureInfo="
				+ animalDisposalPastureInfo + ", animalDisposalDieInfo=" + animalDisposalDieInfo + ", animalCneter="
				+ animalCneter + ", staff=" + staff + ", adoptee=" + adoptee + ", centerReturn=" + centerReturn + "]";
	}
	
}
