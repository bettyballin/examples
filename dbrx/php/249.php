<?php
// define the $client_id variable in the secure.php file
// secure.php:
// <?php $client_id = 'your_client_id_here'; ?>

// main script
require_once('path/to/secure.php');

// Now $client_id is available for use within this scope.
print($client_id);
?>