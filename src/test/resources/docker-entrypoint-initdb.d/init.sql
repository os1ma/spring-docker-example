USE `mydb`;

CREATE TABLE `users` (
  `name` VARCHAR(255) NOT NULL,
  `age` int NOT NULL
);

INSERT INTO `users` (`name`, `age`) VALUES
('Alice', 20),
('Bob', 30);
