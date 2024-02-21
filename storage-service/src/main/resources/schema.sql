CREATE TABLE IF NOT EXISTS raw_products (
     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(100) NOT NULL,
     food_group VARCHAR(100),
     consignment VARCHAR(30),
     shelf_life INT,
     count DECIMAL(6, 3),
     is_piece_product BOOL,
     is_in_good_condition BOOL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS semi_finished_products (
     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(150) NOT NULL,
     count DECIMAL(6, 3),
     shelf_life INT,
     date_of_manufacture TIMESTAMP
);
