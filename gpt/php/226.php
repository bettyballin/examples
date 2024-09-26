
<?php

class Database {
    private $db;

    public function __construct() {
        try {
            $this->db = new PDO("mysql:host=localhost;dbname=test", "root", "");
            // Set PDO to throw exceptions
            $this->db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch (PDOException $e) {
            die("Database connection failed: " . $e->getMessage());
        }
    }

    public function preparedQuery($sql, $parameters = []) {
        try {
            $stmt = $this->db->prepare($sql);

            foreach
