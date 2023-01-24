-- food_delivery_web_application.buyer definition

CREATE TABLE `buyer` (
  `mobile_number` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role` varchar(100) DEFAULT NULL,
  KEY `buyer_mobile_number_IDX` (`mobile_number`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO food_delivery_web_application.buyer (mobile_number,name,city,address,password,`role`) VALUES
	(102,'Britney','Chandigarh','#36, Sec-56, Chandigarh','102','USER'),
	(101,'Andy','Bangalore','#43, Sec-42, Bangalore','101','USER'),
	(1,'Admin','Ad','Admin','1',NULL);


-- food_delivery_web_application.delivery_agent definition

CREATE TABLE `delivery_agent` (
  `mobile_number` int NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `city` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `role` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO food_delivery_web_application.delivery_agent (mobile_number,name,city,address,password,status,`role`) VALUES
	 (1,'ADMIN','ADMIN','ADMIN','1','ADMIN','ADMIN');

INSERT INTO food_delivery_web_application.delivery_agent (mobile_number,name,city,address,password,status,`role`) VALUES
	 (301,'Harman','Bangalore','Harman''s Address','301','available','USER'),
	 (302,'Gaman','Bangalore','Gaman Address','302','available','USER'),
	 (303,'Daman','Bangalore','Daman Address','303','available','USER'),
	 (304,'Pavan','Bangalore','Pavan Address','304','available','USER'),
	 (305,'Raman','Bangalore','Raman Address','305','available','USER'),
	 (306,'Karam','Chandigarh','Karam Address','306','available','USER'),
	 (307,'Param','Chandigarh','Param Address','307','available','USER'),
	 (308,'Taran','Chandigarh','Taran Address','308','available','USER'),
	 (309,'Farhan','Chandigarh','Farhan Address','309','available','USER'),
	 (310,'Naman','Chandigarh','Naman Address','310','available','USER');


-- food_delivery_web_application.food_dish definition

CREATE TABLE `food_dish` (
  `mobile_number` int DEFAULT NULL,
  `dish_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`dish_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- food_delivery_web_application.orders definition

CREATE TABLE `orders` (
  `order_id` varchar(100) DEFAULT NULL,
  `restaurant_mobile_number` int DEFAULT NULL,
  `buyer_mobile_number` int DEFAULT NULL,
  `delivery_agent_mobile_number` int DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `items` json DEFAULT NULL,
  KEY `orders_restaurant_mobile_number_IDX` (`restaurant_mobile_number`) USING BTREE,
  KEY `orders_buyer_mobile_number_IDX` (`buyer_mobile_number`) USING BTREE,
  KEY `orders_delivery_agent_mobile_number_IDX` (`delivery_agent_mobile_number`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- food_delivery_web_application.restaurant definition

CREATE TABLE `restaurant` (
  `mobile_number` int NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `city` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `role` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO food_delivery_web_application.food_dish (mobile_number,dish_id,name,price) VALUES
	 (203,'203_9_9_21_3:33 pm','Stuffed Parathas',50),
	 (202,'202_9_9_21_3:34 pm','Dum Aloo',300),
	 (202,'202_9_9_21_3:33 pm','Rogan Josh',500),
	 (201,'201_9_9_21_3:34 pm','Daal Baati Churma',200),
	 (201,'201_9_9_21_3:33 pm','Pav Bhaaji',500),
	 (203,'203_9_9_21_3:34 pm','Black dal',70),
	 (204,'204_9_9_21_3:33 pm','Makke di roti with Sarson da Saag',250),
	 (204,'204_9_9_21_3:34 pm','Chhole Bhature',160),
	 (205,'205_9_9_21_3:32 pm','Dosa',110),
	 (206,'206_9_9_21_3:23 pm','Idli Sambhar',80);

INSERT INTO food_delivery_web_application.food_dish (mobile_number,dish_id,name,price) VALUES
	 (206,'206_9_9_21_3:73 pm','Hyderabadi Dum Biryani',350),
	 (205,'205_9_9_21_3:36 pm','Pani Puri',10);

INSERT INTO food_delivery_web_application.restaurant (mobile_number,name,city,address,password,`role`) VALUES
	 (201,'Dominos','Bangalore','#56, Sec-20, Bangalore','201','USER'),
	 (202,'KFC','Bangalore','#5, Sec-23, Bangalore','202','USER'),
	 (203,'Burger King','Bangalore','#5634, Sec-30, Bangalore','203','USER'),
	 (204,'Subway','Chandigarh','#56, Sec-20, Chandigarh','204','USER'),
	 (205,'Mc Donalds','Chandigarh','#5, Sec-23, Chandigarh','205','USER'),
	 (206,'Dunkin Donuts','Chandigarh','#5634, Sec-30, Chandigarh','206','USER'),
	 (1,'ADMIN','ADMIN','ADMIN','1','ADMIN');

