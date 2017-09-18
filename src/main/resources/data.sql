INSERT IGNORE INTO Categories (code, name) VALUES
  ('PIZZA', 'Food'),
  ('DRINK', 'Drink'),
  ('DESSERT', 'Dessert');

INSERT IGNORE INTO Products (code, name, category_id) VALUES
('Pizza Margherita','MARGHERITA', (SELECT id from categories WHERE code = 'PIZZA')),
('Pizza Margherita con Bufala','BUFALA', (SELECT id from categories WHERE code = 'PIZZA')),
('Pizza Crudo e Bufala','CRUDBUFALA', (SELECT id from categories WHERE code = 'PIZZA')),
('Pizza con Salsiccia e Friarielli','SALSFRIARIELLI', (SELECT id from categories WHERE code = 'PIZZA')),
('Coca Cola', 'COCACOLA', (SELECT id from categories WHERE code = 'DRINK')),
 ('Cheesecake','CHEESECAKE', (SELECT id from categories WHERE code = 'DESSERT')),
 ('Tiramisu','TIRAMISU', (SELECT id from categories WHERE code = 'DESSERT'));


INSERT IGNORE INTO ingredients (code, name, category_id) VALUES
  ('MOZZARELLA', 'Mozzarella', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('POMODORO', 'Pomodoro', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('PATATAFRITTA', 'Patata Fritta', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('PROSCIUTTOCOTTO', 'Prosciutto Cotto', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('CARCIOFINI', 'Carciofini', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('FARINADIGRANO', 'Farina Di Grano', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('FARINADIKAMUT', 'Farina Di Kamut', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('OLIVENERE', 'OliveNere', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('OLIVENERE', 'OliveVerdi', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('UOVASODE', 'Uova Sode', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('TIRAMISU', 'Tiramisù', (SELECT id FROM Categories WHERE code = 'DESSERT')),
  ('PANNACOTTA', 'Panna Cotta', (SELECT id FROM Categories WHERE code = 'DESSERT')),
  ('YOGURT', 'Yogurt', (SELECT id FROM Categories WHERE code = 'DESSERT')),
  ('MACEDONIA', 'Macedonia Di Frutta Stagionale', (SELECT id FROM Categories WHERE code = 'DESSERT')),
  ('COCACOLA', 'CocaCola', (SELECT id FROM Categories WHERE code = 'DRINK')),
  ('ACQUA', 'Acqua', (SELECT id FROM Categories WHERE code = 'DRINK')),
  ('FANTA', 'Fanta', (SELECT id FROM Categories WHERE code = 'DRINK')),
  ('SPRITE', 'Sprite', (SELECT id FROM Categories WHERE code = 'DRINK')),
  ('GINGER', 'Ginger', (SELECT id FROM Categories WHERE code = 'DRINK')),
  ('BIRRA', 'Birra', (SELECT id FROM Categories WHERE code = 'DRINK'));




INSERT IGNORE INTO Restaurants (code) VALUES
  ('BOSCHESE'),
  ('FIOPIZZA'),
  ('ANTICOCASOLARE'),
  ('CAPINERA'),
  ('LANUOVAFAZENDA'),
  ('OASI');

INSERT IGNORE INTO Address_Restaurants(phone_number,email,city, street, zip_code, restaurant_id) VALUES
  ('0721457878','boschese@gmail.com','Vallefoglia', 'Via Nazionale, 77', '61022', (SELECT id from Restaurants WHERE code = 'BOSCHESE')),
  ('0721457880','fiopizza@gmail.com','Vallefoglia', 'Piazza Rossini, 2', '61022', (SELECT id from Restaurants WHERE code = 'FIOPIZZA')),
  ('0721457812','anticocasolare@gmail.com','Pesaro', 'Via Sant Angelo del Gatto, 11', '61021', (SELECT id from Restaurants WHERE code = 'ANTICOCASOLARE')),
  ('0721457833','capinera@gmail.com','Vallefoglia', 'Via Nazionale Urbinate, 201', '61022', (SELECT id from Restaurants WHERE code = 'CAPINERA')),
  ('0721457435','lanuovafazenda@gmail.com','Vallefoglia', 'Via Valzangona, 31', '61020', (SELECT id from Restaurants WHERE code = 'LANUOVAFAZENDA')),
  ('0721457641','oasi@gmail.com','Vallefoglia', 'Via Del Foglia, 20', '61022', (SELECT id from Restaurants WHERE code = 'OASI'));

-- to do : inserire il nome dei ristoranti

INSERT IGNORE INTO Product_Restaurant(price, product_id, restaurant_id) VALUES
  (5.50, (SELECT id FROM Products WHERE code = 'MARGHERITA'), (SELECT id FROM Restaurants WHERE code = 'BOSCHESE')),
  (5.50, (SELECT id FROM Products WHERE code = 'BUFALA'), (SELECT id FROM Restaurants WHERE code = 'BOSCHESE')),
  (6.50, (SELECT id FROM Products WHERE code = 'CRUDBUFALA'), (SELECT id FROM Restaurants WHERE code = 'BOSCHESE')),
  (5.00, (SELECT id FROM Products WHERE code = 'SALSFRIARIELLI'), (SELECT id FROM Restaurants WHERE code = 'FIOPIZZA')),
  (7.00, (SELECT id FROM Products WHERE code = 'CRUDBUFALA'), (SELECT id FROM Restaurants WHERE code = 'FIOPIZZA')),
  (8.00, (SELECT id FROM Products WHERE code = 'SALSFRIARIELLI'), (SELECT id FROM Restaurants WHERE code = 'FIOPIZZA')),
  (8.50,  (SELECT id FROM Products WHERE code = 'TIRAMISU'), (SELECT id FROM Restaurants WHERE code = 'CAPINERA')),
  (4.50, (SELECT id FROM Products WHERE code = 'TIRAMISU'), (SELECT id FROM Restaurants WHERE code = 'CAPINERA')),
  (6.50, (SELECT id FROM Products WHERE code = 'MARGHERITA'), (SELECT id FROM Restaurants WHERE code = 'CAPINERA')),
  (7.50, (SELECT id FROM Products WHERE code = 'BUFALA'), (SELECT id FROM Restaurants WHERE code = 'CAPINERA')),
  (3.50, (SELECT id FROM Products WHERE code = 'TIRAMISU'), (SELECT id FROM Restaurants WHERE code = 'LANUOVAFAZENDA')),
  (2.50, (SELECT id FROM Products WHERE code = 'CHEESECAKE'), (SELECT id FROM Restaurants WHERE code = 'LANUOVAFAZENDA')),
  (6.50, (SELECT id FROM Products WHERE code = 'MARGHERITA'), (SELECT id FROM Restaurants WHERE code = 'LANUOVAFAZENDA')),
  (7.50, (SELECT id FROM Products WHERE code = 'BUFALA'), (SELECT id FROM Restaurants WHERE code = 'LANUOVAFAZENDA')),
  (8.50, (SELECT id FROM Products WHERE code = 'CRUDBUFALA'), (SELECT id FROM Restaurants WHERE code = 'LANUOVAFAZENDA')),
  (2.50, (SELECT id FROM Products WHERE code = 'CHEESECAKE'), (SELECT id FROM Restaurants WHERE code = 'OASI')),
  (1.50, (SELECT id FROM Products WHERE code = 'TIRAMISU'), (SELECT id FROM Restaurants WHERE code = 'OASI')),
  (6.50, (SELECT id FROM Products WHERE code = 'BUFALA'), (SELECT id FROM Restaurants WHERE code = 'OASI')),
  (7.50, (SELECT id FROM Products WHERE code = 'SALSFRIARIELLI'), (SELECT id FROM Restaurants WHERE code = 'OASI'));

INSERT IGNORE INTO Users(email, first_name, last_name, tax_code) VALUES
  ('martina.g9@hotmail.it', 'Martina', 'Gabellini', 'GBLMTN92D43G479N'),
  ('lamaro@teletu.com', 'Lara', 'Fiorani', 'FRNLRA68C53G479W'),
  ('mattia.gab@live.com', 'Mattia', 'Gabellini', 'GBLMTT97C08G479E'),
  ('roberto.gab@live.com', 'Roberto', 'Gabellini', 'GBLRRT64S04G479R'),
  ('michele.j@hotmail.it', 'Michele', 'Borino', 'BRNMHL83D06A783X'),
  ('sonia.f@hotmail.it', 'Sonia', 'Fratesi', 'FRTSNO92A55G479Z'),
  ('emanuela.m@hotmail.it', 'Emanuela', 'Mignoni', 'MGNMNL92A49G479X'),
  ('giorgi@hotmail.it', 'Giovanni', 'DeCesaris', 'DCSGNN92M25D488Z'),
  ('matteo.b@hotmail.it', 'Matteo', 'Borghi', 'BRGMTT84M08G479Y'),
  ('lorenzo.l@hotmail.it', 'Lorenzo', 'Loppi', 'LPPLNZ93P08G479L'),
  ('francesca.c@hotmail.it', 'Francesca', 'Cangini', 'CNGFNC92P46H294F'),
  ('bionda.c@live.it', 'Margherita', 'Spadoni', 'SPDMGH92C62C357I'),
  ('jason.p@live.it', 'Jason', 'Primavera', 'PRMJSN92D23G479Y'),
  ('matteo.u@live.it', 'Matteo', 'Ulissi', 'LSSMTT92B29G479M');



