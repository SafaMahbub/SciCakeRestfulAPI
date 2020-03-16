package springrest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springrest.api.error.RestException;
import springrest.api.error.RestExceptionHandler;
import springrest.model.User;
import springrest.model.dao.UserDao;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser( @PathVariable Long id )
    {
        return userDao.getUser( id );
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers()
    {
        return userDao.getUsers();
    }
    
    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public User addUser( @RequestBody User user )
    {
        if( user.getUsername() == null || user.getPassword() == null || user.getUsername() == "" || user.getPassword() == "")
            throw new RestException( 400, "Missing username and/or password." );

        return userDao.saveUser( user );
    }
    
	 @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.GET)
	 public void deleteUsers(@PathVariable Long id)
	 {
	     userDao.deleteUser(id);
	 }

}