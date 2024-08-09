create table if not exists events (
  id varchar(255) primary key,
  type varchar(255),
  entity varchar(255),
  description text,
  created_at timestamp default current_timestamp
);

create table if not exists goals (
    id varchar(255) primary key,
    description text
);

create table if not exists bricks (
    id varchar(255) primary key,
    goal_id varchar(255) references goals(id) on delete cascade,
    description text,
    status varchar(255),
    start_date timestamp,
    end_date timestamp
);

create table if not exists tasks (
    id varchar(255) primary key,
    brick_id varchar(255) references bricks(id) on delete cascade,
    description text,
    status varchar(255),
    expected_date timestamp
);
