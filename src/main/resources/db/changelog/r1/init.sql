create table research_worker
(
    id                uuid      NOT NULL PRIMARY KEY,
    created_time      timestamp NOT NULL DEFAULT now(),
    updated_time      timestamp NOT NULL DEFAULT now(),
    email             varchar   NOT NULL unique,
    password          varchar   NOT NULL,
    first_name_rus    varchar,
    second_name_rus   varchar,
    last_name_rus     varchar,
    first_name_eng    varchar,
    second_name_eng   varchar,
    last_name_eng     varchar,
    date_of_birth     date,
    snils             varchar(16),
    scientific_role   varchar,
    supervisor        varchar,
    cours             int,
    class             varchar(50),
    date_of_study_end date,
    id_rinc           varchar,
    id_orcid          varchar,
    id_scopus         varchar,
    id_researcher     varchar,
    id_colab          varchar
);