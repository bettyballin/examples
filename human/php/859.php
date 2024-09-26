<?php

function login($password) {
    $attempts = 0;
    $wait_time = 2;
    while (true) {
        if ($password != 'correct_password') {
            $attempts++;
            echo "Wrong password! Wait $wait_time seconds...\n";
            sleep($wait_time);
            $wait_time += 2;
        } else {
            echo "Login successful!\n";
            break;
        }
        $password = readline("Enter password: ");
    }
}

$password = readline("Enter password: ");
login($password);

?>