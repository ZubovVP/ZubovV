CREATE TABLE users(
id SERIAL PRIMARY KEY,
name VARCHAR(35) NOT NULL,
date TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);
