create table creator_reviews
(
    creator_review_id bigint auto_increment primary key comment 'id',
    user_id           bigint       not null comment '리뷰 작성 크리에이터',
    title             varchar(255) not null comment '제목',
    content           text         not null comment '내용',
    category          varchar(255) not null comment '카테고리',
    location          varchar(255) not null comment '여행 지역',
    theme             varchar(255) not null comment '테마',
    comment_count     int          not null comment '댓글 수',
    recommend_count   int          not null comment '추천 수',
    report_count      int          not null comment '신고 당한 수',
    created_at        datetime     not null comment '생성 일시',
    updated_at        datetime     not null comment '수정 일시'
) comment 'reviews' charset = utf8mb4;

create index creator_reviews_idx01 on creator_reviews (creator_review_id);
create index creator_reviews_idx02 on creator_reviews (title);
create index creator_reviews_idx03 on creator_reviews (category);
create index creator_reviews_idx04 on creator_reviews (location);
create index creator_reviews_idx05 on creator_reviews (theme);

create table creator_review_comments
(
    creator_review_comment_id bigint auto_increment primary key comment 'id',
    creator_review_id         bigint       not null comment '댓글 작성한 리뷰글',
    user_id                   bigint       not null comment '댓글 작성자',
    content                   varchar(300) not null comment '댓글 내용',
    recommend_count           int          not null comment '추천 수',
    report_count              int          not null comment '신고 당한 수',
    created_at                datetime     not null comment '생성 일시',
    updated_at                datetime     not null comment '수정 일시'
)

