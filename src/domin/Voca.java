package domin;

import java.sql.Timestamp;

public class Voca {
	
	private int voca_pk;
	private String title;
	private String voca_desc;
	private String user_email;
	private int recommend;
	private int views;
	private Timestamp c_date;
	public int getVoca_pk() {
		return voca_pk;
	}
	public void setVoca_pk(int voca_pk) {
		this.voca_pk = voca_pk;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVoca_desc() {
		return voca_desc;
	}
	public void setVoca_desc(String voca_desc) {
		this.voca_desc = voca_desc;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public Timestamp getC_date() {
		return c_date;
	}
	public void setC_date(Timestamp c_date) {
		this.c_date = c_date;
	}
	
	
	
}
