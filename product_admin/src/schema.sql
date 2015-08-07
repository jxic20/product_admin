create table product(   
    product_ID integer not null,
    name varchar not null,
    description varchar,
    category varchar,
    price decimal(12,2),
    stock_quantity integer,
    
    constraint pk_product primary key (product_ID)
);
