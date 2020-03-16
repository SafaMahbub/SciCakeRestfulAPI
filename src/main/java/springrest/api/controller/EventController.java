package springrest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springrest.api.error.RestException;
import springrest.model.Event;
import springrest.model.User;
import springrest.model.dao.EventDao;

@RestController
public class EventController {

	 @Autowired
	 private EventDao eventDao;
	 
	 @RequestMapping(value = "/events", method = RequestMethod.GET)
	 public List<Event> getEvents()
	 {
	        return eventDao.getEvents();
	 }

	 @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
	 public Event getEvent( @PathVariable Long id )
	 {
	        return eventDao.getEvent( id );
	 }

	 @RequestMapping(value = "/events/add", method = RequestMethod.POST)
	 public Event addEvent( @RequestBody Event event )
	 {
       if( event.getOrganizer() == null || event.getName() == null || event.getDescription() == null || event.getLocation() == null)
    	   throw new RestException( 400, "Missing organizer and/or name and/or description and/or location." );
       return eventDao.saveEvent( event );
	 }
	 
	 @RequestMapping(value = "/events/{id}/attendees", method = RequestMethod.GET)
	 public List<User> getAttendees( @PathVariable Long id )
	 {
       return eventDao.getAllAttendees(id);
	 }
	 
	 @RequestMapping(value="/events/{event_id}/addAttendee/{user_id}", method = RequestMethod.PUT)
	 public Event addUserToEvent(@PathVariable Long event_id , @PathVariable Long user_id ) {
		 return eventDao.addAttendeeToEvent(event_id, user_id);
	 }
	 
	 @RequestMapping(value="/events/{event_id}/AOR/{user_id}/{truthValue}", method = RequestMethod.PUT)
	 public Event acceptOrReject(@PathVariable Long event_id , @PathVariable Long user_id, @PathVariable boolean truthValue) {
		 return eventDao.rejectOrApprove(event_id, user_id, truthValue);
	 }
	 
	 
	 
}
