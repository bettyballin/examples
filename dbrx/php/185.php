<?php

function shutdown () {
    // Perform any last minute clean up here
    echo "Shutdown function was called.";
}

register_shutdown_function('shutdown');

?>