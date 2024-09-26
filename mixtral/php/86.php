<?php
$ip = $_SERVER['REMOTE_ADDR'];

// Check if IP address has exceeded login limit
if ($stmt = $mysqli->prepare("SELECT COUNT(*) as count FROM `login_attempts` WHERE ip_address=? AND last_failed_time > DATE_SUB(NOW(), INTERVAL 1 HOUR)")) {
    // Bind parameters
    $stmt->bind_param('s', $ip);

    if ($stmt->execute()) {
        // Get result
        $result = $stmt->get_result();

        while($row = $result->fetch_assoc())
            $failedAttemptCount = (int)$row['count'];

        if ($failedAttemptCount >= 5)
             die("Too many failed login attempts. Please try again later.");
    }
}
?>