CREATE TABLE flights (
ID BIGINT PRIMARY KEY AUTO_INCREMENT,
departure_time TIMESTAMP,
arrival_time TIMESTAMP,
departure_place VARCHAR(255) NOT NULL,
arrival_place VARCHAR(255) NOT NULL,
basic_price DECIMAL(10,1) NOT NULL
)