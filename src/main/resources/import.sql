INSERT INTO cozinha (id, nome) VALUES (1, 'Tailandesa'); 
INSERT INTO cozinha (id, nome) VALUES (2, 'Indiana');

INSERT INTO restaurante (nome, taxa_frete, cozinha_fk) VALUES ('Thai Gourmet', 10, 1);
INSERT INTO restaurante (nome, taxa_frete, cozinha_fk) VALUES ('Thai Delivery', 9.50, 1);
INSERT INTO restaurante (nome, taxa_frete, cozinha_fk) VALUES ('Tuk Tuk Comida Indiana', 15, 2);