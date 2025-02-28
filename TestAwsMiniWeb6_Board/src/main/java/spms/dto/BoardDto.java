package spms.dto;

import java.util.Date;

public class BoardDto {

	private int no;
	private String title;
	private String content;
	private int memberNo;
	private Date createdDate;
	private Date updateDate;

	public BoardDto() {
		super();
	}

	public BoardDto(int no, String title, String content, int memberNo
		, Date createdDate, Date updateDate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.memberNo = memberNo;
		this.createdDate = createdDate;
		this.updateDate = updateDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", title=" + title + ", content=" + content 
			+ ", createdDate=" + createdDate + ", modifiedDate=" + updateDate + "]";
	}

}
