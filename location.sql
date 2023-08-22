
CREATE DATABASE location;

CREATE TABLE public."user" (
	id integer NOT NULL GENERATED ALWAYS AS IDENTITY ,
	name varchar,
	email varchar,
	password varchar,
	CONSTRAINT user_pk PRIMARY KEY (id)
);

ALTER TABLE public."user" OWNER TO postgres;

CREATE TABLE public.payment (
	id integer NOT NULL GENERATED ALWAYS AS IDENTITY ,
	"paye" boolean,
	method varchar,
	id_reservation integer,
	CONSTRAINT payment_pk PRIMARY KEY (id)
);

ALTER TABLE public.payment OWNER TO postgres;

CREATE TABLE public.reservation (
	id integer NOT NULL GENERATED ALWAYS AS IDENTITY ,
	start_date date,
	end_date date,
	id_user integer,
	CONSTRAINT reservation_pk PRIMARY KEY (id)
);

ALTER TABLE public.reservation OWNER TO postgres;

CREATE TABLE public.offers (
	id integer NOT NULL GENERATED ALWAYS AS IDENTITY ,
	city varchar(100),
	number_of_room integer,
	wc_intern boolean,
	douche_intern boolean,
	price varchar,
	is_active boolean,
	CONSTRAINT offers_pk PRIMARY KEY (id)
);

ALTER TABLE public.offers OWNER TO postgres;

CREATE TABLE public.features (
	id integer NOT NULL GENERATED ALWAYS AS IDENTITY ,
	description varchar,
	CONSTRAINT features_pk PRIMARY KEY (id)
);

ALTER TABLE public.features OWNER TO postgres;

ALTER TABLE public.reservation ADD CONSTRAINT user_fk FOREIGN KEY (id_user)
REFERENCES public."user" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.payment ADD CONSTRAINT reservation_fk FOREIGN KEY (id_reservation)
REFERENCES public.reservation (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public.has_offers (
	id_reservation integer NOT NULL,
	id_offers integer NOT NULL,
	CONSTRAINT has_offers_pk PRIMARY KEY (id_reservation,id_offers)
);

ALTER TABLE public.has_offers ADD CONSTRAINT reservation_fk FOREIGN KEY (id_reservation)
REFERENCES public.reservation (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE public.has_offers ADD CONSTRAINT offers_fk FOREIGN KEY (id_offers)
REFERENCES public.offers (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

CREATE TABLE public.has_features (
	id_offers integer NOT NULL,
	id_features integer NOT NULL,
	CONSTRAINT has_features_pk PRIMARY KEY (id_offers,id_features)
);

ALTER TABLE public.has_features ADD CONSTRAINT offers_fk FOREIGN KEY (id_offers)
REFERENCES public.offers (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE public.has_features ADD CONSTRAINT features_fk FOREIGN KEY (id_features)
REFERENCES public.features (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
