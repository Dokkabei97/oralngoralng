create table orders
(
    order_id              bigint auto_increment primary key comment 'id',
    order_token           varchar(255) not null comment 'order_token',
    user_id               bigint       not null comment '주문한 유저',
    product_id            bigint       not null comment '주문한 상품',
    card_id               bigint       null comment '주문에 사용한 카드',
    price                 int          not null comment '결제 금액',
    pay_method            varchar(50) comment '결제 수단',
    billing_key           varchar(50) comment '결제 키',
    order_at              datetime     not null comment '주문 일시',
    expiration_product_at datetime     null comment '상품 만료 일시',
    next_payment_at       datetime     null comment '다음 결제 일시',
    successed_at          datetime     null comment '결제 성공 일시',
    result_status         varchar(30)  null comment '결제 결과 상태',
    result_message        varchar(255) null comment '결제 메시지',
    created_at            datetime     not null comment '생성 일시',
    updated_at            datetime     not null comment '수정 일시'
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
    card_id        bigint       null comment '환불에 사용한 카드',
    price          int          not null comment '환불 금액',
    pay_method     varchar(50)  null comment '결제 수단',
    successed_at   datetime     null comment '환불 성공 일시',
    result_status  varchar(30)  null comment '환불 결과 상태',
    result_message varchar(255) null comment '환불 메시지',
    created_at     datetime     not null comment '생성 일시',
    updated_at     datetime     not null comment '수정 일시'
) comment 'refunds' charset = utf8mb4;

create index refunds_idx01 on refunds (refund_id);
create index refunds_idx02 on refunds (refund_token);
create index refunds_idx03 on refunds (user_id);
create index refunds_idx04 on refunds (created_at);

create table products
(
    product_id      bigint auto_increment primary key comment 'id',
    name            varchar(100) not null comment '상품 이름',
    price           int          not null comment '상품 금액',
    duration        varchar(50)  not null comment '상품 기간',
    membership_name varchar(255) not null comment '멤버쉽 이름',
    created_at      datetime     not null comment '생성 일시',
    updated_at      datetime     not null comment '수정 일시'
) comment 'products' charset = utf8mb4;

create index products_idx01 on products (product_id);
create index products_idx02 on products (membership_name);
create index products_idx03 on products (created_at);

create table memberships
(
    membership_id bigint auto_increment primary key comment 'id',
    name          varchar(255) not null comment '멤버쉽 이름',
    description   varchar(500) not null comment '멤버쉽 설명',
    price         int          not null comment '멤버쉽 가격'
) comment 'memberships' charset = utf8mb4;

create index memberships_idx01 on memberships (membership_id);
create index memberships_idx02 on memberships (name);