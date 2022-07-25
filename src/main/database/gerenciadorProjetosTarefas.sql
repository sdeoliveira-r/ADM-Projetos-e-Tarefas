-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 25-Jul-2022 às 05:03
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `gerenciadorProjetosTarefas`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `projects`
--

CREATE TABLE `projects` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `projects`
--

INSERT INTO `projects` (`id`, `name`, `description`, `createdAt`, `updatedAt`) VALUES
(8, 'Projeto Teste de carregamento', 'Teste de descrição', '2022-07-21 00:00:00', '2022-07-21 00:00:00'),
(27, 'Projeto avançar ', 'Implementar customizações no ADM Projetos e Tarefas', '2022-07-24 00:00:00', '2022-07-24 00:00:00'),
(28, 'Testando', 'Testando o cadastro de projetos', '2022-07-24 00:00:00', '2022-07-24 00:00:00'),
(29, 'Novo projeto', 'Apenas teste de cadastro', '2022-07-24 00:00:00', '2022-07-24 00:00:00'),
(30, 'New Test', 'Save Project', '2022-07-24 00:00:00', '2022-07-24 00:00:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tasks`
--

CREATE TABLE `tasks` (
  `id` int(11) NOT NULL,
  `idProject` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `completed` tinyint(1) NOT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `deadline` date NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tasks`
--

INSERT INTO `tasks` (`id`, `idProject`, `name`, `description`, `completed`, `notes`, `deadline`, `createdAt`, `updatedAt`) VALUES
(25, 27, 'Implementar o conceito de tags', 'Atribuir tags a Tarefa', 0, '', '2022-12-12', '2022-07-24 00:00:00', '2022-07-24 00:00:00'),
(26, 27, 'Criação do conceito de conta de usuário', 'Implementar o conceito de Conta/Usuário para que mais usuários possam utilizar a aplicação', 0, '', '2022-12-12', '2022-07-24 00:00:00', '2022-07-24 00:00:00'),
(27, 27, 'Cria tela de login', 'Construção de uma tela de Login para acesso do usuário', 0, 'Criar a tela após implementar o conceito de Conta/Usuário', '2022-12-20', '2022-07-24 00:00:00', '2022-07-24 00:00:00'),
(28, 27, 'Permitir alteração dos dados da tarefa', 'Permitir alteração de informações nas tarefas', 0, '', '2023-02-15', '2022-07-24 00:00:00', '2022-07-24 00:00:00'),
(29, 27, 'Implementar a funcionalidade para deletar projetos', '', 0, '', '2022-12-12', '2022-07-24 00:00:00', '2022-07-24 00:00:00'),
(30, 27, 'Agradecimentos', 'Prof. Marcio Michelluzzi ', 1, 'Capgemini\nProWay', '2022-07-25', '2022-07-24 00:00:00', '2022-07-24 00:00:00'),
(31, 8, 'Teste de hoje', 'Testando funcionalidades', 0, 'Sem mais', '2022-07-24', '2022-07-24 00:00:00', '2022-07-24 00:00:00'),
(33, 30, 'New Task', 'Tasks description', 0, 'Note notes', '2022-08-10', '2022-07-24 00:00:00', '2022-07-24 00:00:00');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_projects` (`idProject`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `projects`
--
ALTER TABLE `projects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de tabela `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `fk_projects` FOREIGN KEY (`idProject`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
