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
@Table(name = "tags")
public class Tag  implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private String keywords;
    
    @ManyToMany(mappedBy = "tags")
    private List<Event> events = new ArrayList<>();
    
    public Tag() {}
    
    public Tag(String keywords) {
		super();
		this.keywords = keywords;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}   
    
}
