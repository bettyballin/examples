<?php

function ph() {
    return new stdClass();
}

class stdClass {
    public function Throttle($ttl, $exit, $count, $proxy) {
        $ip = $_SERVER['REMOTE_ADDR'];
        $now = microtime(true);
        $key = 'throttle_'.$ip;

        if (!isset($_SESSION[$key])) {
            $_SESSION[$key] = array('requests' => 0, 'last_request' => $now);
        }

        $elapsed = $now - $_SESSION[$key]['last_request'];
        if ($elapsed > $ttl) {
            $_SESSION[$key]['requests'] = 0;
        }

        $_SESSION[$key]['requests'] += $count;
        $_SESSION[$key]['last_request'] = $now;

        if ($_SESSION[$key]['requests'] >= $exit) {
            return true;
        }

        return $_SESSION[$key]['requests'] / $ttl;
    }
}

$throttle = ph()->Throttle($ttl = 30, $exit = 60, $count = 1, $proxy = false);

if ($throttle === true)
{
    die('IP exceeded 30 requests in the last 60 seconds');
}

else
{
    usleep(intval(floatval($throttle) * 1000000));
}

?>