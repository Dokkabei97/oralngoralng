create table users
(
    user_id    bigint auto_increment primary key comment 'id',
    user_token varchar(255) not null comment 'user_token',
    nickname   varchar(12)  not null comment '닉네임',
    email      varchar(50)  not null comment '이메일',
    status     varchar(10)  not null comment '상태',
    created_at datetime     not null comment '생성 일시',
    updated_at datetime     not null comment '수정 일시'
) comment 'users' charset = utf8mb4;

create index users_idx01 on users (user_id);
create index users_idx02 on users (user_token);
create index users_idx03 on users (created_at);
create index users_idx04 on users (updated_at);

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

create table orders
(
    order_id       bigint auto_increment primary key comment 'id',
    order_token    varchar(255) not null comment 'order_token',
    user_id        bigint       not null comment '주문한 유저',
    product_id     bigint       not null comment '주문한 상품',
    card_id        bigint       not null comment '주문에 사용한 카드',
    price          int          not null comment '결제 금액',
    pay_type       varchar(50)  not null comment '결제 타입',
    billing_key    varchar(50)  not null comment '결제 키',
    successed_at   datetime     not null comment '성공 일',
    expiration_at  datetime     not null comment '만료 일',
    next_order_at  datetime     not null comment '다음 결제 일',
    created_at     datetime     not null comment '생성 일시',
    updated_at     datetime     not null comment '수정 일시',
    result_status  varchar(30)  not null comment '결제 결과 상태',
    result_message varchar(255) not null comment '결제 메시지'
) comment 'orders' charset = utf8mb4;

create index orders_idx01 on orders (order_id);
create index orders_idx02 on orders (order_token);
create index orders_idx03 on orders (user_id);
create index orders_idx04 on orders (billing_key);
create index orders_idx05 on orders (created_at);

create table refunds
(
    refund_id      bigint auto_increment primary key comment 'id',
    refund_token   varchar(255) not null comment 'refund_token',
    user_id        bigint       not null comment '환불한 유저',
    product_id     bigint       not null comment '환불한 상품',
    card_id        bigint       not null comment '환불에 사용한 카드',
    price          int          not null comment '환불 금액',
    successed_at   datetime     not null comment '성공 일',
    created_at     datetime     not null comment '생성 일시',
    updated_at     datetime     not null comment '수정 일시',
    result_status  varchar(30)  not null comment '환불 결과 상태',
    result_message varchar(255) not null comment '환불 메시지'
) comment 'refunds' charset = utf8mb4;

create index refunds_idx01 on refunds (refund_id);
create index refunds_idx02 on refunds (refund_token);
create index refunds_idx03 on refunds (user_id);
create index refunds_idx04 on refunds (created_at);

create table products
(
    product_id    bigint auto_increment primary key comment 'id',
    product_token varchar(255) not null comment 'product_token',
    price         int          not null comment '상품 금액',
    duration      varchar      not null comment '상품 기간',
    created_at    datetime     not null comment '생성 일시',
    updated_at    datetime     not null comment '수정 일시'
) comment 'products' charset = utf8mb4;

create index products_idx01 on products (product_id);
create index products_idx01 on products (product_token);
create index products_idx01 on products (created_at);

create table memberships
(
    membership_id bigint auto_increment primary key comment 'id',
    name          varchar(255) not null comment '멤버쉽 이름',
    description   varchar(500) not null comment '멤버쉽 설명'
) comment 'memberships' charset = utf8mb4;

create index memberships_idx01 on memberships (membership_id);
create index memberships_idx02 on memberships (name);

create table tour_reviews
(
    tour_review_id    bigint auto_increment primary key comment 'id',
    tour_review_token varchar(255) not null comment 'tour_review_token',
    user_id           bigint       not null comment '리뷰 작성한 유저',
    title varchar(50) not null comment '리뷰 제목',
    description   varchar(2000) not null comment '리뷰 내용',
    image_name varchar(2000) null comment '사진 이름',
    likes_count int null comment '좋아요 수',
    hits_count int null comment '조회 수',
    created_at    datetime     not null comment '생성 일시',
    updated_at    datetime     not null comment '수정 일시'
) comment 'tour_reviews' charset = utf8mb4;

create index tour_reviews_idx01 on tour_reviews (tour_review_id);
create index tour_reviews_idx02 on tour_reviews (user_id);
create index tour_reviews_idx03 on tour_reviews (title);
create index tour_reviews_idx04 on tour_reviews (likes_count);
create index tour_reviews_idx05 on tour_reviews (created_at);