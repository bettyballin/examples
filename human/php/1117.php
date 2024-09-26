<?php
/*
 * This is an Apache configuration snippet, not PHP code.
 * However, I can provide you with an equivalent PHP code that achieves the same functionality.
 */

// This code should be placed in a file that is executed by the web server,
// ideally in a configuration file or a middleware script.

function access_control() {
  if ($_SERVER['REMOTE_ADDR'] !== '127.0.0.1') {
    header('HTTP/1.1 403 Forbidden');
    exit;
  }
}

access_control();