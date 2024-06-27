INSERT INTO address (city, street, zip)
VALUES ('Hanoi', '123 Streets', '100000'),
       ('Ho Chi Minh', '456 District 1', '700000');

INSERT INTO category (name)
VALUES ('Electronics'),
       ('Books');

INSERT INTO user (email, first_name, last_name, password, address_id)
VALUES ('user1@test.com', 'John', 'Doe', 'password1', 1),
       ('user2@test.com', 'Jane', 'Doe', 'password2', 2);

INSERT INTO product (name, price, rating, category_id)
VALUES ('Laptop', 1200.00, 4.5, 1),
       ('Smartphone', 800.00, 4.7, 1),
       ('E-Reader', 150.00, 4.2, 2),
       ('Programming Book', 45.00, 4.8, 2),
       ('Science Fiction Book', 60.00, 4.9, 2);

INSERT INTO review (comment, product_id, user_id)
VALUES ('Great laptop!', 1, 1),
       ('Love this phone', 2, 1),
       ('E-reader is okay', 3, 2),
       ('Very informative', 4, 2),
       ('Fantastic read', 5, 1);