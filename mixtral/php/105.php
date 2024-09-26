<?php

$sock = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);
if ($sock === false) {
    echo "socket_create() failed: reason: " .
        socket_strerror(socket_last_error()) . "\n";
    exit;
}

$bind = socket_bind($sock, '127.0.0.1', 80);
if ($bind === false) {
    echo "socket_bind() failed: reason: " .
        socket_strerror(socket_last_error()) . "\n";
    exit;
}

$listen = socket_listen($sock, SOMAXCONN);
if ($listen === false) {
    echo "socket_listen() failed: reason: " .
        socket_strerror(socket_last_error()) . "\n";
    exit;
}

?>