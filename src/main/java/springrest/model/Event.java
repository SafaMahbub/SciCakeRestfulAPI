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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Long id;
    
    //One Organizer can create many Events
    //An Event can be created by only One Organizer
//	@Column(nullable = false)
	@ManyToOne
	@JoinColumn(name="event_organizer_id", nullable=true)
	private User organizer;

    //One Administrator can approve many Events
    //Many Events can be approved by One Organizer
//	@Column
	@ManyToOne
	@JoinColumn(name="event_admin_id", nullable=true)
	private User admin;
	
	@Column
	private boolean approved = false;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String location;
	
	@Column(nullable = false)
	private Date startTime;
	
	@Column(nullable = false)
	private Date endTime;
	
	/*  Optional Values for an Event.  */
	
	/*  An Event can have many tags
		A Tag can be linked to many Events */
	@ManyToMany
    @JoinTable(name="event_tags",
    	joinColumns = @JoinColumn(name="event_id"),
    	inverseJoinColumns = @JoinColumn(name="tag_id"))
	private List<Tag> tags = new ArrayList<>();
	
	/*  An Event can have many Attendees
		An Attendee can attend many Events  */
	@ManyToMany
    @JoinTable(name="event_attendees",
    	joinColumns = @JoinColumn(name="event_id"),
    	inverseJoinColumns = @JoinColumn(name="user_id"))
	private List<User> attendees= new ArrayList<>();

	
	public Event() {}

	public Event(User organizer, String name, String description, String location, Date startTime, Date endTime) {
		super();
		this.organizer = organizer;
		this.name = name;
		this.approved = organizer.isEventOrganier() ? true : false;
		this.description = description;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Event(User organizer, String name, String description, String location, Date startTime, Date endTime, List<Tag> tags) {
		super();
		this.organizer = organizer;
		this.name = name;
		this.approved = organizer.isEventOrganier() ? true : false;
		this.description = description;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
		this.tags = tags;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getOrganizer() {
		return organizer;
	}


	public void setOrganizer(User organizer) {
		this.organizer = organizer;
	}


	public User getAdmin() {
		return admin;
	}


	public void setAdmin(User admin) {
		this.admin = admin;
	}


	public boolean isApproved() {
		return approved;
	}


	public void setApproved(boolean approved) {
		this.approved = approved;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public List<User> getAttendees() {
		return attendees;
	}


	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}


	public List<Tag> getTags() {
		return tags;
	}


	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	

}
