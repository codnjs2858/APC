package com.cafe24.memory.domain;

public class ReportManger {
	private String acceptCode;
	private SearchReportAnimal searchReport;
	private LostReportAnimal lostReport;
	private String acceptState;
	private Member member;
	private String acceptInDate;
	private String acceptOutDate;
	private String reportLocation;
	
	
	public String getReportLocation() {
		return reportLocation;
	}
	public void setReportLocation(String reportLocation) {
		this.reportLocation = reportLocation;
	}
	public String getAcceptCode() {
		return acceptCode;
	}
	public void setAcceptCode(String acceptCode) {
		this.acceptCode = acceptCode;
	}
	public SearchReportAnimal getSearchReport() {
		return searchReport;
	}
	public void setSearchReport(SearchReportAnimal searchReport) {
		this.searchReport = searchReport;
	}
	
	public LostReportAnimal getLostReport() {
		return lostReport;
	}
	public void setLostReport(LostReportAnimal lostReport) {
		this.lostReport = lostReport;
	}
	public String getAcceptState() {
		return acceptState;
	}
	public void setAcceptState(String acceptState) {
		this.acceptState = acceptState;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getAcceptInDate() {
		return acceptInDate;
	}
	public void setAcceptInDate(String acceptInDate) {
		this.acceptInDate = acceptInDate;
	}
	public String getAcceptOutDate() {
		return acceptOutDate;
	}
	public void setAcceptOutDate(String acceptOutDate) {
		this.acceptOutDate = acceptOutDate;
	}
	@Override
	public String toString() {
		return "ReportManger [acceptCode=" + acceptCode + ", searchReport=" + searchReport + ", lostReport=" + lostReport + ", acceptState=" + acceptState + ", member=" + member
				+ ", acceptInDate=" + acceptInDate + ", acceptOutDate=" + acceptOutDate + "]";
	}
	
	
	
}
