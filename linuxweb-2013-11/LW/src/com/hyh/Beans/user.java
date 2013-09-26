package com.hyh.Beans;

public class user {
	private long id;//user id
	private String name;
	private String username;//user name
    private String password;//password
    private String email;
    private String interest;
    private String introduct;//introduce yourelf int 50 words
    private String headpath;
	private int    state;//通过验证后state为 ‘1’ ，默认为 ‘0’
    public String getHeadpath() {
		return headpath;
	}
	public void setHeadpath(String headpath) {
		this.headpath = headpath;
	}
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}   
    public user(){
    	
    	this.state=0;//新注册用户状态为0
    }
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getIntroduct() {
		return introduct;
	}
	public void setIntroduct(String introduct) {
		this.introduct = introduct;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}    
}
