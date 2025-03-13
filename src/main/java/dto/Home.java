package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Home {
	@Override
	public String toString() {
		return "Home [id=" + id + ", name=" + name + ", duration=" + duration + ", consuption=" + emition + ", note="
				+ note + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getEmition() {
		return emition;
	}
	public void setEmition(double consuption) {
		this.emition = consuption;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double duration;
	private double emition;
	private String note;
	@ManyToOne
	private User user;
	public Home() {
		super();
	}
	
	

}
