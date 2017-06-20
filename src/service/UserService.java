package service;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import domin.User;
import domin.Voca;
import domin.Word;

public final class UserService {
	
	private static UserService instance = new UserService();
	
	private UserService()
	{
		
	}
	
	// single design pattern
	public static UserService getInstance()
	{
		return instance;
	}
	
	public User getUser(String email)
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		User user = null;
		
		/*System.out.println("email : "+email);*/
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/vocabulary?useUnicode=true&characterEncoding=utf8",
							"root","sisi");
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM users");
			sql.append(" WHERE email = ?; ");
			
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setAge(rs.getString("age"));
				user.setC_date(rs.getTimestamp("c_date"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
			
			if (pstmt != null) {
				try{
					pstmt.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if( connection != null ){
				try{
					connection.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
		
		return user;
	}
	
	public boolean registerUser(String email, String pass, String name, String age)
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/vocabulary?useUnicode=true&characterEncoding=utf8",
							"root","sisi");
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO users");
			sql.append(" (email,pass,name,age) ");
			sql.append("VALUES ");
			sql.append("(?,?,?,?); ");
			
			
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, email);
			pstmt.setString(2, pass);
			pstmt.setString(3, name);
			pstmt.setString(4, age);
			
			if(pstmt.executeUpdate()!=0) // insert, update, delete , create table, drop table SQL DDL
			{
				return true; // if sign up : success
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
			
			if (pstmt != null) {
				try{
					pstmt.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if( connection != null ){
				try{
					connection.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
		
		return false; // else sign up : false
		
	}
	
	public List<Voca> vocaList(String email)
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		List<Voca> list = new LinkedList<Voca>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/vocabulary?useUnicode=true&characterEncoding=utf8",
							"root","sisi");
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM voca");
			
			if(!email.equals("*")) {
				sql.append(" WHERE user_email = ? ORDER BY voca_pk DESC;");
				pstmt = connection.prepareStatement(sql.toString());
				pstmt.setString(1, email);
			}else {
				sql.append(" ORDER BY voca_pk DESC;");
				pstmt = connection.prepareStatement(sql.toString());
			}
			
			Voca voca = null;
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int voca_pk = rs.getInt("voca_pk");
				String title = rs.getString("title");
				String voca_desc = rs.getString("voca_desc");
				String user_email = rs.getString("user_email");
				int recommend = rs.getInt("recommend");
				int views = rs.getInt("views");
				Timestamp c_date = rs.getTimestamp("c_date");
				
				voca = new Voca();
				voca.setVoca_pk(voca_pk);
				voca.setTitle(title);
				voca.setVoca_desc(voca_desc);
				voca.setUser_email(user_email);
				voca.setRecommend(recommend);
				voca.setViews(views);
				voca.setC_date(c_date);
				
				list.add(voca);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
			
			if (pstmt != null) {
				try{
					pstmt.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if( connection != null ){
				try{
					connection.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	
	public List<Word> wordList(int voca_fk) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Word> list = new LinkedList<Word>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/vocabulary?useUnicode=true&characterEncoding=utf8",
							"root","sisi");
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM word");
			sql.append(" WHERE voca_fk = ?");
			
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setInt(1, voca_fk);
			
			Word word = null;
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				int word_pk = rs.getInt("word_pk");
				int vocafk = rs.getInt("voca_fk");
				String e_word = rs.getString("word");
				String mean = rs.getString("mean");
				
				word = new Word();
				
				word.setWord_pk(word_pk);
				word.setVoca_fk(vocafk);
				word.setWord(e_word);
				word.setMean(mean);
				
				list.add(word);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
			
			if (pstmt != null) {
				try{
					pstmt.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if( connection != null ){
				try{
					connection.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
		
		return list;
		
	}
	
	public boolean addVoca(String title, String voca_desc, String user_email) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean check = false;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/vocabulary?useUnicode=true&characterEncoding=utf8",
							"root","sisi");
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO voca (title, voca_desc, user_email)");
			sql.append(" VALUES (?,?,?)");
			
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, title);
			pstmt.setString(2, voca_desc);
			pstmt.setString(3, user_email);
			
			if ( pstmt.executeUpdate() != 0 ) {
				return true; // success
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			if (rs != null)
			{
				try
				{
					rs.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (connection != null)
			{
				try
				{
					connection.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
		}
		
		
		return false;
	}
	
	
}
