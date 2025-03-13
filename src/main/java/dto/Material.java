package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Material {
	@Override
	public String toString() {
		return "Material [id=" + id + ", name=" + name + ", unite=" + unite + ", consumption=" + emition + ", note="
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
	public double getUnite() {
		return unite;
	}
	public void setUnite(double unite) {
		this.unite = unite;
	}
	public double getEmition() {
		return emition;
	}
	public void setEmition(double consumption) {
		this.emition = consumption;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Material() {
		// TODO Auto-generated constructor stub
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
	private double unite;
	private double emition;
	private String note;
	@ManyToOne
	private User user;
	

}
