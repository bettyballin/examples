
function custom_obfuscate($input) {
    $encoded = base64_encode($input);
    // Trim the output to 12 characters
    return substr($encoded, 0, 12);
}

function custom_deobfuscate($input) {
    $padded = str_pad($input, 16, '=', STR_PAD_RIGHT); // Base64 strings are typically padded to a length divisible by 4
    return base64_decode($padded);
}

$original_value = "your_value";
$obfuscated_value = custom_obfuscate($original_value);

// When you need to get the original value back
$deobfuscated_value = custom_deobfuscate($obfuscated_value);

