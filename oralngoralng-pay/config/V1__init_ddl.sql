create table pays
(
    pay_id      bigint auto_increment primary key comment 'id',
    order_token varchar(255) not null comment 'order_token',
    user_id     bigint       not null comment '주문한 유저',
    product_id  bigint       not null comment '주문한 상품',
    price       int          not null comment '결제 금액',
    pay_method  varchar(50)  not null comment '결제 수단',
    billing_key varchar(50)  null comment '결제 키',
    created_at  datetime     not null comment '생성 일시',
    updated_at  datetime     not null comment '수정 일시',
    deleted_at  datetime     null comment '삭제 일시'
) comment 'pays' charset = utf8mb4;

create index pays_idx01 on pays (pay_id);
create index pays_idx02 on pays (user_id);
create index pays_idx03 on pays (pay_method);