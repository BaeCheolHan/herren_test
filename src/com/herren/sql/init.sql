CREATE TABLE midterm (

    id         BIGINT AUTO_INCREMENT COMMENT 'id' PRIMARY KEY,

    name       VARCHAR(45) NOT NULL COMMENT '이름',

    subject    VARCHAR(45) NOT NULL COMMENT '과목명',

    score      INTEGER     NOT NULL COMMENT '점수',

    created_at DATETIME    NOT NULL COMMENT '생성일시',

    updated_at DATETIME    NULL COMMENT '수정일시'

)

    COMMENT '성적 정보';

insert into midterm(id, name, subject, score, updated_at, created_at) values(1, '여우', '수학', 50, now(), now());

insert into midterm(id, name, subject, score, updated_at, created_at) values(2, '늑대', '수학', 80, now(), now());

insert into midterm(id, name, subject, score, updated_at, created_at) values(3, '돼지', '수학', 70, now(), now());

insert into midterm(id, name, subject, score, updated_at, created_at) values(4, '여우', '국어', 75, now(), now());

insert into midterm(id, name, subject, score, updated_at, created_at) values(5, '늑대', '국어', 80, now(), now());

insert into midterm(id, name, subject, score, updated_at, created_at) values(6, '돼지', '국어', 92, now(), now());

insert into midterm(id, name, subject, score, updated_at, created_at) values(7, '여우', '영어', 98, now(), now());

insert into midterm(id, name, subject, score, updated_at, created_at) values(8, '늑대', '영어', 60, now(), now());

insert into midterm(id, name, subject, score, updated_at, created_at) values(9, '돼지', '영어', 55, now(), now());
