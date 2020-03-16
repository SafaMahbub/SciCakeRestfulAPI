package springrest.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springrest.model.Program;
import springrest.model.dao.ProgramDao;

@Repository
public class ProgramDaoImpl implements ProgramDao  {

	@PersistenceContext
	private EntityManager entityManager;
	 
	@Override
	public Program getProgram(Long id) {
		return entityManager.find( Program.class, id );
	}

	@Override
	public List<Program> getPrograms() {
		return entityManager.createQuery( "from Program order by id", Program.class )
	            .getResultList();
	}

	@Override
	@Transactional
	public Program saveProgram(Program program) {
		return entityManager.merge( program );
	}

	@Override
	public void deleteProgram(Program program) {
		entityManager.remove(program);
	}
	
	@Override
	@Transactional
	public void deleteProgram(Long id) {
		entityManager.remove(entityManager.find( Program.class, id ));
	}
	
	@Override
	@Transactional
	public void editProgram(Program program, Long id) {
		Program editedProgram = entityManager.find(Program.class, id);
		editedProgram.setDescription(program.getDescription());
		editedProgram.setFullName(program.getFullName());
		editedProgram.setName(program.getName());
		entityManager.merge( editedProgram );
	}
	
	public void addProgram(Program program) {
		entityManager.persist(program);
	}

	@Override
	public void editProgram(Program program) {
		// TODO Auto-generated method stub
		
	}
	
}
