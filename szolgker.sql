-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Már 17. 11:34
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
-- Adatbázis: `szolgker`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `megrendelo`
--

CREATE TABLE `megrendelo` (
  `MegrendeloID` int(20) NOT NULL,
  `Nev` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `Jelszo` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `Email` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `Telszam` varchar(11) COLLATE utf8_hungarian_ci NOT NULL,
  `Lakcim` varchar(100) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szakmunkas`
--

CREATE TABLE `szakmunkas` (
  `szakmID` int(20) NOT NULL,
  `Nev` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `Jelszo` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `Email` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `Lokacio` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `Telszam` varchar(11) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `megrendelo`
--
ALTER TABLE `megrendelo`
  ADD PRIMARY KEY (`MegrendeloID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- A tábla indexei `szakmunkas`
--
ALTER TABLE `szakmunkas`
  ADD PRIMARY KEY (`szakmID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `megrendelo`
--
ALTER TABLE `megrendelo`
  MODIFY `MegrendeloID` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `szakmunkas`
--
ALTER TABLE `szakmunkas`
  MODIFY `szakmID` int(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
