# Introduction

This document provides the database schema and sample data for all the tables.

## Hotel Table

### Table Creation

```sql
CREATE TABLE `hotel` (
  `hotel_id` int NOT NULL,
  `hotel_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_city` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_district` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_feature` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_address` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_mail` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_phone` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_star` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
```

### Sample Data Insertion for Hotel Table

```sql
INSERT INTO `hotel` (`hotel_id`, `hotel_name`, `hotel_city`, `hotel_district`, `hotel_feature`, `hotel_address`, `hotel_mail`, `hotel_phone`, `hotel_star`) VALUES
(20, 'Voyage Sorgun', 'Antalya', 'Manavgat', 'Ücretsiz Otopark, Ücretsiz WiFi, Yüzme Havuzu', 'Manavgat Sorgun Yöresi, Titreyengöl Mevkii, 07600 Manavgat/Antalya', 'sorgun@voyagehotel.com', '(0242) 756 93 00', 5),
(21, 'Four Seasons Hotel', 'İstanbul', 'Merkez', 'Ücretsiz Otopark, Ücretsiz WiFi, Yüzme Havuzu, Fitness Center, Hotel Concierge, SPA, 7/24 Oda Servisi', 'No:28, Çırağan Cd., 34349 Beşiktaş/İstanbul', 'reservations.istanbul@fourseasons.com', '(0212) 381 40 00', 5),
(22, 'Bolu Koru Hotels Spa & Convention', 'Bolu', 'Merkez', 'Ücretsiz Otopark, Ücretsiz WiFi, Yüzme Havuzu, SPA\r\n', 'Otel sokak, No:19, 14080 Bolu Merkez/Bolu', 'info@bolukoruhotels.com', '(0374) 225 22 91', 5),
(23, 'Peracity Hotel', 'Ankara', 'Altındağ', 'Ücretsiz Otopark, Ücretsiz WiFi\r\n', 'Anafartalar, Rüzgarlı Cd. No:10, 06050 Altındağ/Ankara', 'info@peracity.com', '(0312) 312 12 69', 4),
(27, 'Grand Ser Otel', 'Yozgat', 'Merkez', 'Ücretsiz Otopark, Ücretsiz WiFi', 'Şeyh Osman, Adnan Menderes Blv. No:30, 66100 Yozgat Merkez/Yozgat', 'info@grandserhotel.com', '0354 212 26 26', 4),
(28, 'Gloria Tibi Gümbet', 'Muğla', 'Bodrum', 'Ücretsiz Otopark, Ücretsiz WiFi, Yüzme Havuzu', 'Bitez, Bitez Cd. No:7, 48400 Bodrum/Muğla', 'info@gloria.com', '(0252) 319 55 57', 3),
(29, 'Olimpiyat Otel', 'İzmir', 'Konak', 'Ücretsiz Otopark, Ücretsiz WiFi', 'Akıncı, 945. Sk. No:2 No:2, 35240 Konak/İzmir', 'info@olimpiyat.com', '(0232) 425 12 69', 2);
```

## Reservation Table

### Table Creation

```sql
CREATE TABLE `reservation` (
  `reservation_id` int NOT NULL,
  `customer_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `customer_phone` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `customer_mail` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `customer_number` int NOT NULL,
  `reservation_start_date` date NOT NULL,
  `reservation_end_date` date NOT NULL,
  `customer_price` double NOT NULL,
  `term_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

```

### Sample Data Insertion for Reservation Table

```sql
INSERT INTO `reservation` (`reservation_id`, `customer_name`, `customer_phone`, `customer_mail`, `customer_number`, `reservation_start_date`, `reservation_end_date`, `customer_price`, `term_id`) VALUES
(3, 'Doğa Yıldız', '05345679834', 'dogayildiz@hotmail.com', 2, '2024-07-11', '2024-07-18', 321120, 16),
(4, 'Esra Bildik', '05453223516', 'esra@gmail.com', 5, '2023-11-05', '2023-11-15', 161920, 17),
(5, 'Ayşe Kutlu', '05335695344', 'aysek@yahoo.com', 1, '2024-03-10', '2024-04-03', 25000, 19);

```

