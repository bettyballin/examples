<?php

function containsPHP($input) {
    $pattern = '/\b(eval|exec|shell_exec|system|passthru|popen|proc_open|ini_set|assert|\$_GET|\$_POST|\$_COOKIE)\s*\(/i';

    if (preg_match($pattern, $input)) {
        return true;
    }

    return false;
}

// Test the function
$input = 'eval("echo Hello World!");';
echo containsPHP($input) ? 'True' : 'False';

?>