INSERT INTO raw_products (
    name, food_group, consignment, shelf_life,
    count, is_piece_product, is_in_good_condition)
VALUES
    ('Говядина', 'Мясо и мясопродукты', '12', 90, 2.83, 0, DEFAULT),
    ('Помидоры', 'Овощи', '14', 90, 1.2, 0, DEFAULT),
    ('Огурцы', 'Овощи', '14', 90, 4.5, 0, DEFAULT),
    ('Подсолнечное масло', 'Растительные масла', '14', 90, 3, 1, DEFAULT),
    ('Сыр моцарелла', 'Молоко и молочные продукты', '12', 90, 2.4, 1, DEFAULT),
    ('Сливочное масло 82,5%', 'Молоко и молочные продукты', '10', 90, 1.52, 1, 1);

INSERT INTO semi_finished_products (
    name, count, shelf_life, date_of_manufacture)
VALUES
    ('Овощи пассерованные', 6.87, 36, NOW()),
    ('Пюре картофельное', 8.5, 24, NOW()),
    ('Каша рассыпчатая (рисовая)', 4.29, 24, NOW());
