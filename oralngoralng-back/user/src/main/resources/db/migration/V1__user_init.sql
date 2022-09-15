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

create table cards
(
    card_id      bigint auto_increment primary key comment 'id',
    card_token   varchar(255) not null comment 'card_token',
    card_company varchar(30)  not null comment '카드 회사명',
    card_number  varchar(30)  not null comment '카드 번호',
    valid_thru   varchar(5)   not null comment '유효기간',
    cvc          int(3)       not null comment 'cvc 번호',
    status       bool         not null comment '사용 가능 여부',
    created_at   datetime     not null comment '생성 일시',
    updated_at   datetime     not null comment '수정 일시'
) comment 'cards' charset = utf8mb4;

create index cards_idx01 on cards (card_id);
create index cards_idx02 on cards (card_token);
create index cards_idx03 on cards (created_at);
create index cards_idx04 on cards (updated_at);