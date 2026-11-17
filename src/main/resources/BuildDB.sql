USE ebdb;

DROP TABLE IF EXISTS quote_category;
DROP TABLE IF EXISTS quotes;
DROP TABLE IF EXISTS categories;

CREATE TABLE quotes (
                        quote_id INT NOT NULL AUTO_INCREMENT,
                        quote TEXT NOT NULL,
                        author VARCHAR(255),
                        PRIMARY KEY (quote_id)
);

CREATE TABLE categories (
                            category_id INT NOT NULL AUTO_INCREMENT,
                            category VARCHAR(100) NOT NULL,
                            PRIMARY KEY (category_id)
);

CREATE TABLE quote_category (
                                quote_category_id INT NOT NULL AUTO_INCREMENT,
                                quote_id INT NOT NULL,
                                category_id INT NOT NULL,
                                PRIMARY KEY (quote_category_id),
                                UNIQUE (quote_id, category_id),
                                FOREIGN KEY (quote_id) REFERENCES quotes (quote_id),
                                FOREIGN KEY (category_id) REFERENCES categories (category_id)
);