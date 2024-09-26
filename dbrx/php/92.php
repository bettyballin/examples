<?php

// Start an output buffer
ob_start();

// Your PHP code here...
echo "Hello, World!";

// Send buffered content to client
echo ob_get_clean();

?>