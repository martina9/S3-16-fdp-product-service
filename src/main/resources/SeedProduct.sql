INSERT IGNORE INTO Categories (code, name) VALUES
  ('FOOD', 'Food'),
  ('DRINK', 'Drink'),
  ('DESSERT', 'Dessert');

INSERT IGNORE INTO Products (code, category_id) VALUES
('Pizza', (SELECT id from categories WHERE code = 'FOOD')),
('Patate', (SELECT id from categories WHERE code = 'FOOD')),
('Bevande', (SELECT id from categories WHERE code = 'DRINK')),
 ('Dolce', (SELECT id from categories WHERE code = 'DESSERT'));

INSERT IGNORE INTO Address_Restaurants(city, street, zipcode, restaurant_id) VALUES
  ('Vallefoglia', 'Via Nazionale, 77', '61022', (SELECT id from Address_Restaurants WHERE code = 'BOSCHESE')),
  ('Vallefoglia', 'Piazza Rossini, 2', '61022', (SELECT id from Address_Restaurants WHERE code = 'FIOPIZZA')),
  ('Pesaro', 'Via Sant Angelo del Gatto, 11', '6110', (SELECT id from Address_Restaurants WHERE code = 'ANTICOCASOLARE')),
  ('Vallefoglia', 'Via Nazionale Urbinate, 201', '61022', (SELECT id from Address_Restaurants WHERE code = 'CAPINERA')),
  ('Vallefoglia', 'Via Valzangona, 31', '61020', (SELECT id from Address_Restaurants WHERE code = 'LANUOVAFAZENDA')),
  ('Vallefoglia', 'Via Del Foglia, 20', '61022', (SELECT id from Address_Restaurants WHERE code = 'OASI'));

-- to do : inserire il nome dei ristoranti
INSERT IGNORE INTO Restaurants (code) VALUES
  ('BOSCHESE'),
  ('FIOPIZZA'),
  ('ANTICOCASOLARE'),
  ('CAPINERA'),
  ('LANUOVAFAZENDA'),
  ('OASI');

INSERT IGNORE INTO ingredients (code, name, category_id) VALUES
  ('MOZZARELLA', 'Mozzarella', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('POMODORO', 'Pomodoro', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('PATATAFRITTA', 'PatataFritta', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('PROSCIUTTOCOTTO', 'ProsciuttoCotto', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('CARCIOFINI', 'Carciofini', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('FARINADIGRANO', 'FarinaDiGrano', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('FARINADIKAMUT', 'FarinaDiKamut', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('OLIVENERE', 'OliveNere', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('OLIVENERE', 'OliveVerdi', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('UOVASODE', 'UovaSode', (SELECT id FROM Categories WHERE code = 'FOOD')),
  ('TIRAMISU', 'Tiramisù', (SELECT id FROM Categories WHERE code = 'DESSERT')),
  ('PANNACOTTA', 'PannaCotta', (SELECT id FROM Categories WHERE code = 'DESSERT')),
  ('YOGURT', 'Yogurt', (SELECT id FROM Categories WHERE code = 'DESSERT')),
  ('MACEDONIA', 'MacedoniaDiFruttaStagionale', (SELECT id FROM Categories WHERE code = 'DESSERT')),
  ('COCACOLA', 'CocaCola', (SELECT id FROM Categories WHERE code = 'DRINK')),
  ('FANTA', 'Fanta', (SELECT id FROM Categories WHERE code = 'DRINK')),
  ('SPRITE', 'Sprite', (SELECT id FROM Categories WHERE code = 'DRINK')),
  ('GINGER', 'Ginger', (SELECT id FROM Categories WHERE code = 'DRINK')),
  ('GINGER', 'Ginger', (SELECT id FROM Categories WHERE code = 'DRINK')),
  ('BIRRA', 'Birra', (SELECT id FROM Categories WHERE code = 'DRINK'));

INSERT IGNORE INTO Product_Restaurant(price, product_id, restaurant_id) VALUES
  (4.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'BOSCHESE')),
  (5.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'BOSCHESE')),
  (5.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'BOSCHESE')),
  (6.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'BOSCHESE')),
  (5.00, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'FIOPIZZA')),
  (6.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'FIOPIZZA')),
  (7.00, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'FIOPIZZA')),
  (8.00, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'FIOPIZZA')),
  (8.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'ANTICASOLARE')),
  (8.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'ANTICASOLARE')),
  (8.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'ANTICASOLARE')),
  (8.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'ANTICASOLARE')),
  (3.50, (SELECT id FROM Products WHERE code = 'Dessert'), (SELECT id FROM Restaurants WHERE code = 'CAPINERA')),
  (2.50, (SELECT id FROM Products WHERE code = 'Dessert'), (SELECT id FROM Restaurants WHERE code = 'CAPINERA')),
  (4.50, (SELECT id FROM Products WHERE code = 'Dessert'), (SELECT id FROM Restaurants WHERE code = 'CAPINERA')),
  (6.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'CAPINERA')),
  (7.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'CAPINERA')),
  (3.50, (SELECT id FROM Products WHERE code = 'Dessert'), (SELECT id FROM Restaurants WHERE code = 'LANUOVAFAZENDA')),
  (2.50, (SELECT id FROM Products WHERE code = 'Dessert'), (SELECT id FROM Restaurants WHERE code = 'LANUOVAFAZENDA')),
  (4.50, (SELECT id FROM Products WHERE code = 'Dessert'), (SELECT id FROM Restaurants WHERE code = 'LANUOVAFAZENDA')),
  (6.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'LANUOVAFAZENDA')),
  (7.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'LANUOVAFAZENDA')),
  (8.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'LANUOVAFAZENDA')),
  (2.50, (SELECT id FROM Products WHERE code = 'Dessert'), (SELECT id FROM Restaurants WHERE code = 'OASI')),
  (1.50, (SELECT id FROM Products WHERE code = 'Dessert'), (SELECT id FROM Restaurants WHERE code = 'OASI')),
  (3.50, (SELECT id FROM Products WHERE code = 'Dessert'), (SELECT id FROM Restaurants WHERE code = 'OASI')),
  (6.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'OASI')),
  (7.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'OASI')),
  (8.50, (SELECT id FROM Products WHERE code = 'Pizza'), (SELECT id FROM Restaurants WHERE code = 'OASI'));

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



