create table reviews
(
    review_id       bigint auto_increment primary key comment 'id',
    user_id         bigint       not null comment '리뷰 작성 크리에이터 id',
    title           varchar(255) not null comment '제목',
    content         text         not null comment '내용',
    location        varchar(255) not null comment '여행 지역',
    theme           varchar(255) not null comment '테마',
    comment_count   int          not null comment '댓글 수',
    recommend_count int          not null comment '추천 수',
    report_count    int          not null comment '신고 당한 수',
    created_at      datetime     not null comment '생성 일시',
    updated_at      datetime     not null comment '수정 일시'
) comment 'reviews' charset = utf8mb4;

create index reviews_idx01 on reviews (review_id);
create index reviews_idx02 on reviews (title);
create index reviews_idx04 on reviews (location);
create index reviews_idx05 on reviews (theme);

create table images
(
    image_id  bigint auto_increment primary key comment 'id',
    review_id  bigint       not null comment '리뷰 id',
    image_name varchar(300) not null comment '이미지 이름',
    image_url  varchar(300) not null comment '이미지 링크',
    created_at datetime     not null comment '생성 일시',
    updated_at datetime     not null comment '수정 일시'
) comment 'images' charset = utf8mb4;

create index images_idx01 on images (image_id);
create index images_idx02 on images (review_id);

create table review_comments
(
    review_comment_id bigint auto_increment primary key comment 'id',
    review_id         bigint       not null comment '댓글 작성한 리뷰글 id',
    user_id           bigint       not null comment '댓글 작성한 유저 id',
    content           varchar(300) not null comment '댓글 내용',
    recommend_count   int          not null comment '추천 수',
    report_count      int          not null comment '신고 당한 수',
    created_at        datetime     not null comment '생성 일시',
    updated_at        datetime     not null comment '수정 일시'
) comment 'review_comments' charset = utf8mb4;

create index review_comments_idx01 on review_comments (review_id);

create table recommend_reviews
(
    recommend_review_id bigint auto_increment primary key comment 'id',
    user_id             bigint   not null comment '추천 한 유저 id',
    review_id           bigint   not null comment '추천 한 리뷰 id',
    created_at          datetime not null comment '생성 일시',
    updated_at          datetime not null comment '수정 일시'
) comment 'recommend_reviews' charset = utf8mb4;

create index recommend_reviews_idx01 on recommend_reviews (recommend_review_id);
create index recommend_reviews_idx02 on recommend_reviews (user_id);
create index recommend_reviews_idx03 on recommend_reviews (review_id);

create table report_reviews
(
    report_review_id bigint auto_increment primary key comment 'id',
    user_id          bigint       not null comment '신고 한 유저 id',
    review_id        bigint       not null comment '신고 한 리뷰 id',
    reason           varchar(300) not null comment '신고 사유',
    created_at       datetime     not null comment '생성 일시',
    updated_at       datetime     not null comment '수정 일시'
) comment 'report_reviews' charset = utf8mb4;

create table recommend_comments
(
    recommend_comment_id bigint auto_increment primary key comment 'id',
    user_id              bigint   not null comment '추천 한 유저 id',
    comment_id           bigint   not null comment '추천 한 댓글 id',
    created_at           datetime not null comment '생성 일시',
    updated_at           datetime not null comment '수정 일시'
) comment 'recommend_comments' charset = utf8mb4;

create table report_comments
(
    report_comment_id bigint auto_increment primary key comment 'id',
    user_id           bigint       not null comment '신고 한 유저 id',
    comment_id        bigint       not null comment '신고 한 댓글 id',
    reason            varchar(300) not null comment '신고 사유',
    created_at        datetime     not null comment '생성 일시',
    updated_at        datetime     not null comment '수정 일시'
) comment 'report_comments' charset = utf8mb4;