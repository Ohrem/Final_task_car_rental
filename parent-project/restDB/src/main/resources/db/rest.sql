create table if not exists `rest`
(
    `id`       integer primary key,
    `name`     varchar(64) null,
    `surname`  varchar(64) null,
    `email`    varchar(64) null,
    `password` varchar(64) null
    );