package com.cafe24.memory.domain;

public class ReportManger {
	private String acceptCode;
	private String reportCode;
	private String acceptState;
	private Member memberId;
	private String acceptInDate;
	private String acceptOutDate;
	public String getAcceptCode() {
		return acceptCode;
	}
	public void setAcceptCode(String acceptCode) {
		this.acceptCode = acceptCode;
	}
	public String getReportCode() {
		return reportCode;
	}
	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}
	public String getAcceptState() {
		return acceptState;
	}
	public void setAcceptState(String acceptState) {
		this.acceptState = acceptState;
	}
	public Member getMemberId() {
		return memberId;
	}
	public void setMemberId(Member memberId) {
		this.memberId = memberId;
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
		return "ReportManger [acceptCode=" + acceptCode + ", reportCode=" + reportCode + ", acceptState=" + acceptState
				+ ", memberId=" + memberId + ", acceptInDate=" + acceptInDate + ", acceptOutDate=" + acceptOutDate
				+ "]";
	}
	
	
	
}
