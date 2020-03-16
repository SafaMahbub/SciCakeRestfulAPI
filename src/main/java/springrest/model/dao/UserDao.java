package springrest.model.dao;

import java.util.List;

import springrest.model.User;

public interface UserDao {

    User getUser( Long id );

    List<User> getUsers();

    User saveUser( User user );

	void deleteUser(Long id);

}