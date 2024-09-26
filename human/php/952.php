<?php

// Database connection settings
$host = 'localhost';
$dbname = 'translations';
$username = 'root';
$password = '';

// Create a PDO instance
$pdo = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);

// Create tables
$pdo->exec('
    CREATE TABLE IF NOT EXISTS Language (
        id INT AUTO_INCREMENT,
        name VARCHAR(255),
        PRIMARY KEY (id)
    );
');

$pdo->exec('
    CREATE TABLE IF NOT EXISTS Phrase (
        id INT AUTO_INCREMENT,
        label VARCHAR(255),
        PRIMARY KEY (id)
    );
');

$pdo->exec('
    CREATE TABLE IF NOT EXISTS Translations (
        language_id INT,
        phrase_id INT,
        translation VARCHAR(255),
        PRIMARY KEY (language_id, phrase_id),
        FOREIGN KEY (language_id) REFERENCES Language(id),
        FOREIGN KEY (phrase_id) REFERENCES Phrase(id)
    );
');

// Insert data
$pdo->exec('
    INSERT INTO Language (id, name) VALUES
        (1, "English"),
        (2, "Chinese");
');

$pdo->exec('
    INSERT INTO Phrase (id, label) VALUES
        (1, "header"),
        (2, "description");
');

$pdo->exec('
    INSERT INTO Translations (language_id, phrase_id, translation) VALUES
        (1, 1, "Header"),
        (1, 2, "Description"),
        (2, 1, "头"),
        (2, 2, "描述");
');