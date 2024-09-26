<?php
function security_hash($ip_address) {
    return hash('sha256', $ip_address);
}

class Input {
    function ip_address() {
        return $_SERVER['REMOTE_ADDR'];
    }
}

$input = new Input();
$token = security_hash($input->ip_address());
print($token);
?>