<?php
function validate_ip($ipaddress) {
    if(filter_var($ipaddress, FILTER_VALIDATE_IP)) return $ipaddress;
    else return "Unknown";
}

// Test the function
$ip = "192.168.1.1";
echo validate_ip($ip);

$ip = "256.1.1.1";
echo "\n" . validate_ip($ip);
?>