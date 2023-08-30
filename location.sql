-- Create the 'location' database
CREATE DATABASE location;

-- Create the 'user' table to store user information
CREATE TABLE "user" (
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    name varchar,
    email varchar,
    password varchar,
    role varchar,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Create the 'payment' table to store payment information
CREATE TABLE payment (
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    paye boolean,
    method varchar,
    id_reservation integer,
    CONSTRAINT payment_pk PRIMARY KEY (id),
    CONSTRAINT reservation_fk FOREIGN KEY (id_reservation)
        REFERENCES reservation (id) MATCH FULL
        ON DELETE SET NULL ON UPDATE CASCADE
);

-- Create the 'reservation' table to store reservation details
CREATE TABLE reservation (
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    start_date date,
    end_date date,
    id_user integer,
    CONSTRAINT reservation_pk PRIMARY KEY (id),
    CONSTRAINT user_fk FOREIGN KEY (id_user)
        REFERENCES "user" (id) MATCH FULL
        ON DELETE SET NULL ON UPDATE CASCADE
);

-- Create the 'offers' table to store property rental offers
CREATE TABLE offers (
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    city varchar(100),
    number_of_room integer,
    wc_intern boolean,
    douche_intern boolean,
    price varchar,
    is_active boolean,
    CONSTRAINT offers_pk PRIMARY KEY (id)
);

-- Create the 'features' table to store property features
CREATE TABLE features (
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    description varchar,
    CONSTRAINT features_pk PRIMARY KEY (id)
);

-- Create the 'has_offers' table to establish a many-to-many relationship between reservations and offers
CREATE TABLE has_offers (
    id_reservation integer NOT NULL,
    id_offers integer NOT NULL,
    CONSTRAINT has_offers_pk PRIMARY KEY (id_reservation, id_offers),
    CONSTRAINT reservation_fk FOREIGN KEY (id_reservation)
        REFERENCES reservation (id) MATCH FULL
        ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT offers_fk FOREIGN KEY (id_offers)
        REFERENCES offers (id) MATCH FULL
        ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Create the 'has_features' table to establish a many-to-many relationship between offers and features
CREATE TABLE has_features (
    id_offers integer NOT NULL,
    id_features integer NOT NULL,
    CONSTRAINT has_features_pk PRIMARY KEY (id_offers, id_features),
    CONSTRAINT offers_fk FOREIGN KEY (id_offers)
        REFERENCES offers (id) MATCH FULL
        ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT features_fk FOREIGN KEY (id_features)
        REFERENCES features (id) MATCH FULL
        ON DELETE RESTRICT ON UPDATE CASCADE
);
