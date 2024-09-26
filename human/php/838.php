<?php
$username = "Zameer";
$email = "zameer.khan@email.com";
$password = "thisiszameer";

if (stripos($password, $username) !== false) {
    echo "Password contains username";
}
else if (stripos($password, $email) !== false) {
    echo "Password contains email";
}
else {
    echo "Does not contain username or email";
}
?>