<?php

set_exception_handler(function (\Exception $e) {
    $trace = debug_backtrace();

    // Redact sensitive arguments
    foreach ($trace as &$frame) {
        if (isset($frame['args'])) {
            foreach ($frame['args'] as $key => $arg) {
                if (is_array($arg) && array_key_exists('password', $arg)) {
                    $frame['args'][$key] = ['password' => '[REDACTED]'];
                } elseif (is_string($arg) && strpos($arg, 'password') !== false) {
                    $frame['args'][$key] = '[REDACTED]';
                }
            }
        }
    }

    // Log or store the redacted trace
    error_log(json_encode($trace));
    echo "An error occurred. Please check the logs for more information.";
});

// Example usage:
try {
    throw new \Exception('Test exception');
} catch (\Exception $e) {
    // This will not be caught, but will trigger the exception handler
}