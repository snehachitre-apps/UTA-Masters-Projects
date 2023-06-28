
create database newcitydb;
use newcitydb;
CREATE TABLE `CitiesPop` (
  `Country` varchar(30) DEFAULT NULL,
   `Sex` varchar(10) DEFAULT NULL,
  `City` varchar(30) DEFAULT NULL,
`sourceyear` varchar(30) DEFAULT NULL,
 
  `Value` varchar(20) DEFAULT NULL);

LOAD DATA LOCAL INFILE 'C:/Users/Sneha/Downloads/CityPop.csv' INTO TABLE CitiesPop FIELDS TERMINATED BY ',';

show index from LocationData;
drop index myIndex on LocationData;
alter table LocationData add index index1(AccentCity,Region,Latitude,Longitude);
alter table LocationData add index index2(Latitude,Longitude);
use newcitydb;
select * from LocationData;
