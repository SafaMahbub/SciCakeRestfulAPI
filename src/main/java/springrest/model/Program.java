package springrest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "programs")
public class Program implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Long id;
    
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String fullName;
	
	@Column(nullable = false)
	private String description;
	
	
	 @ManyToMany(mappedBy = "programAffiliations")
	 private List<User> user = new ArrayList<>();
	
	public Program() {}
	
	public Program(String name, String fullName, String description) {
		super();
		this.name = name;
		this.fullName = fullName;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getId() {
		return this.id;
	}
	
}
