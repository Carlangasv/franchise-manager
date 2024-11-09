-- Franquicias
INSERT INTO franchise(name) VALUES ('Franquicia 1');

-- Sucursal
INSERT INTO branch_office(name, franchise_id) VALUES ('Sucursal 1', 1);

-- Productos
INSERT INTO product (name, stock_amount, branch_office_id) VALUES ('Celular', 30, 1)