## Room Table

### Table Creation

```sql
CREATE TABLE `room` (
  `room_id` int NOT NULL,
  `room_type` enum('Single','Double','Suit') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `room_stock` int NOT NULL,
  `hotel_id` int NOT NULL,
  `feature` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `room_bed_count` int NOT NULL,
  `room_size` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

```

### Sample Data Insertion for Room Table

```sql
INSERT INTO `room` (`room_id`, `room_type`, `room_stock`, `hotel_id`, `feature`, `room_bed_count`, `room_size`) VALUES
(16, 'Single', 18, 23, 'Televizyon, Kasa', 2, 25),
(17, 'Double', 27, 22, 'Televizyon, Minibar, Kasa', 2, 33),
(18, 'Suit', 22, 21, 'Televizyon, Minibar, Kasa, Projeksiyon', 2, 56),
(19, 'Suit', 16, 20, 'Televizyon, Minibar, Oyun Konsolu, Kasa, Projeksiyon', 2, 80),
(20, 'Single', 30, 22, 'Televizyon, Kasa', 5, 58),
(21, 'Single', 9, 29, 'Televizyon', 1, 21),
(22, 'Double', 4, 29, 'Televizyon, Minibar', 1, 32),
(23, 'Suit', 12, 28, 'Televizyon, Minibar, Kasa', 3, 52),
(24, 'Double', 11, 27, '', 4, 41),
(25, 'Suit', 4, 27, 'Televizyon, Minibar, Kasa', 3, 43);

```

## Term Table

### Table Creation

```sql
CREATE TABLE `term` (
  `term_id` int NOT NULL,
  `hotel_id` int NOT NULL,
  `room_id` int NOT NULL,
  `board_type` enum('Yarım Pansiyon','Tam Pansiyon','Her Şey Dahil') COLLATE utf8mb4_general_ci NOT NULL,
  `term_start_date` date NOT NULL,
  `term_end_date` date NOT NULL,
  `adult_price` int NOT NULL,
  `children_price` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

```

### Sample Data Insertion for Term Table

```sql
INSERT INTO `term` (`term_id`, `hotel_id`, `room_id`, `board_type`, `term_start_date`, `term_end_date`, `adult_price`, `children_price`) VALUES
(11, 23, 16, 'Yarım Pansiyon', '2023-11-10', '2024-04-10', 2200, 1760),
(12, 22, 17, 'Tam Pansiyon', '2024-01-01', '2024-05-01', 5358, 4286),
(13, 21, 18, 'Her Şey Dahil', '2023-11-07', '2024-04-01', 9048, 7238),
(14, 21, 18, 'Her Şey Dahil', '2024-04-02', '2024-07-20', 12340, 9872),
(15, 20, 19, 'Her Şey Dahil', '2024-01-01', '2024-07-01', 17040, 13632),
(16, 20, 19, 'Her Şey Dahil', '2024-07-10', '2024-09-10', 22300, 17840),
(17, 22, 20, 'Yarım Pansiyon', '2023-11-01', '2023-12-30', 3200, 2560),
(18, 29, 21, 'Yarım Pansiyon', '2024-01-01', '2024-08-01', 700, 560),
(19, 29, 22, 'Yarım Pansiyon', '2024-03-01', '2024-10-01', 1000, 800),
(20, 28, 23, 'Tam Pansiyon', '2024-08-01', '2024-12-25', 1800, 1440),
(21, 27, 24, 'Tam Pansiyon', '2024-05-01', '2024-10-01', 1530, 1224),
(22, 27, 25, 'Her Şey Dahil', '2023-11-01', '2024-04-19', 2300, 1840);

```

## User Table

### Table Creation

```sql
CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `user_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `user_uname` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `user_password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `user_type` enum('admin','employee') COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

```

### Sample Data Insertion for User Table

```sql
INSERT INTO `user` (`user_id`, `user_name`, `user_uname`, `user_password`, `user_type`) VALUES
(1, 'dilan', 'dddd', '1234', 'admin'),
(4, 'Patika Dev', 'patikadev', '1234', 'employee');

```