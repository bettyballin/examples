<?php

if (strtolower(gethostname()) !== 'myserver') {
    header('HTTP/1.0 404 Not Found');
    exit();
}

// Your code here
echo "Hello, World!";

?>