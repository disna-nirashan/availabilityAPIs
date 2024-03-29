

CREATE TABLE IF NOT EXISTS "LOCATION" (
  "LOCATIONKEY" SERIAL PRIMARY KEY,
  "LOCATIONID" VARCHAR(255) NOT NULL,
  "POSTALCODE" VARCHAR(255)
);

INSERT INTO "LOCATION" ("LOCATIONKEY", "LOCATIONID", "POSTALCODE")
VALUES
(1, 'Colombo', '90000'),
(2, 'Kandy', '60000'),
(3, 'Matara', '5690'),
(4, 'Guadalupe', '964844'),
(5, 'Dobryanka', '576036'),
(6, 'Krajan Joho', '519050'),
(7, 'Qiaozhen', '153950'),
(8, 'Capiové', '771228'),
(9, 'Bardůbyah', '709709'),
(10, 'Ostrówek', '671395'),
(11, 'Parakanhonje Wetan', '110318'),
(12, 'Pluak Daeng', '637543'),
(13, 'Longmen', '999589');

CREATE TABLE IF NOT EXISTS "HOTEL" (
  "HOTELKEY" SERIAL PRIMARY KEY,
  "HOTELID" VARCHAR(255) NOT NULL,
  "PHONE" VARCHAR(255),
  "LOCATIONKEY" INTEGER,
  FOREIGN KEY ("LOCATIONKEY") REFERENCES "LOCATION" ("LOCATIONKEY")
);

INSERT INTO "HOTEL" ("HOTELKEY", "HOTELID", "PHONE", "LOCATIONKEY")
VALUES
(1, 'Galadari', '011-3452344', 1),
(2, 'Thaj-samudra', '011-2312323', 1),
(3, 'Shangrilla', '011-7879090', 1),
(4, 'Åke', '836-820-4198', 5),
(5, 'Noëlla', '107-529-6075', 2),
(6, 'Loïca', '761-937-9191', 12),
(7, 'Rébecca', '744-131-7990', 12),
(8, 'Dù', '838-392-8535', 8),
(9, 'Liè', '123-661-2836', 8),
(10, 'Tú', '390-276-7672', 10),
(11, 'Mélys', '781-959-1564', 10),
(12, 'Méline', '753-502-1485', 9),
(13, 'Inès', '634-696-7083', 9);

CREATE TABLE IF NOT EXISTS "ROOMS" (
  "ROOMSKEY" SERIAL PRIMARY KEY,
  "ROOMSCOUNT" INTEGER,
  "ROOMTYPEKEY" INTEGER,
  "HOTELKEY" INTEGER,
  FOREIGN KEY ("HOTELKEY") REFERENCES "HOTEL" ("HOTELKEY")
);

INSERT INTO "ROOMS" ("ROOMSKEY", "ROOMSCOUNT", "ROOMTYPEKEY", "HOTELKEY")
VALUES
(1, 10, 1, 1),
(2, 5, 2, 1),
(3, 10, 3, 1),
(4, 2, 4, 1);
