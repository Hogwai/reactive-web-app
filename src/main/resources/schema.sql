CREATE TABLE post (
  id SERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  content TEXT NOT NULL,
  published_at DATETIME NOT NULL,
  author VARCHAR(255) NOT NULL,
  likes INT NOT NULL
);
