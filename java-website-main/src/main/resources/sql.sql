CREATE DATABASE IF NOT EXISTS website;
USE website;

CREATE TABLE IF NOT EXISTS book (
  id BIGINT(20) NOT NULL,
  description VARCHAR(255) DEFAULT NULL,
  image_url VARCHAR(255) DEFAULT NULL,
  title VARCHAR(255) DEFAULT NULL,
  author VARCHAR(255) DEFAULT NULL,
  year VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO book (id, description, image_url, title) VALUES
(0, '[value-2]', 'https://m.media-amazon.com/images/I/51U7p8diEDL._AC_UF1000,1000_QL80_.jpg', '[value-4]'),
(1, 'VBA Structual Book', 'https://m.media-amazon.com/images/I/51U7p8diEDL._AC_UF1000,1000_QL80_.jpg', 'Tài liệu'),
(2, 'Tall Building', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7TcsS2npL74LRJlKRWKeit2vsS4FWjd8sdQ&s', 'Tài liệu'),
(3, 'Reinforcement concrete design EC2', 'https://media.springernature.com/w158/springer-static/cover-hires/book/978-3-319-52033-9?as=webp', 'Tài liệu'),
(4, 'Manual Detailing', 'https://m.media-amazon.com/images/I/616LUQoT79L._AC_UF1000,1000_QL80_.jpg', 'Tài liệu'),
(5, 'How design EC2', 'https://image.isu.pub/120112063936-d1a2f513dedd45b783b5607fe9e0ed86/jpg/page_1_thumb_large.jpg', 'Tài liệu');

CREATE TABLE IF NOT EXISTS course (
  id BIGINT(20) NOT NULL,
  description VARCHAR(255) DEFAULT NULL,
  title VARCHAR(255) DEFAULT NULL,
  discounted_price DOUBLE NOT NULL,
  original_price DOUBLE NOT NULL,
  course_type INT(11) DEFAULT NULL,
  img_url VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO course (id, description, title, discounted_price, original_price, course_type, img_url) VALUES
(1, 'Description for course 1', 'Course 1', 100, 150, 1, 'https://cloudinary-marketing-res.cloudinary.com/images/w_1000,c_scale/v1679921049/Image_URL_header/Image_URL_header-png?_i=AA'),
(2, 'Description for course 2', 'Course 2', 120, 160, 1, 'https://cloudinary-marketing-res.cloudinary.com/images/w_1000,c_scale/v1679921049/Image_URL_header/Image_URL_header-png?_i=AA'),
(3, 'Description for course 3', 'Course 3', 140, 180, 1, 'https://cloudinary-marketing-res.cloudinary.com/images/w_1000,c_scale/v1679921049/Image_URL_header/Image_URL_header-png?_i=AA'),
(4, 'Description for course 4', 'Course 4', 110, 170, 2, 'https://cloudinary-marketing-res.cloudinary.com/images/w_1000,c_scale/v1679921049/Image_URL_header/Image_URL_header-png?_i=AA'),
(5, 'Description for course 4', 'Course 4', 110, 170, 2, 'https://cloudinary-marketing-res.cloudinary.com/images/w_1000,c_scale/v1679921049/Image_URL_header/Image_URL_header-png?_i=AA'),
(6, 'Description for course 4', 'Course 4', 110, 170, 2, 'https://cloudinary-marketing-res.cloudinary.com/images/w_1000,c_scale/v1679921049/Image_URL_header/Image_URL_header-png?_i=AA'),
(7, '[value-2]', '[value-3]', 0, 0, 1, 'https://cloudinary-marketing-res.cloudinary.com/images/w_1000,c_scale/v1679921049/Image_URL_header/Image_URL_header-png?_i=AA'),
(8, '[value-2]', '[value-3]', 0, 0, 2, 'https://cloudinary-marketing-res.cloudinary.com/images/w_1000,c_scale/v1679921049/Image_URL_header/Image_URL_header-png?_i=AA');

ALTER TABLE course MODIFY id BIGINT(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

