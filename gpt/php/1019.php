
function removeSensitiveDataFromTrace($trace) {
    $keysToObfuscate = ['password', 'secret']; // Define your sensitive parameter names

    foreach ($trace as &$frame) {
        if (isset($frame['args'])) {
            foreach ($frame['args'] as &$arg) {
                if (is_array($arg)) {
                    foreach ($arg as $key => &$value) {
                        if (in_array($key, $keysToObfuscate, true)) {
                            $value = '***'; // Obfuscate sensitive data
                        }
                    }
                }
            }
        }
    }
    unset($frame); // Break the reference with the last element

    return $trace;
}

try {
    // Your code that may throw an exception
    throw new Exception("Error Processing Request");
} catch (Exception $e) {
    $trace = $e->get
