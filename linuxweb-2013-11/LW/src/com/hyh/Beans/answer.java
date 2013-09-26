package com.hyh.Beans;
/*
 * answer bean
 */
public class answer {
	private long id;
	private long qaid;
	private long fromid;
	private String answer;
	private String answertime;
	private long approve;

	public long getApprove() {
		return approve;
	}
	public void setApprove(long approve) {
		this.approve = approve;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getQaid() {
		return qaid;
	}
	public void setQaid(long qaid) {
		this.qaid = qaid;
	}
	public long getFromid() {
		return fromid;
	}
	public void setFromid(long fromid) {
		this.fromid = fromid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswertime() {
		return answertime;
	}
	public void setAnswertime(String answertime) {
		this.answertime = answertime;
	}

}
