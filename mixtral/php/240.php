<?php
$url = $_POST['userInput'];

if (filter_var($url, FILTER_VALIDATE_URL)) {
    echo "The input contains a valid URL";
} else {
    echo "Invalid or malicious input";
}
?>