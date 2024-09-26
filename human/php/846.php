<?php

$mysqli = new mysqli("localhost", "username", "password", "database");

if ($mysqli->connect_errno) {
    echo "Failed to connect to MySQL: (" . $mysqli->connect_errno . ") " . $mysqli->connect_error;
    exit();
}

if(isset($_GET['map_loc'])) {
    $code = $_GET['map_loc'];

    $query = "SELECT ttc.continent_id, c.name FROM territories_to_continents ttc
                INNER JOIN continents c
                ON ttc.continent_id = c.continent_id
                WHERE ttc.code = ?
                LIMIT 1";

    if($stmt = $mysqli->prepare($query)){
        $stmt->bind_param('s', $code);
        $stmt->execute();
        $stmt->bind_result($continent_id, $mapLoc);
        $stmt->fetch();
        $stmt->free_result();
        $stmt->close();
    }
}
$mysqli->close();

?>