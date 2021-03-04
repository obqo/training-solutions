CREATE TABLE cities (city_id BIGINT AUTO_INCREMENT,
                     zip CHAR(4) NOT NULL,
                     city VARCHAR(40) NOT NULL,
                     PRIMARY KEY (city_id));

CREATE TABLE citizens (citizen_id BIGINT AUTO_INCREMENT,
                       citizen_name VARCHAR(200) NOT NULL,
                       zip CHAR(4) NOT NULL,
                       age BIGINT NOT NULL,
                       email VARCHAR(200),
                       ssn VARCHAR(10),
                       number_of_vaccination BIGINT,
                       last_vaccination DATETIME,
                       PRIMARY KEY (citizen_id));

CREATE TABLE vaccinations (vaccination_id BIGINT AUTO_INCREMENT,
                           citizen_id BIGINT NOT NULL,
                           vaccination_date DATETIME NOT NULL,
                           status VARCHAR(10),
                           note VARCHAR(200),
                           vaccination_type VARCHAR(20),
                           PRIMARY KEY (vaccination_id),
                           FOREIGN KEY (citizen_id) REFERENCES citizens(citizen_id));

LOAD DATA LOW_PRIORITY LOCAL INFILE 'src/main/java/covid/iranyitoszamok-varosok.csv' REPLACE INTO TABLE `covid`.`cities` CHARACTER SET utf8 FIELDS TERMINATED BY ';' ENCLOSED BY '"' ESCAPED BY '"' LINES TERMINATED BY '\r\n' IGNORE 1 LINES (`zip`, `city`, @dummy);
--LOAD DATA LOW_PRIORITY LOCAL INFILE 'src/main/java/covid/registered_persons.csv' REPLACE INTO TABLE `covid`.`citizens` CHARACTER SET utf8 FIELDS TERMINATED BY ';' ENCLOSED BY '"' ESCAPED BY '"' LINES TERMINATED BY '\r\n' IGNORE 1 LINES (`citizen_name`, `zip`, `age`, `email`, `ssn`);