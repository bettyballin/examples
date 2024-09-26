
<?php

if (isset($_GET['command'])) {
    // Sanitize the command input
    $command = escapeshellarg($_GET['command']);

    // Execute the command
    exec("php $command", $output, $return_var);

    // Process the output or return_var as needed
}
?>

