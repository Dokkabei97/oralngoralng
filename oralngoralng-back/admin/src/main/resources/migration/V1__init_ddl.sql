create table admins
(
    admin_id bigint auto_increment primary key comment 'id',
    employee_number int not null comment '사원번호',
    password varchar(50) not null comment '비밀번호',
    team varchar(255) not null comment '소속 팀',
    admin_level varchar(255) not null comment '계정 권한',
    created_at            datetime     not null comment '생성 일시',
    updated_at            datetime     not null comment '수정 일시'
) comment 'admins' charset = utf8mb4;

create index admin_idx01 on admins (team);
create index admin_idx02 on admins (admin_level);
