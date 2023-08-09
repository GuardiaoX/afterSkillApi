-- public.skill definition

-- Drop table

-- DROP TABLE public.skill;

CREATE TABLE public.skill (
	sk_cd_id bigserial NOT NULL,
	sk_tx_desc varchar(255) NULL,
	sk_tx_name varchar(255) NULL,
	sk_tx_photo varchar(255) NULL,
	CONSTRAINT skill_pkey PRIMARY KEY (sk_cd_id)
);


-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	id serial4 NOT NULL,
	username varchar(20) NULL,
	email varchar(50) NULL,
	"password" varchar(120) NULL,
	CONSTRAINT uk6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email),
	CONSTRAINT ukr43af9ap4edm43mmtq01oddj6 UNIQUE (username),
	CONSTRAINT users_pkey PRIMARY KEY (id)
);


-- public.roles definition

-- Drop table

-- DROP TABLE public.roles;

CREATE TABLE public.roles (
	id serial4 NOT NULL,
	"name" varchar(20) NULL,
	CONSTRAINT roles_name_check CHECK (((name)::text = ANY ((ARRAY['ROLE_USER'::character varying, 'ROLE_MODERATOR'::character varying, 'ROLE_ADMIN'::character varying])::text[]))),
	CONSTRAINT roles_pkey PRIMARY KEY (id)
);


-- public.profile_skill definition

-- Drop table

-- DROP TABLE public.profile_skill;

CREATE TABLE public.profile_skill (
	fk_user_cd_id int4 NULL,
	prof_sk_nm_level int4 NULL,
	fk_sk_cd_id int8 NULL,
	id bigserial NOT NULL,
	CONSTRAINT profile_skill_pkey PRIMARY KEY (id),
	CONSTRAINT fk40h474wy6a5cae5yw70kquc6v FOREIGN KEY (fk_user_cd_id) REFERENCES public.users(id),
	CONSTRAINT fkcbaq7f7tcujs1pvq3jfmbgytf FOREIGN KEY (fk_sk_cd_id) REFERENCES public.skill(sk_cd_id)
);


-- public.user_roles definition

-- Drop table

-- DROP TABLE public.user_roles;

CREATE TABLE public.user_roles (
	role_id int4 NOT NULL,
	user_id int4 NOT NULL,
	CONSTRAINT user_roles_pkey PRIMARY KEY (role_id, user_id),
	CONSTRAINT fkh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id) REFERENCES public.roles(id),
	CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES public.users(id)
);