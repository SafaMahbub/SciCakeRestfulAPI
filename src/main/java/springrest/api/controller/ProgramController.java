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
import springrest.model.Program;
import springrest.model.User;
import springrest.model.dao.EventDao;
import springrest.model.dao.ProgramDao;

@RestController
public class ProgramController {


	 @Autowired
	 private ProgramDao programDao;

	 @RequestMapping(value = "/programs", method = RequestMethod.GET)
	 public List<Program> getPrograms()
	 {
	        return programDao.getPrograms();
	 }
	 
	 @RequestMapping(value = "/programs/{id}", method = RequestMethod.GET)
	 public Program getProgram( @PathVariable Long id )
	 {
	        return programDao.getProgram( id );
	 }
	 
	 @RequestMapping(value = "/programs/add", method = RequestMethod.POST)
	 public Program addProgram( @RequestBody Program program )
	 {
	     if( program.getName() == null || program.getFullName() == null || program.getDescription() == null )
	         throw new RestException( 400, "Missing name and/or fullname and/or description." );

         return programDao.saveProgram( program );
	 }
	 
	 @RequestMapping(value = "/programs/edit/{id}", method = RequestMethod.POST)
	 public void editProgram(@RequestBody Program program , @PathVariable Long id ) {
		 if( program.getName() == null || program.getFullName() == null || program.getDescription() == null )
	         throw new RestException( 400, "Missing name and/or fullname and/or description." );
		 programDao.editProgram(program, id);
	 }
	 
	 @RequestMapping(value = "/programs/delete/{id}", method = RequestMethod.GET)
	 public void deleteProgram(@PathVariable Long id)
	 {
	     programDao.deleteProgram(id);
	 }
	 
}
