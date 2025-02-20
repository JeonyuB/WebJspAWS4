package spms.dto;

import java.util.Date;

public class MemberDto {
	private int no;
	private String name;
	private String email;
	private String password;
	private Date createdDate;
	private Date modifedEDate;

	
	
	
	public MemberDto(int no) {
		super();
	}

	public MemberDto(int no, String name, String email, String password, Date createdDate, Date modifedEDate) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.password = password;
		this.createdDate = createdDate;
		this.modifedEDate = modifedEDate;
	}
	
	

	public MemberDto(int no, String name, String email, Date createdDate) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.createdDate = createdDate;
	}



	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifedEDate() {
		return modifedEDate;
	}

	public void setModifedEDate(Date modifedEDate) {
		this.modifedEDate = modifedEDate;
	}
	
	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", createdDate=" + createdDate + ", modifedEDate=" + modifedEDate + "]";
	}
	
	
}
