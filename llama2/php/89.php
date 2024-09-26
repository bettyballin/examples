<?php
class Database {
    private static $instance;

    private function __construct() {}

    public static function instance() {
        if (!self::$instance) {
            self::$instance = new self();
        }
        return self::$instance;
    }

    public function prepare($query) {
        $mysqli = new mysqli("localhost", "username", "password", "database");
        return $mysqli->prepare($query);
    }
}

class MyClass {
    public function updateDatabase($value) {
        $stmt = Database::instance()->prepare(
            'UPDATE myTable
             SET myColumn = ?
             WHERE foo = "bar"'
        );
        $stmt->bind_param('s', $value);
        $stmt->execute();
    }
}

$obj = new MyClass();
$obj->updateDatabase("test");
?>