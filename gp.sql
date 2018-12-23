-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 11 Juin 2015 à 17:40
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `gp`
--

-- --------------------------------------------------------

--
-- Structure de la table `chefprojet`
--

CREATE TABLE IF NOT EXISTS `chefprojet` (
  `ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `chefprojet`
--

INSERT INTO `chefprojet` (`ID`) VALUES
(1),
(3);

-- --------------------------------------------------------

--
-- Structure de la table `compterendu`
--

CREATE TABLE IF NOT EXISTS `compterendu` (
  `IDREUNION` int(11) NOT NULL,
  `DATECREATION` datetime DEFAULT NULL,
  `ORDRE` varchar(255) DEFAULT NULL,
  `CHEFPROJET` int(11) DEFAULT NULL,
  `COMMENTAIRECHEFPROJET` varchar(255) DEFAULT NULL,
  `VALIDE` bit(1) DEFAULT NULL,
  PRIMARY KEY (`IDREUNION`),
  KEY `FK_92hcw9dn1c3jlr999k914pjas` (`CHEFPROJET`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compterendu`
--

INSERT INTO `compterendu` (`IDREUNION`, `DATECREATION`, `ORDRE`, `CHEFPROJET`, `COMMENTAIRECHEFPROJET`, `VALIDE`) VALUES
(1, '2015-05-25 00:00:00', NULL, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `connaissancetechnique`
--

CREATE TABLE IF NOT EXISTS `connaissancetechnique` (
  `IDCT` int(11) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDCT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `conntechq_chefprojet`
--

CREATE TABLE IF NOT EXISTS `conntechq_chefprojet` (
  `IDCT` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`,`IDCT`),
  KEY `FK_o4osohnrv4mkychny8n5mvufg` (`IDCT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `direction`
--

CREATE TABLE IF NOT EXISTS `direction` (
  `ID` int(11) NOT NULL,
  `INTITULE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `direction`
--

INSERT INTO `direction` (`ID`, `INTITULE`) VALUES
(1, 'DIRECTION INFO'),
(2, 'DIRECTION FIN');

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

CREATE TABLE IF NOT EXISTS `document` (
  `NOM` varchar(255) NOT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  `MATRICULE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`NOM`),
  KEY `FK_rsm7fvxngl3xvb57jh359dij` (`MATRICULE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `dsi`
--

CREATE TABLE IF NOT EXISTS `dsi` (
  `ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `dsi`
--

INSERT INTO `dsi` (`ID`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `etape`
--

CREATE TABLE IF NOT EXISTS `etape` (
  `CODE` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `DATEDEBUT` datetime DEFAULT NULL,
  `DATEFIN` datetime DEFAULT NULL,
  `DUREE` int(11) DEFAULT NULL,
  `NIVEAU` varchar(255) DEFAULT NULL,
  `PROCHAINEETAPE` varchar(255) DEFAULT NULL,
  `POURCENTAGE` int(11) DEFAULT NULL,
  `MATRICULE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CODE`),
  KEY `FK_78yuk7ym23himtwsaehmjo5in` (`MATRICULE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `etape`
--

INSERT INTO `etape` (`CODE`, `DESCRIPTION`, `DATEDEBUT`, `DATEFIN`, `DUREE`, `NIVEAU`, `PROCHAINEETAPE`, `POURCENTAGE`, `MATRICULE`) VALUES
('A', 'Réunion', '2015-06-01 00:00:00', '2015-06-01 00:00:00', 1, '1', NULL, 0, 'A96507'),
('B', 'creation BD avec MS SQL Server', '2015-06-04 00:00:00', '2015-07-07 00:00:00', 4, '2', 'creation d''une page LOGIN', 75, 'A96507'),
('C', 'Réunion 3', '2015-06-16 00:00:00', '2015-06-16 00:00:00', 1, '3', NULL, 0, 'A96507'),
('D', 'Réalisation des vues', '2015-06-12 00:00:00', '2015-06-14 00:00:00', 3, '4', NULL, 0, 'A96507'),
('F', 'testes unitaires', '2015-06-11 00:00:00', '2015-06-25 00:00:00', 6, '5', NULL, 0, 'A96507'),
('G', 'TEST', '2015-06-11 00:00:00', '2015-06-23 00:00:00', 9, '9', NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `probleme`
--

CREATE TABLE IF NOT EXISTS `probleme` (
  `ID` int(11) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `ETAPES` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_eg57lrxs4f63bupvrytmqdobl` (`ETAPES`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE IF NOT EXISTS `projet` (
  `MATRICULE` varchar(255) NOT NULL,
  `INTITULE` varchar(255) DEFAULT NULL,
  `DIRECTIONRESPONSABLE` int(11) DEFAULT NULL,
  `BUDGET` double DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `DATECREATION` datetime DEFAULT NULL,
  `PREVUDEBUT` datetime DEFAULT NULL,
  `PREVUFIN` datetime DEFAULT NULL,
  `SPONSOR` varchar(255) DEFAULT NULL,
  `COMMENATAIRECHEFPROJET` varchar(255) DEFAULT NULL,
  `VALIDE` bit(1) DEFAULT b'0',
  `PRIORITE` varchar(255) DEFAULT NULL,
  `CHEFPROJET` int(11) DEFAULT NULL,
  PRIMARY KEY (`MATRICULE`),
  KEY `FK_fgpq97a05nbgb6umfhyll0b3d` (`DIRECTIONRESPONSABLE`),
  KEY `FK_mgxkssxtkvq6egsp2u7baw3jt` (`CHEFPROJET`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `projet`
--

INSERT INTO `projet` (`MATRICULE`, `INTITULE`, `DIRECTIONRESPONSABLE`, `BUDGET`, `DESCRIPTION`, `DATECREATION`, `PREVUDEBUT`, `PREVUFIN`, `SPONSOR`, `COMMENATAIRECHEFPROJET`, `VALIDE`, `PRIORITE`, `CHEFPROJET`) VALUES
('A10201', 'Creation d''une application android pour MASAR', 1, 25000, 'cette application va aider les étudiants et les enseignants pour accéder a leur sessions depuis le smartphone', '2015-06-03 16:59:30', '2015-06-30 00:00:00', '2015-06-30 00:00:00', 'CISCO company', '', b'0', NULL, 1),
('A9568', 'Création d''une application Bureau de gestion des employes', 1, 120000, NULL, '2015-06-03 16:54:50', NULL, NULL, NULL, NULL, b'0', NULL, 3),
('A96507', 'Creation d''une application WEB pour la societe ALPHASOFT', 1, 152665, 'langage de programmation jee et hibernate plus une base de donnees MS SQL Server', '2015-05-31 00:00:00', '2015-05-04 00:00:00', '2015-05-30 00:00:00', 'microsoft', NULL, b'0', NULL, 1),
('A96509', 'Creation d''une application Android Masar', 2, 52000, NULL, '2015-06-03 00:00:00', NULL, NULL, NULL, NULL, b'0', NULL, 3),
('D956856', 'Création d''une application Web de gestion de maintenance', 1, 100000, NULL, '2015-06-01 00:00:00', NULL, NULL, NULL, NULL, b'0', NULL, 3),
('DM2566', 'Création d''une application andorid de gestion des rapports', 1, 12562, 'NO DESCRIPTION', '2015-06-03 02:15:29', '2015-06-22 00:00:00', '2015-06-22 00:00:00', NULL, '', b'0', NULL, 1),
('k96585', NULL, 1, 15000, 'RIEN', '2015-06-02 00:00:00', '2015-06-24 00:00:00', '2015-06-24 00:00:00', NULL, '', b'0', NULL, 1),
('p5265', 'test', 1, 1220000, NULL, '2015-05-30 00:00:00', NULL, NULL, NULL, NULL, b'0', NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `reunion`
--

CREATE TABLE IF NOT EXISTS `reunion` (
  `IDREUNION` int(11) NOT NULL,
  `DATEREUNION` datetime DEFAULT NULL,
  `ORDRE` varchar(255) DEFAULT NULL,
  `ENDROIT` varchar(255) DEFAULT NULL,
  `MATRICULE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDREUNION`),
  KEY `FK_19u8582s4b0792sdihho1hk3x` (`MATRICULE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `reunion`
--

INSERT INTO `reunion` (`IDREUNION`, `DATEREUNION`, `ORDRE`, `ENDROIT`, `MATRICULE`) VALUES
(1, '2015-05-25 14:00:00', 'etude des besoins', 'Salle C1', 'k96585'),
(2, '2015-06-18 10:00:00', 'Validation des diagrammes', 'Salle C3', 'A10201'),
(3, '2015-06-16 09:00:00', 'Base de données', 'Salle c3', 'A96507'),
(4, '2015-06-23 10:00:00', 'les interfaces grafique', 'Salle C3', 'p5265');

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `ID` int(11) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`ID`, `LIBELLE`) VALUES
(1, 'DSI'),
(2, 'CHEFPROJET');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int(11) NOT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `CIN` varchar(255) DEFAULT NULL,
  `TEL` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `DATECREATION` datetime DEFAULT NULL,
  `ROLE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_5kggld5htct00xj4hcpktegee` (`ROLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID`, `NOM`, `PRENOM`, `CIN`, `TEL`, `EMAIL`, `USERNAME`, `PASSWORD`, `DATECREATION`, `ROLE`) VALUES
(1, 'AMCHAYD', 'OUALID', 'V307243', '0699148697', 'amchaydoualid@gmail.com', 'oualid', '123456', '2015-05-24 00:00:00', 2),
(2, 'EL ALLALI', 'ABDELHADI', 'D958658', '0685854558', 'eallali@gmail.com', 'elallali', '123456', '2015-05-25 00:00:00', 1),
(3, 'ANASI', 'ASMAE', 'F85695', '0685457415', 'anasi@gmail.com', 'anasi', '123456', '2015-05-30 00:00:00', 2);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `chefprojet`
--
ALTER TABLE `chefprojet`
  ADD CONSTRAINT `FK_p7uf2buhib7bgr7513smhn5uw` FOREIGN KEY (`ID`) REFERENCES `utilisateur` (`ID`);

--
-- Contraintes pour la table `compterendu`
--
ALTER TABLE `compterendu`
  ADD CONSTRAINT `FK_92hcw9dn1c3jlr999k914pjas` FOREIGN KEY (`CHEFPROJET`) REFERENCES `chefprojet` (`ID`),
  ADD CONSTRAINT `FK_qip0v55t9rmuyq8b820t976b0` FOREIGN KEY (`IDREUNION`) REFERENCES `reunion` (`IDREUNION`);

--
-- Contraintes pour la table `conntechq_chefprojet`
--
ALTER TABLE `conntechq_chefprojet`
  ADD CONSTRAINT `FK_m6atyb82bgxh72xy04ujse6v9` FOREIGN KEY (`ID`) REFERENCES `chefprojet` (`ID`),
  ADD CONSTRAINT `FK_o4osohnrv4mkychny8n5mvufg` FOREIGN KEY (`IDCT`) REFERENCES `connaissancetechnique` (`IDCT`);

--
-- Contraintes pour la table `document`
--
ALTER TABLE `document`
  ADD CONSTRAINT `FK_rsm7fvxngl3xvb57jh359dij` FOREIGN KEY (`MATRICULE`) REFERENCES `projet` (`MATRICULE`);

--
-- Contraintes pour la table `dsi`
--
ALTER TABLE `dsi`
  ADD CONSTRAINT `FK_d32w8un8myxgug21ifa0md0k8` FOREIGN KEY (`ID`) REFERENCES `utilisateur` (`ID`);

--
-- Contraintes pour la table `etape`
--
ALTER TABLE `etape`
  ADD CONSTRAINT `FK_78yuk7ym23himtwsaehmjo5in` FOREIGN KEY (`MATRICULE`) REFERENCES `projet` (`MATRICULE`);

--
-- Contraintes pour la table `probleme`
--
ALTER TABLE `probleme`
  ADD CONSTRAINT `FK_eg57lrxs4f63bupvrytmqdobl` FOREIGN KEY (`ETAPES`) REFERENCES `etape` (`CODE`);

--
-- Contraintes pour la table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `FK_fgpq97a05nbgb6umfhyll0b3d` FOREIGN KEY (`DIRECTIONRESPONSABLE`) REFERENCES `direction` (`ID`),
  ADD CONSTRAINT `FK_mgxkssxtkvq6egsp2u7baw3jt` FOREIGN KEY (`CHEFPROJET`) REFERENCES `chefprojet` (`ID`);

--
-- Contraintes pour la table `reunion`
--
ALTER TABLE `reunion`
  ADD CONSTRAINT `FK_19u8582s4b0792sdihho1hk3x` FOREIGN KEY (`MATRICULE`) REFERENCES `projet` (`MATRICULE`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK_5kggld5htct00xj4hcpktegee` FOREIGN KEY (`ROLE`) REFERENCES `role` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
