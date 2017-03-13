# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table article (
  id                            bigint not null,
  code                          varchar(255),
  name                          varchar(255),
  description                   varchar(255),
  constraint pk_article primary key (id)
);
create sequence article_seq;

create table article_category (
  id                            bigint not null,
  article_id                    bigint,
  category_id                   bigint,
  constraint pk_article_category primary key (id)
);
create sequence article_category_seq;

create table article_demand (
  id                            bigint not null,
  article_id                    bigint,
  demand_id                     bigint,
  constraint pk_article_demand primary key (id)
);
create sequence article_demand_seq;

create table category (
  id                            bigint not null,
  code                          varchar(255),
  name                          varchar(255),
  constraint pk_category primary key (id)
);
create sequence category_seq;

create table demand (
  id                            bigint not null,
  code                          varchar(255),
  name                          varchar(255),
  description                   varchar(255),
  constraint pk_demand primary key (id)
);
create sequence demand_seq;

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

alter table article_category add constraint fk_article_category_article_id foreign key (article_id) references article (id) on delete restrict on update restrict;
create index ix_article_category_article_id on article_category (article_id);

alter table article_category add constraint fk_article_category_category_id foreign key (category_id) references category (id) on delete restrict on update restrict;
create index ix_article_category_category_id on article_category (category_id);

alter table article_demand add constraint fk_article_demand_article_id foreign key (article_id) references article (id) on delete restrict on update restrict;
create index ix_article_demand_article_id on article_demand (article_id);

alter table article_demand add constraint fk_article_demand_demand_id foreign key (demand_id) references demand (id) on delete restrict on update restrict;
create index ix_article_demand_demand_id on article_demand (demand_id);

alter table user_rol add constraint fk_user_rol_user_id_id foreign key (user_id_id) references user (id) on delete restrict on update restrict;
create index ix_user_rol_user_id_id on user_rol (user_id_id);

alter table user_rol add constraint fk_user_rol_rol_id_id foreign key (rol_id_id) references rol (id) on delete restrict on update restrict;
create index ix_user_rol_rol_id_id on user_rol (rol_id_id);


# --- !Downs

alter table article_category drop constraint if exists fk_article_category_article_id;
drop index if exists ix_article_category_article_id;

alter table article_category drop constraint if exists fk_article_category_category_id;
drop index if exists ix_article_category_category_id;

alter table article_demand drop constraint if exists fk_article_demand_article_id;
drop index if exists ix_article_demand_article_id;

alter table article_demand drop constraint if exists fk_article_demand_demand_id;
drop index if exists ix_article_demand_demand_id;

alter table user_rol drop constraint if exists fk_user_rol_user_id_id;
drop index if exists ix_user_rol_user_id_id;

alter table user_rol drop constraint if exists fk_user_rol_rol_id_id;
drop index if exists ix_user_rol_rol_id_id;

drop table if exists article;
drop sequence if exists article_seq;

drop table if exists article_category;
drop sequence if exists article_category_seq;

drop table if exists article_demand;
drop sequence if exists article_demand_seq;

drop table if exists category;
drop sequence if exists category_seq;

drop table if exists demand;
drop sequence if exists demand_seq;

drop table if exists rol;
drop sequence if exists rol_seq;

drop table if exists user;
drop sequence if exists user_seq;

drop table if exists user_rol;
drop sequence if exists user_rol_seq;

