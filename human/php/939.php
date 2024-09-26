<?php

class User {
    public function sendNotification($message) {
        // implementation to send notification
        echo "Notification sent: $message\n";
    }

    public function takeCoins($amount) {
        // implementation to take coins
        echo "Took $amount coins\n";
    }
}

$user = new User();
$user->sendNotification("You got 500");
if (connection_aborted()) {
    exit(0);
}
$user->takeCoins(200);

?>