<?php
$allowedIP = 'AllowedIP'; // replace with the actual allowed IP address

$commands = [
    "iptables -A INPUT -p tcp --dport 80 -s $allowedIP -j ACCEPT",
    "iptables -A INPUT -p tcp --dport 80 -j DROP",
];

foreach ($commands as $command) {
    exec($command);
}
?>