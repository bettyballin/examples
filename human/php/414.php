<?php
$userallowed = "12345,67890"; // example allowed user IDs
$personid = "12345"; // example person ID to check

if ( stripos($userallowed, $personid) !== false ) {
    // $personid is found in $userallowed
    echo("allowed");
} else {
    echo("not allowed");
    die();
}
?>