CREATE DATABASE IF NOT EXISTS random_quote_generator_test;
USE random_quote_generator_test;

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
                            description TEXT,
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

INSERT INTO quotes (quote_id, quote, author) VALUES
                                                 (1, 'Small steps lead to big changes.', NULL),
                                                 (2, 'I put my to-do list on my to-do list.', NULL),
                                                 (3, 'Progress takes practice.', NULL);

INSERT INTO categories (category_id, category, description) VALUES
                                                                (1, 'Motivation', 'Quotes about getting started and keeping going.'),
                                                                (2, 'Success', 'Quotes about progress and achievement.'),
                                                                (3, 'Humor', 'Quotes meant to make you laugh.');

INSERT INTO quote_category (quote_category_id, quote_id, category_id) VALUES
                                                                          (1, 1, 1),
                                                                          (2, 1, 2),
                                                                          (3, 2, 3),
                                                                          (4, 3, 1);