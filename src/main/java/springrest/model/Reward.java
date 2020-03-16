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
@Table(name = "rewards")
public class Reward implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Long id;
    
    //One Organizer can submit Many Rewards
    //One Reward can be submitted by One Organizers
//	@Column(nullable = false)
	@ManyToOne
	@JoinColumn(name="reward_organizer_id", nullable=false)
	private User organizer;
	
	//One Administrator can approve many Rewards
    //A Reward can be approved by One Organizer
//	@Column
	@ManyToOne
	@JoinColumn(name="reward_admin_id", nullable=false)
	private User admin;
	
	private boolean approved;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String rewardProvidor;
	
	@Column(nullable = false)
	private Date rewardPeriod;
	
	@Column(nullable = false)
	private Date startTime;
	
	@Column(nullable = false)
	private Date endTime;
	
	//Optional Values for an Event.
	//A Reward can have many tags
	//A Tag can be linked to many Rewards
	@ManyToMany
    @JoinTable(name="reward_tags",
    	joinColumns = @JoinColumn(name="reward_id"),
    	inverseJoinColumns = @JoinColumn(name="tag_id"))
	private List<Tag> tags;
	
	//Optional Values for an Event.
	//A Reward can have many events
	//A event can be linked to many Rewards
	@ManyToMany
    @JoinTable(name="reward_events",
	    joinColumns = @JoinColumn(name="reward_id"),
	    inverseJoinColumns = @JoinColumn(name="event_id"))
	private List<Event> qualifiedEvents = new ArrayList<>();
	
	@Column
	private int rewardCriteria = 0;
	
	public Reward() {}
	
	public Reward(User organizer, String description, String rewardProvidor, Date rewardPeriod, Date startTime,
			Date endTime, List<Event> qualifiedEvents, int rewardCriteria) {
		super();
		this.organizer = organizer;
		this.description = description;
		this.rewardProvidor = rewardProvidor;
		this.rewardPeriod = rewardPeriod;
		this.startTime = startTime;
		this.endTime = endTime;
		this.qualifiedEvents = qualifiedEvents;
		this.rewardCriteria = rewardCriteria;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRewardProvidor() {
		return rewardProvidor;
	}
	public void setRewardProvidor(String rewardProvidor) {
		this.rewardProvidor = rewardProvidor;
	}
	public Date getRewardPeriod() {
		return rewardPeriod;
	}
	public void setRewardPeriod(Date rewardPeriod) {
		this.rewardPeriod = rewardPeriod;
	}
	public List<Tag> getTag() {
		return tags;
	}
	public void setTag(List<Tag> tags) {
		this.tags = tags;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public int getRewardCriteria() {
		return rewardCriteria;
	}
	public void setRewardCriteria(int rewardCriteria) {
		this.rewardCriteria = rewardCriteria;
	}
	
	

}
