alter table if exists award
    drop constraint if exists FK7p0urodh5nikt550flbqsk5mf;

alter table if exists competition
    drop constraint if exists FKbg9ud9wc0m0cdeie10fvh6m1e;

alter table if exists competition
    drop constraint if exists FKlw55agtwp4su7n6ssbbmim7pe;

alter table if exists competition
    drop constraint if exists FKj955lv10edixexa8w6yby4an6;

alter table if exists player_sport_school
    drop constraint if exists FKl05qhl4c76uituv2evekrxjxt;

alter table if exists player_sport_school
    drop constraint if exists FK9uwppqp2378tpgjuce52ru2by;

alter table if exists referee
     drop constraint if exists FKjtcthd6tb5fu26kvn6d7pf2o3;

drop table if exists award cascade;
drop table if exists competition cascade;
drop table if exists license cascade;
drop table if exists player cascade;
drop table if exists player_sport_school cascade;
drop table if exists referee cascade;
drop table if exists sport_school cascade;

drop sequence if exists competition_SEQ;
create sequence competition_SEQ start with 1 increment by 50;

create table award (
    id integer not null,
    winner_id integer,
    year_ smallint not null,
    title varchar(255) not null,
    primary key (id)
);

create table competition (
    competition_level smallint check (competition_level between 0 and 3),
    first_player_id integer,
    referee_id integer,
    second_player_id integer,
    id bigint not null,
    city varchar(255),
    stadium varchar(255),
    title varchar(255),
    primary key (id)
);

create table license (
    sn integer,
    id bigserial not null,
    descr varchar(255),
    license_number varchar(255),
    primary key (id)
);

create table player (
    id integer not null,
    rating integer,
    first_name varchar(255),
    primary key (id)
);

create table player_sport_school (
    player_id integer not null,
    sport_school_id varchar(255) not null,
    primary key (player_id, sport_school_id)
);

create table referee (
    id integer not null,
    license_id bigint unique,
    first_name varchar(255),
    primary key (id)
);

create table sport_school (
    id varchar(255) not null,
    title varchar(255),
    primary key (id)
);

alter table if exists award
    add constraint FK7p0urodh5nikt550flbqsk5mf
    foreign key (winner_id)
    references player;

alter table if exists competition
    add constraint FKbg9ud9wc0m0cdeie10fvh6m1e
    foreign key (first_player_id)
    references player;

alter table if exists competition
    add constraint FKlw55agtwp4su7n6ssbbmim7pe
    foreign key (referee_id)
    references referee;

alter table if exists competition
    add constraint FKj955lv10edixexa8w6yby4an6
    foreign key (second_player_id)
    references player;

alter table if exists player_sport_school
    add constraint FKl05qhl4c76uituv2evekrxjxt
    foreign key (sport_school_id)
    references sport_school;

alter table if exists player_sport_school
    add constraint FK9uwppqp2378tpgjuce52ru2by
    foreign key (player_id)
    references player;

alter table if exists referee
    add constraint FKjtcthd6tb5fu26kvn6d7pf2o3
    foreign key (license_id)
    references license;