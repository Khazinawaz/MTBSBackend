-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 29, 2018 at 09:28 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mtbs_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `booked_seats_history`
--

CREATE TABLE `booked_seats_history` (
  `ticket_id_fk` int(11) NOT NULL,
  `show_id_fk` int(11) NOT NULL,
  `show_date` date NOT NULL,
  `seat_number` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `booking_id` int(11) NOT NULL,
  `booking_date` date NOT NULL,
  `user_id_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `movie_id` int(11) NOT NULL,
  `movie_name` varchar(30) NOT NULL,
  `movie_rating` float DEFAULT NULL,
  `movie_genre` varchar(15) DEFAULT NULL,
  `movie_cast` varchar(50) DEFAULT NULL,
  `movie_director` varchar(30) NOT NULL,
  `movie_duration` time NOT NULL,
  `movie_pic_url` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`movie_id`, `movie_name`, `movie_rating`, `movie_genre`, `movie_cast`, `movie_director`, `movie_duration`, `movie_pic_url`) VALUES
(1, 'abc', 0.9, 'comedy', 'akshay', 'arvind', '02:26:00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `ticket_id_fk` int(11) NOT NULL,
  `txn_id` int(11) NOT NULL,
  `mode_of_payment` varchar(20) NOT NULL,
  `bank_name` varchar(30) NOT NULL,
  `reference_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `profile`
--

CREATE TABLE `profile` (
  `user_Id` int(10) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `fName` varchar(20) NOT NULL,
  `lName` varchar(20) DEFAULT NULL,
  `contact_number` bigint(15) DEFAULT NULL,
  `dob` date NOT NULL,
  `type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profile`
--

INSERT INTO `profile` (`user_Id`, `password`, `email`, `fName`, `lName`, `contact_number`, `dob`, `type`) VALUES
(1, 'anupam', 'anupam@accolite.com', 'anupam', 'awasthi', 1234567890, '1993-03-12', 'user'),
(2, 'raghul', 'raghul@accolite.com', 'raghul', 'abcd', 1111111111, '1988-05-05', 'user'),
(5, 'raghul', 'raghul1@accolite.com', 'raghul', 'abcd', 1111111121, '1988-05-05', 'user'),
(6, 'raghul', 'raghu15@accolite.com', 'raghul', 'abcd', 1111112222, '1988-05-05', 'user'),
(7, '12345', 'khazinawaz@gmail.com', 'Khazi', 'Nawaz', 123123213, '1996-12-12', 'user'),
(9, 'YoXT77+8tGzP0EG9KBUEAw==', 'khazinawaz1@gmail.com', 'Khazi', 'Nawaz', 1231232134, '1996-12-12', 'user'),
(10, 'i9zvZhHg3LsIlhxlC2ZMgg==', 'k2hazinawaz@gmail.com', 'Khazi', 'Nawaz', 232141341, '2018-01-11', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `screen`
--

CREATE TABLE `screen` (
  `screen_id` varchar(11) NOT NULL,
  `theatre_id_fk` int(11) NOT NULL,
  `no_rows` int(11) NOT NULL,
  `no_seats` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `screen`
--

INSERT INTO `screen` (`screen_id`, `theatre_id_fk`, `no_rows`, `no_seats`) VALUES
('1', 1, 4, 10);

-- --------------------------------------------------------

--
-- Table structure for table `screen_shows`
--

CREATE TABLE `screen_shows` (
  `show_id` int(11) NOT NULL,
  `theatre_id_fk` int(11) NOT NULL,
  `screen_id_fk` varchar(10) NOT NULL,
  `show_start_time` time NOT NULL,
  `duration` time NOT NULL,
  `show_start_date` date NOT NULL,
  `show_end_date` date NOT NULL,
  `movie_id_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `theatre`
--

CREATE TABLE `theatre` (
  `theatre_id` int(11) NOT NULL,
  `theatre_name` varchar(20) NOT NULL,
  `theatre_address` varchar(50) NOT NULL,
  `theatre_city` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `theatre`
--

INSERT INTO `theatre` (`theatre_id`, `theatre_name`, `theatre_address`, `theatre_city`) VALUES
(1, 'inox', 'marathalli', 'Banglore');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `ticket_id` int(11) NOT NULL,
  `show_id_fk` int(11) NOT NULL,
  `show_date_fk` date NOT NULL,
  `user_id_fk` int(11) NOT NULL,
  `booking_id_fk` int(11) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booked_seats_history`
--
ALTER TABLE `booked_seats_history`
  ADD PRIMARY KEY (`show_id_fk`,`show_date`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `profile_booking` (`user_id_fk`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`movie_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`txn_id`),
  ADD KEY `ticket_payment_constraint` (`ticket_id_fk`);

--
-- Indexes for table `profile`
--
ALTER TABLE `profile`
  ADD PRIMARY KEY (`user_Id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `contact_number` (`contact_number`);

--
-- Indexes for table `screen`
--
ALTER TABLE `screen`
  ADD PRIMARY KEY (`screen_id`,`theatre_id_fk`),
  ADD KEY `theatre_screen_constraint` (`theatre_id_fk`);

--
-- Indexes for table `screen_shows`
--
ALTER TABLE `screen_shows`
  ADD PRIMARY KEY (`show_id`),
  ADD KEY `theatre_screenshow_constraint` (`theatre_id_fk`),
  ADD KEY `screen_screenshow_constraint` (`screen_id_fk`),
  ADD KEY `movie_screenshow_constraint` (`movie_id_fk`);

--
-- Indexes for table `theatre`
--
ALTER TABLE `theatre`
  ADD PRIMARY KEY (`theatre_id`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticket_id`),
  ADD KEY `show_ticket_constraint` (`show_id_fk`),
  ADD KEY `profile_ticket_constraint` (`user_id_fk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `booking_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `movies`
--
ALTER TABLE `movies`
  MODIFY `movie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `txn_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `profile`
--
ALTER TABLE `profile`
  MODIFY `user_Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `screen_shows`
--
ALTER TABLE `screen_shows`
  MODIFY `show_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `theatre`
--
ALTER TABLE `theatre`
  MODIFY `theatre_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `ticket_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `profile_booking` FOREIGN KEY (`user_id_fk`) REFERENCES `profile` (`user_Id`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `ticket_payment_constraint` FOREIGN KEY (`ticket_id_fk`) REFERENCES `ticket` (`ticket_id`);

--
-- Constraints for table `screen`
--
ALTER TABLE `screen`
  ADD CONSTRAINT `theatre_screen_constraint` FOREIGN KEY (`theatre_id_fk`) REFERENCES `theatre` (`theatre_id`);

--
-- Constraints for table `screen_shows`
--
ALTER TABLE `screen_shows`
  ADD CONSTRAINT `movie_screenshow_constraint` FOREIGN KEY (`movie_id_fk`) REFERENCES `movies` (`movie_id`),
  ADD CONSTRAINT `screen_screenshow_constraint` FOREIGN KEY (`screen_id_fk`) REFERENCES `screen` (`screen_id`),
  ADD CONSTRAINT `theatre_screenshow_constraint` FOREIGN KEY (`theatre_id_fk`) REFERENCES `theatre` (`theatre_id`);

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `profile_ticket_constraint` FOREIGN KEY (`user_id_fk`) REFERENCES `profile` (`user_Id`),
  ADD CONSTRAINT `show_ticket_constraint` FOREIGN KEY (`show_id_fk`) REFERENCES `screen_shows` (`show_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
