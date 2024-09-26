<?php
function findCode($var) {
    $tokens = token_get_all('<?php ' . $var);
    foreach ($tokens as $token) {
        if (is_array($token)) {
            list($id, $text) = $token;
            switch ($id) {
                case T_FUNCTION:
                    return true; // found a function definition
                default: break;
            }
        } else {
            continue;
        }
    }
    return false; // no code detected
}

// Test the function
$code = 'function test() { echo "Hello World"; }';
var_dump(findCode($code));  // bool(true)

$code = 'echo "Hello World";';
var_dump(findCode($code));  // bool(false)
?>