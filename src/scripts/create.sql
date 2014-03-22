CREATE DATABASE IF NOT EXISTS stocks /*!40100 DEFAULT CHARACTER SET latin1 */;
USE stocks;

CREATE TABLE stocks.portfolio (
  id INT NOT NULL auto_increment,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=INNODB;

CREATE TABLE stocks.stock (
  id INT NOT NULL auto_increment,
  symbol VARCHAR(10) NOT NULL,
  entryDate DATE,
  exitDate DATE,
  purchasePrice FLOAT,
  exitPrice FLOAT,
  commission FLOAT,
  portfolioId INT NOT NULL,
  PRIMARY KEY (id),
  INDEX portfolioId_index (portfolioId),
  FOREIGN KEY (portfolioId) REFERENCES portfolio(id) ON DELETE CASCADE
) ENGINE=INNODB;

