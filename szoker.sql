-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Már 28. 09:55
-- Kiszolgáló verziója: 10.4.6-MariaDB
-- PHP verzió: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `szoker`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `megrendeles`
--

CREATE TABLE `megrendeles` (
  `megrendelesID` int(11) NOT NULL,
  `ar` int(11) NOT NULL,
  `datum` date NOT NULL,
  `feladat` varchar(255) NOT NULL,
  `folyamatban` tinyint(1) NOT NULL,
  `szakmunkasID` int(11) NOT NULL,
  `megrendeloID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `megrendelo`
--

CREATE TABLE `megrendelo` (
  `megrendeloID` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `jelszo` varchar(50) NOT NULL,
  `lakcim` varchar(255) NOT NULL,
  `nev` varchar(100) NOT NULL,
  `telefonszam` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szakma`
--

CREATE TABLE `szakma` (
  `szakmaID` int(11) NOT NULL,
  `szakmanev` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szakmunkas`
--

CREATE TABLE `szakmunkas` (
  `szakmunkasID` int(11) NOT NULL,
  `nev` varchar(100) NOT NULL,
  `lokacio` varchar(255) NOT NULL,
  `telefonszam` varchar(30) NOT NULL,
  `email` varchar(255) NOT NULL,
  `jelszo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szaktudas`
--

CREATE TABLE `szaktudas` (
  `szaktudasID` int(11) NOT NULL,
  `szakmunkasID` int(11) DEFAULT NULL,
  `szakmaID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `test`
--

CREATE TABLE `test` (
  `Id` int(10) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `test`
--

INSERT INTO `test` (`Id`, `fullname`, `username`, `password`, `email`) VALUES
(1, 'Miki', 'user', '$2y$10$NoH6pztg4r99PKOaySGsHODoh0V38sACwD842LpkIfvFV741HOZUm', 'valami@gmail.com'),
(2, 'uristenVeryBig', 'BlahaKeses', '$2y$10$SzLH9NLM1ubmFJJmxEwi2ei7CWbXivhL/1oC1NPxb8x3IwWkNVlLK', 'isten@vasvari.org');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `megrendeles`
--
ALTER TABLE `megrendeles`
  ADD PRIMARY KEY (`megrendelesID`),
  ADD KEY `szakmunkasID` (`szakmunkasID`),
  ADD KEY `megrendeloID` (`megrendeloID`);

--
-- A tábla indexei `megrendelo`
--
ALTER TABLE `megrendelo`
  ADD PRIMARY KEY (`megrendeloID`),
  ADD UNIQUE KEY `email` (`email`);

--
-- A tábla indexei `szakma`
--
ALTER TABLE `szakma`
  ADD PRIMARY KEY (`szakmaID`);

--
-- A tábla indexei `szakmunkas`
--
ALTER TABLE `szakmunkas`
  ADD PRIMARY KEY (`szakmunkasID`),
  ADD UNIQUE KEY `email` (`email`);

--
-- A tábla indexei `szaktudas`
--
ALTER TABLE `szaktudas`
  ADD PRIMARY KEY (`szaktudasID`),
  ADD KEY `szakmunkasID` (`szakmunkasID`),
  ADD KEY `szakmaID` (`szakmaID`);

--
-- A tábla indexei `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`Id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `megrendeles`
--
ALTER TABLE `megrendeles`
  MODIFY `megrendelesID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `megrendelo`
--
ALTER TABLE `megrendelo`
  MODIFY `megrendeloID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `szakma`
--
ALTER TABLE `szakma`
  MODIFY `szakmaID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `szakmunkas`
--
ALTER TABLE `szakmunkas`
  MODIFY `szakmunkasID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `szaktudas`
--
ALTER TABLE `szaktudas`
  MODIFY `szaktudasID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `test`
--
ALTER TABLE `test`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `megrendeles`
--
ALTER TABLE `megrendeles`
  ADD CONSTRAINT `megrendeles_ibfk_1` FOREIGN KEY (`szakmunkasID`) REFERENCES `szakmunkas` (`szakmunkasID`),
  ADD CONSTRAINT `megrendeles_ibfk_2` FOREIGN KEY (`megrendeloID`) REFERENCES `megrendelo` (`megrendeloID`);

--
-- Megkötések a táblához `szaktudas`
--
ALTER TABLE `szaktudas`
  ADD CONSTRAINT `szaktudas_ibfk_1` FOREIGN KEY (`szakmunkasID`) REFERENCES `szakmunkas` (`szakmunkasID`),
  ADD CONSTRAINT `szaktudas_ibfk_2` FOREIGN KEY (`szakmaID`) REFERENCES `szakma` (`szakmaID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
