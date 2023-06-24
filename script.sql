CREATE DATABASE BookStore

-- DROP DATABASE BookStore

USE BookStore

CREATE TABLE book_language (
    language_id INT IDENTITY,
    language_code VARCHAR(8),
    language_name VARCHAR(50),
    CONSTRAINT pk_language PRIMARY KEY (language_id)
);

CREATE TABLE book (
    book_id INT IDENTITY,
    title NVARCHAR(400),
    isbn13 VARCHAR(13),
    language_id INT,
    num_pages INT,
    publication_date DATE,
	author NVARCHAR(400),
    CONSTRAINT pk_book PRIMARY KEY (book_id),
    CONSTRAINT fk_book_lang FOREIGN KEY (language_id) REFERENCES book_language (language_id)
);


INSERT INTO book_language (language_code, language_name) VALUES
('eng', 'English'),
('vn', 'Vietnamese'),
('jp', 'Japanese')

INSERT INTO book (title, isbn13, language_id, num_pages, publication_date, author) VALUES
(N'Thỏ Bảy Màu Và Những Người Nghĩ Nó Là Bạn (Tái Bản 2023)', '9786048862886', 2, 216, '2023-09-01', N'HUỲNH THÁI NGỌC'),
(N'Tuổi Trẻ Đáng Giá Bao Nhiêu (Tái Bản 2021)', '8935235231115', 2, 291, '2021-10-04', N'Rosie Nguyễn')
