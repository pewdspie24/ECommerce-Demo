INSERT INTO account (`email`, `password`, `createdat`) VALUES ('test@gmail.com', '123456', '22-11-2021');
INSERT INTO address (`number`, `street`, `district`, `city`) VALUES ('22', 'GP', 'TT', 'HN');
INSERT INTO fullname (`firstname`, `lastname`) VALUES ('tran', 'quang');
INSERT INTO phone (`statesno`, `number`) VALUES ('84', '5846549846');
INSERT INTO customer (`gender`, `birth`, `accountnum`, `accountID`, `addressID`, `fullnameID`, `phoneID`) VALUES ('nam', '2000', '12345678', 1, 1, 1, 1);

INSERT INTO shipment (`price`, `description`, `Id4`, `country`, `tax`) VALUES (150, 'fast and furious', 1, 'VN', 10);
INSERT INTO shipment (`price`, `description`, `Id2`, `city`, `timedesired`) VALUES (25, 'express', 1, 'HN', '1 days');
INSERT INTO shipment (`price`, `description`, `Id3`, `company`) VALUES (150, 'jame times', 1, 'Shopee');

INSERT INTO voucher (`name`, `expiresDate`, `Id2`, `quantity`) VALUES ('Your name', '12-12-2021', 1, 50);
INSERT INTO voucher (`name`, `expiresDate`, `Id2`, `quantity`) VALUES ('Your voice', '31-12-2021', 1, 5);

INSERT INTO `payment` VALUES (1,1,1,0,1,50,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,1,1,0,NULL,NULL,1,'VCB','2020',NULL,NULL,NULL,NULL),(3,1,1,0,NULL,NULL,NULL,NULL,NULL,1,'845854773','VISA','31-12-2021');
-- Payment thì user create nhé, mấy cái thừa ra thì set trong code thôi--  