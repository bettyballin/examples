<?php
function getParam($key, $default=null)
{
    return isset($_REQUEST[$key])? $_REQUEST[$key] : $default;
}

// Test the function
echo getParam('test', 'default value');

// To test with a query string, use the following URL: script.php?test=value
?>