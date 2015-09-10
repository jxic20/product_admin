create table product(   
    product_ID integer not null,
    name varchar not null,
    description varchar,
    category varchar,
    price decimal(12,2),
    stock_quantity integer,
    
    constraint pk_product primary key (product_ID)
);

create table Customer(   
    customer_ID varchar not null,
    name varchar not null,
    email varchar,
    address varchar,
    credit_card integer not null,
    password varchar not null,
    
    constraint pk_customer primary key (customer_ID)
);