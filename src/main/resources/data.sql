INSERT INTO autor (nome) VALUES ('J.K. Rowling');
INSERT INTO autor (nome) VALUES ('George R.R. Martin');
INSERT INTO autor (nome) VALUES ('J.R.R. Tolkien');
INSERT INTO autor (nome) VALUES ('Stephen King');
INSERT INTO autor (nome) VALUES ('Agatha Christie');

INSERT INTO public.categoria (nome) VALUES ('Ficção');
INSERT INTO public.categoria (nome) VALUES ('Fantasia');
INSERT INTO public.categoria (nome) VALUES ('Mistério');
INSERT INTO public.categoria (nome) VALUES ('Terror');
INSERT INTO public.categoria (nome) VALUES ('Romance');

INSERT INTO public.livro (nome, editora, quantidade) VALUES ('Harry Potter e a Pedra Filosofal', 'Rocco', 10);
INSERT INTO public.livro (nome, editora, quantidade) VALUES ('A Guerra dos Tronos', 'LeYa', 5);
INSERT INTO public.livro (nome, editora, quantidade) VALUES ('O Senhor dos Anéis: A Sociedade do Anel', 'Martins Fontes', 7);
INSERT INTO public.livro (nome, editora, quantidade) VALUES ('O Iluminado', 'Suma', 8);
INSERT INTO public.livro (nome, editora, quantidade) VALUES ('Assassinato no Expresso do Oriente', 'HarperCollins', 4);

INSERT INTO public.livro_autor (autor_id, livro_id) VALUES (1, 1);  -- J.K. Rowling -> Harry Pottera
INSERT INTO public.livro_autor (autor_id, livro_id) VALUES (2, 2);  -- George R.R. Martin -> A Guerra dos Tronos
INSERT INTO public.livro_autor (autor_id, livro_id) VALUES (3, 3);  -- J.R.R. Tolkien -> O Senhor dos Anéis
INSERT INTO public.livro_autor (autor_id, livro_id) VALUES (4, 4);  -- Stephen King -> O Iluminado
INSERT INTO public.livro_autor (autor_id, livro_id) VALUES (5, 5);  -- Agatha Christie -> Assassinato no Expresso do Oriente

INSERT INTO public.livro_categoria (categoria_id, livro_id) VALUES (2, 1);  -- Fantasia -> Harry Potter
INSERT INTO public.livro_categoria (categoria_id, livro_id) VALUES (2, 2);  -- Fantasia -> A Guerra dos Tronos
INSERT INTO public.livro_categoria (categoria_id, livro_id) VALUES (2, 3);  -- Fantasia -> O Senhor dos Anéis
INSERT INTO public.livro_categoria (categoria_id, livro_id) VALUES (4, 4);  -- Terror -> O Iluminado
INSERT INTO public.livro_categoria (categoria_id, livro_id) VALUES (3, 5);  -- Mistério -> Assassinato no Expresso do Oriente

INSERT INTO public.usuario (nome, email, senha, cpf, ativo, data_nascimento)
VALUES ('João da Silva', 'joao.silva@example.com', 'senha123', '123.456.789-00', true, '1985-10-15');

INSERT INTO public.usuario (nome, email, senha, cpf, ativo, data_nascimento)
VALUES ('Maria Oliveira', 'maria.oliveira@example.com', 'senha123', '987.654.321-00', true, '1990-05-22');

INSERT INTO public.usuario (nome, email, senha, cpf, ativo, data_nascimento)
VALUES ('Carlos Souza', 'carlos.souza@example.com', 'senha123', '456.123.789-00', true, '1988-03-11');

INSERT INTO public.usuario (nome, email, senha, cpf, ativo, data_nascimento)
VALUES ('Ana Pereira', 'ana.pereira@example.com', 'senha123', '321.654.987-00', true, '1992-07-30');

INSERT INTO public.usuario (nome, email, senha, cpf, ativo, data_nascimento)
VALUES ('Pedro Costa', 'pedro.costa@example.com', 'senha123', '789.123.456-00', true, '1983-12-01');



