package springrest.model.dao;

import java.util.List;

import springrest.model.Event;
import springrest.model.User;

public interface EventDao {

	Event getEvent( Long id );

    List<Event> getEvents();

    Event saveEvent( Event event );
    
    List<User> getAllAttendees(Long id);

	Event addAttendeeToEvent(Long event_id, Long user_id);
	
	Event rejectOrApprove(Long event_id, Long user_id, boolean truthValue);
    
}
