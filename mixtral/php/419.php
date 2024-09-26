<?php
if (!isset($_GET['abc']) || $_GET['abc'] != 1) {
    die('Invalid request');
}
// rest of your code
echo "Request is valid";
?>