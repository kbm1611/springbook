INSERT INTO article (title, content, create_at, update_at, views) VALUES ('제목 1', '내용 1', NOW(), NOW(), 12);
INSERT INTO article (title, content, create_at, update_at, views) VALUES ('제목 2', '내용 2', NOW(), NOW(), 10);
INSERT INTO article (title, content, create_at, update_at, views) VALUES ('제목 3', '내용 3', NOW(), NOW(), 3);

INSERT INTO reply (content, create_at, aid) VALUES ('댓글 1', NOW(), 1);
INSERT INTO reply (content, create_at, aid) VALUES ('댓글 2', NOW(), 1);
INSERT INTO reply (content, create_at, aid) VALUES ('댓글 3', NOW(), 2);