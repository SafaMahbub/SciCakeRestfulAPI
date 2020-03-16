package springrest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Enumerated
    @Column(nullable = false)
    private Type type = Type.USER;
    
    @Column(nullable = false)
    private String firstname;
    
    @Column(nullable = false)
    private String lastname;
    
    @Enumerated
    @Column(nullable = false)
    private Position position = Position.STUDENT;
    
    private String majorOrOrganizationalUnit;
    
    @Column(nullable = false, unique = true)
    private String username;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;
    
    private String email;
    
	private boolean enabled = true;

    @ManyToMany
    @JoinTable(name = "authorities",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles;

  //Optional Information 
    @Column
    private String title;
    
    @ManyToMany
    @JoinTable(name="user_programs",
    	joinColumns = @JoinColumn(name="user_id"),
    	inverseJoinColumns = @JoinColumn(name="program_id"))
    private List<Program> programAffiliations = new ArrayList<>();
    
    private boolean eventOrganier;
    
    private boolean rewardProvider;
    
//    public User()
//    {
//        roles = new HashSet<Role>();
//    }
    public User()
    {
        roles = new HashSet<Role>();
        this.username = "";
		this.password = "";
		this.firstname = "";
		this.lastname = "";
		this.email = "";
		this.position = Position.STUDENT;
		this.type = Type.USER;
		this.enabled = true;
		this.title = "";
		this.eventOrganier = false;
		this.rewardProvider = false;
    }
    
    public User(String firstname, String lastname, String username, String password,  String email) {
		roles = new HashSet<Role>();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.position = Position.STUDENT;
		this.type = Type.USER;
		this.enabled = true;
		this.eventOrganier = false;
		this.rewardProvider = false;
	}
    
    public User(String firstname, String lastname, String username, String password,  String email, Position position) {
		roles = new HashSet<Role>();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.position = Position.STUDENT;
		this.type = Type.USER;
		this.enabled = true;
		this.position = position;
		this.eventOrganier = false;
		this.rewardProvider = false;
	}
    
    public User(String firstname, String lastname, String username, String password, String email, Position position, List<Program> programAffiliations) {
		roles = new HashSet<Role>();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.position = Position.STUDENT;
		this.type = Type.USER;
		this.enabled = true;
		this.position = position;
		this.programAffiliations = programAffiliations;
		this.eventOrganier = false;
		this.rewardProvider = false;
	}
    
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Program> getProgramAffiliations() {
		return programAffiliations;
	}

	public void setProgramAffiliations(List<Program> programAffiliations) {
		this.programAffiliations = programAffiliations;
	}

	public boolean isEventOrganier() {
		return eventOrganier;
	}

	public void setEventOrganier(boolean eventOrganier) {
		this.eventOrganier = eventOrganier;
	}

	public boolean getRewardProvider() {
		return rewardProvider;
	}

	public void setRewardProvider(boolean rewardProvider) {
		this.rewardProvider = rewardProvider;
	}
    

    
	

}