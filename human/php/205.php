<?php

$yourSegment1 = 'some_id';
$yourSegment2 = 'some_status';
$yourSegment3 = 'some_author';

class Database {
    private $host = 'localhost';
    private $username = 'your_username';
    private $password = 'your_password';
    private $database = 'your_database';

    public function __construct() {
        $this->db = new mysqli($this->host, $this->username, $this->password, $this->database);
    }

    public function query($sql, $params) {
        $stmt = $this->db->prepare($sql);
        $stmt->bind_param('sss', $params[0], $params[1], $params[2]);
        $stmt->execute();
        $result = $stmt->get_result();
        return $result;
    }
}

$db = new Database();

$sql = "SELECT * FROM some_table WHERE id = ? AND status = ? AND author = ?";

$result = $db->query($sql, array($yourSegment1, $yourSegment2, $yourSegment3));

while ($row = $result->fetch_assoc()) {
    print_r($row);
}