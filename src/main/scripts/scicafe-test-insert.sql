insert into hibernate_sequence values ( 100 );

insert into users (id, firstname, lastname, username, password, email, enabled, eventOrganier, rewardProvider, position, type) 
	values (1,'Safa','Mahbub', 'admin', '1234', 'safa@gmail.com', true, false, false, 1, 0);
	
insert into users (id, firstname, lastname, username, password, email, enabled, eventOrganier, rewardProvider, position, type) 
	values (2,'Saba','Mahbub', 'admin2', '1234', 'saba@gmail.com', true, true, true, 2, 0);
	
insert into users (id, firstname, lastname, username, password, email, enabled, eventOrganier, rewardProvider, position, type) 
	values (3,'Crystal','Lagmay', 'student1', '1234', 'student1@gmail.com', true, true, true, 0, 1);
	
insert into users (id, firstname, lastname, username, password, email, enabled, eventOrganier, rewardProvider, position, type) 
	values (4,'Angelika','Ringor', 'student2', '1234', 'student2@gmail.com', true, true, false, 0, 1);
	
insert into users (id, firstname, lastname, username, password, email, enabled, eventOrganier, rewardProvider, position, type) 
	values (5,'NuRi','Jeong', 'student3', '1234', 'student3@gmail.com', true, false, true, 0, 1);
	
insert into users (id, firstname, lastname, username, password, email, enabled, eventOrganier, rewardProvider, position, type) 
	values (6,'Meri','Mak', 'student4', '1234', 'student4@gmail.com', true, false, false, 0, 1);
	
insert into users (id, firstname, lastname, username, password, email, enabled, eventOrganier, rewardProvider, position, type) 
	values (7,'Addie','Garcia', 'student5', '1234', 'student5@gmail.com', true, true, true, 0, 1);
	
insert into users (id, firstname, lastname, username, password, email, enabled, eventOrganier, rewardProvider, position, type) 
	values (8,'Rachel','Robles', 'student6', '1234', 'student6@gmail.com', true, true, true, 0, 1);
	
	
insert into events(id, event_organizer_id, event_admin_id, name, description, location, startTime, endTime, approved)
	values (1, 1, 1, "Welcome Week", "Booths and Fun", "ECST Building", "2018-10-31", "2018-10-31", 0);
	
insert into events(id,event_organizer_id, event_admin_id, name, description, location, startTime, endTime, approved)
	values (2, 1, 1, "Oriantation", "Get Classes", "Golden Eagle Ballroom", "2018-10-20", "2018-10-30", 1);
	
insert into events(id,event_organizer_id, event_admin_id, name, description, location, startTime, endTime, approved)
	values (3, 2, 1, "Fundraiser", "fundraise", "Walkway", "2018-10-20", "2018-10-30", 1);

insert into events(id,event_organizer_id, event_admin_id, name, description, location, startTime, endTime, approved)
	values (4, 3, 1, "Nothing", "need to organize", "everywhere", "2018-10-20", "2018-10-30", 1);
	

insert into event_attendees (event_id, user_id) 
	value (1,1);
	
insert into event_attendees (event_id, user_id) 
	value (1,2);
	
	
insert into programs(id, description, fullname, name)
	values (1, "CS college", "Engineering, Computer Sciecne, and Technology", "ECST");
	
insert into programs(id, description, fullname, name)
	values (2, "The University we attend", "California State University, Los Angeles", "CSULA");
	
insert into programs(id, description, fullname, name)
	values (3, "The Wizarding Government of the USA", "The Magical Congress of the United States of America ", "MACUSA");
	
insert into programs(id, description, fullname, name)
	values (4, "EmptyProgram", "Should not be Here", "N.U.L.L");
	