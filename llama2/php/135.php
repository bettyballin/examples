<?php
ob_start(); // Start output buffering

// Your script goes here

$buffer = ob_get_contents(); // Get the contents of the buffer

if (strpos($buffer, '<?php') === false) {
    // If there is no PHP code in the buffer allow it to be sent to the browser
    echo $buffer;
} else {
    // If there is PHP code in the buffer, do not send it to the browser
    // You can log the attempt, send an error message, or take other actions
    echo "Error: PHP code detected in the output.";
}

ob_end_flush(); // End output buffering
?>