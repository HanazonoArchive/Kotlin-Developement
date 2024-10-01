-- Create the database
CREATE DATABASE IF NOT EXISTS card_collection_db;

-- Use the newly created database
USE card_collection_db;

-- Create the cards table
CREATE TABLE IF NOT EXISTS cards (
                                     id INT(11) NOT NULL AUTO_INCREMENT,
    serial_number VARCHAR(50) NOT NULL,
    grading VARCHAR(10) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
    );
