create table users
(
    user_id    bigint auto_increment primary key comment 'id',
    nickname   varchar(12) not null comment '닉네임',
    email      varchar(50) not null comment '이메일',
    status     varchar(10) not null comment '상태',
    created_at datetime    not null comment '생성 일시',
    updated_at datetime    not null comment '수정 일시'
) comment 'users' charset = utf8mb4;

create index users_idx01 on users (user_id);
create index users_idx02 on users (created_at);
create index users_idx03 on users (updated_at);