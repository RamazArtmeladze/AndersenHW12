-- Create User table
CREATE TABLE IF NOT EXISTS users (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create Ticket table
CREATE TABLE IF NOT EXISTS tickets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ticket_type VARCHAR(255) NOT NULL,
    ticket_class VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    user_id BIGINT,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);