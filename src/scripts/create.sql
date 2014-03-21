CREATE TABLE stocks.portfolio (
  id INT NOT NULL auto_increment,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=INNODB;

CREATE TABLE stocks.stock (
  id INT NOT NULL,
  symbol VARCHAR(10) NOT NULL,
  entryDate DATE,
  exitDate DATE,
  costPrice DECIMAL,
  exitPrice DECIMAL,
  commission DECIMAL,
  portfolioId INT NOT NULL,
  INDEX portfolioId_index (portfolioId),
  FOREIGN KEY (portfolioId) REFERENCES portfolio(id) ON DELETE CASCADE
) ENGINE=INNODB;

