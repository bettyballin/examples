CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ssn_hash BINARY(32) NOT NULL UNIQUE
);

CREATE UNIQUE INDEX idx_ssn_hash ON users (ssn_hash);