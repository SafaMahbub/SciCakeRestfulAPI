    create table authorities (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB;

    create table event_attendees (
       event_id bigint not null,
        user_id bigint not null
    ) engine=InnoDB;

    create table event_tags (
       event_id bigint not null,
        tag_id bigint not null
    ) engine=InnoDB;

    create table events (
       id bigint not null,
        approved bit,
        description varchar(255) not null,
        endTime datetime(6) not null,
        location varchar(255) not null,
        name varchar(255) not null,
        startTime datetime(6) not null,
        event_admin_id bigint,
        event_organizer_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB;

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    create table programs (
       id bigint not null,
        description varchar(255) not null,
        fullName varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table reward_events (
       reward_id bigint not null,
        event_id bigint not null
    ) engine=InnoDB;

    create table reward_tags (
       reward_id bigint not null,
        tag_id bigint not null
    ) engine=InnoDB;

    create table rewards (
       id bigint not null,
        approved bit not null,
        description varchar(255) not null,
        endTime datetime(6) not null,
        rewardCriteria integer,
        rewardPeriod datetime(6) not null,
        rewardProvidor varchar(255) not null,
        startTime datetime(6) not null,
        reward_admin_id bigint not null,
        reward_organizer_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table roles (
       id bigint not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table tags (
       id bigint not null,
        keywords varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user_programs (
       user_id bigint not null,
        program_id bigint not null
    ) engine=InnoDB;

    create table users (
       id bigint not null,
        email varchar(255),
        enabled bit not null,
        eventOrganier bit not null,
        firstname varchar(255) not null,
        lastname varchar(255) not null,
        majorOrOrganizationalUnit varchar(255),
        password varchar(255) not null,
        position integer not null,
        rewardProvider bit not null,
        title varchar(255),
        type integer not null,
        username varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table roles 
       add constraint UK_ofx66keruapi6vyqpv6f2or37 unique (name);

    alter table users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table authorities 
       add constraint FK7kj74d912rytfp5su91jfv0tg 
       foreign key (role_id) 
       references roles (id);

    alter table authorities 
       add constraint FKk91upmbueyim93v469wj7b2qh 
       foreign key (user_id) 
       references users (id);

    alter table event_attendees 
       add constraint FK3mumymyj0ryrrywpf5ivgnf1f 
       foreign key (user_id) 
       references users (id);

    alter table event_attendees 
       add constraint FKg0w14vgqmpawqmil4fceac4yl 
       foreign key (event_id) 
       references events (id);

    alter table event_tags 
       add constraint FKt07xql63t6125c0wjk4j0lmqa 
       foreign key (tag_id) 
       references tags (id);

    alter table event_tags 
       add constraint FKiwoyitw224ykom58m5xnoa9y6 
       foreign key (event_id) 
       references events (id);

    alter table events 
       add constraint FKfog7adhnyps0i21amjifxbq64 
       foreign key (event_admin_id) 
       references users (id);

    alter table events 
       add constraint FK1fujyvl0ss8u0djch7gmq0kwb 
       foreign key (event_organizer_id) 
       references users (id);

    alter table reward_events 
       add constraint FK538kirbkb6png8a71m6079i29 
       foreign key (event_id) 
       references events (id);

    alter table reward_events 
       add constraint FK5mc6mdjggcudrk0lbmviwqkto 
       foreign key (reward_id) 
       references rewards (id);

    alter table reward_tags 
       add constraint FKrme51rxlg35li6urfbau42ftj 
       foreign key (tag_id) 
       references tags (id);

    alter table reward_tags 
       add constraint FKobaw2285v7d2jy2ebu4r2t7o1 
       foreign key (reward_id) 
       references rewards (id);

    alter table rewards 
       add constraint FKjli1xiigx74qg6o9x8t7wyj0w 
       foreign key (reward_admin_id) 
       references users (id);

    alter table rewards 
       add constraint FK4uw4jbr1teui6d89ibnxil7wl 
       foreign key (reward_organizer_id) 
       references users (id);

    alter table user_programs 
       add constraint FKd0274qw0xgtikgh5psfoodt0r 
       foreign key (program_id) 
       references programs (id);

    alter table user_programs 
       add constraint FK9gjbg4lfrjs20gvktxg60gma6 
       foreign key (user_id) 
       references users (id);
       