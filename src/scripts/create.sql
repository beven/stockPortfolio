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
  costPrice DECIMAL,
  exitPrice DECIMAL,
  commission DECIMAL,
  portfolioId INT,
  PRIMARY KEY (id),
  FOREIGN KEY (portfolioId) REFERENCES parent(id) ON DELETE  CASCADE
) ENGINE=INNODB;

