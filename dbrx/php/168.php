<?php

function shutdown()
{
    $error = error_get_last();
    
    if ($error !== null) {
        // Log the non-sensitive part of the error here.
        echo "Error: {$error['type']} - {$error['message']}";
        
        // You can also send an email or perform other actions as needed.
    }
}

register_shutdown_function('shutdown');

// Trigger a fatal error
trigger_error("This is my custom E_ERROR", E_ERROR);

?>