create database HMSSpring;
use HMSSpring;

// Run Spring boot Application First Then run below commands

// Fill Out roles table
insert into roles values(1, 'ROLE_USER');
insert into roles values(2, 'ROLE_ADMIN');

//Fill out Users Table
//Password : raghu
insert into users values(1, '$2a$10$JWpWhpWMBnAQKa7IU1hV6.Y8zuKFXBZiSwO6t6lYtjEKpeaTyv.S6', 'admin');
//Password : raghu
insert into users values(2, '$2a$10$JWpWhpWMBnAQKa7IU1hV6.Y8zuKFXBZiSwO6t6lYtjEKpeaTyv.S6', 'user');' 

// Provide Roles,  fill out user_roles
insert into user_roles values(2, 1);
insert into user_roles values(1, 2);