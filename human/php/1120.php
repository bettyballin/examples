<?php
/**
 * Only allow the whitelisted array keys to exist:
 *
 * @ref http://stackoverflow.com/a/36193403/2224584
 * @param array $input
 * @param array $allowedKeys
 * @return array
 */
function array_key_whitelist(array $input, array $allowedKeys = []): array
{
    $return = [];
    foreach ($allowedKeys as $key) {
        if (array_key_exists($key, $input)) {
            $return[$key] = $input[$key];
        }
    }
    return $return;
}

// Test the function
$input = ['a' => 1, 'b' => 2, 'c' => 3];
$allowedKeys = ['a', 'c'];
print_r(array_key_whitelist($input, $allowedKeys));