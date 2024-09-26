<?php

function doStuff() {
    // Your function code here
    echo "Doing stuff...\n";
}

if (array_key_exists('HTTP_ORIGIN', $_SERVER)) {
    if (preg_match('#^https?://myserver.com$#', $_SERVER['HTTP_ORIGIN'])) {
        doStuff();
    }
} elseif (array_key_exists('HTTP_X_REQUESTED_WITH', $_SERVER) &&
        (strtolower($_SERVER['HTTP_X_REQUESTED_WITH']) == 'xmlhttprequest')) {
    doStuff();
}

?>