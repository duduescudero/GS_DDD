INSERT INTO usuarios (nome, email, area_atuacao, nivel_carreira, data_cadastro)
VALUES
('Ana Souza', 'ana.souza@example.com', 'Tecnologia', 'JUNIOR', CURRENT_DATE),
('Bruno Lima', 'bruno.lima@example.com', 'Recursos Humanos', 'PLENO', CURRENT_DATE),
('Carla Silva', 'carla.silva@example.com', 'Dados', 'TRANSICAO_CARREIRA', CURRENT_DATE);

INSERT INTO competencias (nome, categoria, descricao) VALUES
('Inteligência Artificial', 'Tecnologia', 'Fundamentos de IA aplicada aos negócios'),
('Análise de Dados', 'Tecnologia', 'Coleta, tratamento e visualização de dados'),
('Empatia', 'Habilidades Humanas', 'Capacidade de se colocar no lugar do outro'),
('Colaboração', 'Habilidades Humanas', 'Trabalho em equipe em ambientes híbridos');

INSERT INTO trilhas (nome, descricao, nivel, carga_horaria, foco_principal) VALUES
('Trilha IA para Profissionais 2030',
 'Introdução à IA, ética e aplicações no futuro do trabalho',
 'INTERMEDIARIO',
 40,
 'Inteligência Artificial'),
('Trilha Dados para Decisão',
 'Fundamentos de dados para tomada de decisão baseada em evidências',
 'INICIANTE',
 30,
 'Análise de Dados'),
('Trilha Soft Skills para Ambientes Híbridos',
 'Desenvolvimento de empatia, colaboração e comunicação em times remotos',
 'INICIANTE',
 24,
 'Habilidades Humanas');

INSERT INTO trilha_competencia (trilha_id, competencia_id) VALUES
(1, 1),
(1, 4),
(2, 2),
(3, 3),
(3, 4);

INSERT INTO matriculas (usuario_id, trilha_id, data_inscricao, status) VALUES
(1, 1, CURRENT_DATE, 'EM_ANDAMENTO'),
(2, 2, CURRENT_DATE, 'CONCLUIDA'),
(3, 3, CURRENT_DATE, 'EM_ANDAMENTO');
