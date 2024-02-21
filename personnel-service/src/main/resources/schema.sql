CREATE TABLE IF NOT EXISTS employees (
     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     first_name VARCHAR(50) NOT NULL,
     last_name VARCHAR(50) NOT NULL,
     middle_name VARCHAR(50),
     phone_number VARCHAR(20) UNIQUE,
     email VARCHAR(60) UNIQUE
);

CREATE TABLE IF NOT EXISTS job_titles (
     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     title VARCHAR(60) NOT NULL,
     description TEXT,
     position VARCHAR(30) NOT NULL
);

