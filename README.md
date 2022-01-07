# book-list

REST application that allows storing books, authors and books that one is reading. Supports CRUD operations. Base url -> http://localhost:8080/book-list

Stack: Spring Boot, JdbcTemplate, PostgreSQL, Docker, Lombok

Set up instructions:

docker run --name book_list -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=root -e POSTGRES_DB=book_list -d postgres:alpine

CREATE TABLE authors (
				id BIGSERIAL NOT NULL,
				full_name VARCHAR(255) NOT NULL,
				CONSTRAINT authors_pk PRIMARY KEY (id),
				CONSTRAINT authors_full_name_uq UNIQUE (full_name)
				);

CREATE TABLE books (
				id BIGSERIAL NOT NULL,
				title VARCHAR(255) NOT NULL,
				author_id BIGINT NOT NULL,
				status VARCHAR(255) NOT NULL CHECK(status IN ('not_reading', 'in_progress', 'done')),
				CONSTRAINT books_pk PRIMARY KEY (id),
				CONSTRAINT books_authors_fk FOREIGN KEY (author_id) REFERENCES authors(id)
                );

CREATE TABLE reading_books (
						book_id BIGINT NOT NULL,
						start_date DATE NOT NULL,
						end_date DATE,
						CONSTRAINT reading_books_pk PRIMARY KEY (book_id),
						CONSTRAINT reading_books_books_fk FOREIGN KEY (book_id) REFERENCES books(id)
                        );
