package dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class User {

	
	
	
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", number=" + number + ", email=" + email + ", password="
				+ password + ", travel=" + travel + ", home=" + home + ", materail=" + materail + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
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
	public List<Travel> getTravel() {
		return travel;
	}
	public void setTravel(List<Travel> travel) {
		this.travel = travel;
	}
	public List<Home> getHome() {
		return home;
	}
	public void setHome(List<Home> home) {
		this.home = home;
	}
	public List<Material> getMaterail() {
		return materail;
	}
	public void setMaterail(List<Material> materail) {
		this.materail = materail;
	}
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
    private	int userId;
	private	String name;
	private	long number;
	private	String email;
	private String password;
	
	@OneToMany(mappedBy = "user") 
	private List<Travel> travel;
	@OneToMany(mappedBy = "user") 
	private List<Home> home;
	@OneToMany(mappedBy = "user") 
	private List<Material> materail;
	public User() {
		super();
	}
	
	
	
	

}
