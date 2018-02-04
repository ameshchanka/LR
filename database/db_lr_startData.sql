INSERT INTO `lr`.`crm_roles` (`id`, `role`)
VALUES
(1, 'admin'),
(2, 'manager'),
(3, 'user');

INSERT INTO `lr`.`crm_users` (`id`, `name`, `email`,
`password`, `phoneNumber`, `skype`, `telegram`, `viber`)
VALUES
(1, 'NameAdmin', 'admin@admin.com', '123456789',
 '+375291111111', 'admin_skype', 'admin_telegram', 'admin_viber'),
(2, 'NameManager', 'manager@mail.com', '123456789',
'+375292222222', 'manager_skype', 'manager_telegram', 'manager_viber'),
(3, 'NameUser', 'user@user.com', '123456789',
'+375293333333', 'user_skype', 'user_telegram', 'user_viber');

INSERT INTO `lr`.`crm_users_roles` (`user_id`, `role_id`)
VALUES
(1, 1), (1, 2), (1, 3)
(2, 2), (2, 3),
(3, 3);

INSERT INTO `lr`.`addr_countries` (`id`, `name`)
VALUES
(1, 'Belarus');

INSERT INTO `lr`.`addr_cities` (`id`, `name`, `country_id`)
VALUES
(1, 'Minsk', 1);

INSERT INTO `lr`.`addr_streets` (`id`, `name`, `city_id`)
VALUES
(1, 'Prititskogo', 1),
(1, 'Pobediteley', 1);

INSERT INTO `lr`.`addr_addresses` (`id`, `street_id`, `objectNumberStr`)
VALUES
(1, 1, '65'),
(1, 2, '29');
