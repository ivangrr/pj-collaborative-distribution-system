# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table rol (
  id                            bigint not null,
  name                          varchar(255),
  description                   varchar(255),
  constraint pk_rol primary key (id)
);
create sequence rol_seq;

create table user (
  id                            bigint not null,
  user_name                     varchar(255),
  first_name                    varchar(255),
  last_name                     varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (id)
);
create sequence user_seq;

create table user_rol (
  id                            bigint not null,
  user_id_id                    bigint,
  rol_id_id                     bigint,
  constraint pk_user_rol primary key (id)
);
create sequence user_rol_seq;

alter table user_rol add constraint fk_user_rol_user_id_id foreign key (user_id_id) references user (id) on delete restrict on update restrict;
create index ix_user_rol_user_id_id on user_rol (user_id_id);

alter table user_rol add constraint fk_user_rol_rol_id_id foreign key (rol_id_id) references rol (id) on delete restrict on update restrict;
create index ix_user_rol_rol_id_id on user_rol (rol_id_id);


# --- !Downs

alter table user_rol drop constraint if exists fk_user_rol_user_id_id;
drop index if exists ix_user_rol_user_id_id;

alter table user_rol drop constraint if exists fk_user_rol_rol_id_id;
drop index if exists ix_user_rol_rol_id_id;

drop table if exists rol;
drop sequence if exists rol_seq;

drop table if exists user;
drop sequence if exists user_seq;

drop table if exists user_rol;
drop sequence if exists user_rol_seq;

