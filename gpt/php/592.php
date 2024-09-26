
function safelyWriteConfig($key, $value) {
    // Ensure $key is a safe, expected config key; otherwise, abort
    $allowedKeys = ['key1', 'key2']; // Define your allowed keys here
    if (!in_array($key, $allowedKeys)) {
       
