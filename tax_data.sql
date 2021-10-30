-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2021 at 04:03 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tax_data`
--

-- --------------------------------------------------------

--
-- Table structure for table `tax_type`
--

CREATE TABLE `tax_type` (
  `ID` int(11) NOT NULL,
  `TAX_TYPE` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tax_type`
--

INSERT INTO `tax_type` (`ID`, `TAX_TYPE`) VALUES
(0, 'GENERAL'),
(1, 'WINNINGS');

-- --------------------------------------------------------

--
-- Table structure for table `trader`
--

CREATE TABLE `trader` (
  `ID` int(11) NOT NULL,
  `TAX_RATE` decimal(10,0) DEFAULT NULL,
  `TAX_AMOUNT` decimal(10,0) DEFAULT NULL,
  `TAX_TYPE_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trader`
--

INSERT INTO `trader` (`ID`, `TAX_RATE`, `TAX_AMOUNT`, `TAX_TYPE_ID`) VALUES
(1, '10', NULL, 0),
(2, NULL, '1', 0),
(3, '12', NULL, 1),
(4, NULL, '2', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tax_type`
--
ALTER TABLE `tax_type`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `trader`
--
ALTER TABLE `trader`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `TAX_TYPE_ID` (`TAX_TYPE_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `trader`
--
ALTER TABLE `trader`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `trader`
--
ALTER TABLE `trader`
  ADD CONSTRAINT `trader_ibfk_1` FOREIGN KEY (`TAX_TYPE_ID`) REFERENCES `tax_type` (`ID`) ON DELETE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
