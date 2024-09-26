<?php

function checkdate_input($date) {
    if (isset($date) && checkdate(...sscanf($date, "%d-%d-%d"))) {
        return $date;
    } else {
        return "Invalid date";
    }
}

$date = $_GET['date'] ?? '2022-12-31'; // default date for testing
echo checkdate_input($date);

?>