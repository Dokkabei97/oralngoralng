create table creator_reviews
(
    creator_review_id bigint auto_increment primary key comment 'id',
    user_id           bigint       not null comment '리뷰 작성 크리에이터',
    title             varchar(255) not null comment '제목',
    content           text         not null comment '내용',
    comment_count     int          not null comment '댓글 수',
    recommend_count   int          not null comment '추천 수',
    report_count      int          not null comment '신고 당한 수',
    created_at        datetime     not null comment '생성 일시',
    updated_at        datetime     not null comment '수정 일시'
) comment 'reviews' charset = utf8mb4;

create table user_reviews
(
    user_review_id  bigint auto_increment primary key comment 'id',
    user_id         bigint       not null comment '리뷰 작성 유저',
    title           varchar(255) not null comment '제목',
    content         text         not null comment '내용',
    comment_count   int          not null comment '댓글 수',
    recommend_count int          not null comment '추천 수',
    report_count    int          not null comment '신고 당한 수',
    created_at      datetime     not null comment '생성 일시',
    updated_at      datetime     not null comment '수정 일시'
) comment 'user_reviews' charset = utf8mb4;