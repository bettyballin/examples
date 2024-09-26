<?php
$testMode = true; // or false

if($testMode == true) {
    $dbname = 'testDB';
} else {
    $dbname = 'liveDB';
}

print($dbname);
?>