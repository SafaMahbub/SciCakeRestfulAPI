package springrest.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springrest.model.Program;
import springrest.model.User;
import springrest.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUser( Long id )
    {
        return entityManager.find( User.class, id );
    }

    @Override
    public List<User> getUsers()
    {
        return entityManager.createQuery( "from User order by id", User.class )
            .getResultList();
    }

    @Override
    @Transactional
    public User saveUser( User user )
    {
        return entityManager.merge( user );
    }
    
	@Override
	@Transactional
	public void deleteUser(Long id) {
		entityManager.remove(entityManager.find( User.class, id ));
	}
    

}