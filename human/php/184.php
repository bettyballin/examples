<?php
session_start();

if (isset($_SESSION['pagedata'])) {
    $user_id = $_SESSION['pagedata']['user_id'];
    $user_type = $_SESSION['pagedata']['user_type'];
    $user_ssn = $_SESSION['pagedata']['user_ssn'];
    $user_first_name = $_SESSION['pagedata']['first_name'];
    $user_last_name = $_SESSION['pagedata']['last_name'];

    // use variables to do stuff
    echo "User ID: $user_id<br>";
    echo "User Type: $user_type<br>";
    echo "User SSN: $user_ssn<br>";
    echo "User First Name: $user_first_name<br>";
    echo "User Last Name: $user_last_name<br>";
} else {
    echo "Session data not set.";
}
?>