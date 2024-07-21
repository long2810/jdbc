DROP TABLE IF EXISTS article;

CREATE TABLE article (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT,
    content TEXT
);

--article 테이블에 데이터를 추가하는 SQL