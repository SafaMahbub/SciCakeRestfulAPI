package springrest.model.dao;

import java.util.List;

import springrest.model.Program;

public interface ProgramDao {
	
	Program getProgram( Long id );

    List<Program> getPrograms();

    Program saveProgram( Program program );

	void deleteProgram(Program program);
	
	void deleteProgram(Long id);
	
	void editProgram(Program program);

	void editProgram(Program program, Long id);

}
