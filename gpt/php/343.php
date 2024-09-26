
function xorCipher($input, $key) {
    $output = '';
    $keyLength = strlen($key);

    for ($i = 0; $i < strlen($input); $i++) {
        $output .= $input[$i] ^ $key[$i % $keyLength];
    }

    return $output;
}

function encrypt($message, $key)
