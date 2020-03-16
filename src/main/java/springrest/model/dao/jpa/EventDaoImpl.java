package springrest.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springrest.model.Event;
import springrest.model.Type;
import springrest.model.User;
import springrest.model.dao.EventDao;

@Repository
public class EventDaoImpl implements EventDao {

	 @PersistenceContext
	 private EntityManager entityManager;
	  
	@Override
	public Event getEvent(Long id) 
	{
		return entityManager.find( Event.class, id );
	}

	@Override
	public List<Event> getEvents() 
	{
		return entityManager.createQuery( "from Event order by id", Event.class )
	            .getResultList();
	}

	@Override
	@Transactional
	public Event saveEvent(Event event) 
	{
		 return entityManager.merge( event );
	}

	@Override
	public List<User> getAllAttendees(Long id) 
	{
		return entityManager.find( Event.class, id ).getAttendees();
	}
	
	@Override
	@Transactional
	public Event addAttendeeToEvent(Long event_id, Long user_id) {
		User user = entityManager.find( User.class, user_id );
		Event event = entityManager.find( Event.class, event_id );
		event.getAttendees().add(user);
		return entityManager.merge( event );
	}

	@Override
	@Transactional
	public Event rejectOrApprove(Long event_id, Long user_id, boolean truthValue) {
		User user = entityManager.find( User.class, user_id );
		Event event = entityManager.find( Event.class, event_id );
		if(user.getType() == Type.ADMIN) {
			event.setApproved(truthValue);
			return entityManager.merge( event );
		}
		else {
			return event;
		}
	}

}
