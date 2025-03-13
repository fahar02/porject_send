package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Travel {
	
	public double getReduce() {
		return reduce;
	}
	public void setReduce(double reduce) {
		this.reduce = reduce;
	}
	@Override
	public String toString() {
		return "Travle [id=" + id + ", name=" + name + ", distance=" + distance + ", prefferedMode=" + prefferedMode
				+ ", insteadMode=" + insteadMode + ", reduce=" + reduce + ", note=" + note + "]";
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
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getPrefferedMode() {
		return prefferedMode;
	}
	public void setPrefferedMode(String prefferedMode) {
		this.prefferedMode = prefferedMode;
	}
	public String getInsteadMode() {
		return insteadMode;
	}
	public void setInsteadMode(String insteadMode) {
		this.insteadMode = insteadMode;
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
	private double distance;
	private String prefferedMode;
	private String insteadMode;
	private double reduce;
	private String note;
	@ManyToOne
	private User user;
	public Travel() {
		super();
	}
	
	

}
