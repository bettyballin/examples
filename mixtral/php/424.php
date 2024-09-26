<?php

function sanitizeBacktrace(Throwable $e) {
    // Implement your sanitization logic here
    return $e;
}

class ErrorHandler {
    public function isSensitiveDataInTrace(Throwable $e) {
        // Implement your sensitive data check logic here
        return false;
    }
}

$errorHandler = new ErrorHandler();

set_error_handler(function ($errno, $errstr, $errfile, $errline) {
    // Your code to handle the error
    echo "Error: $errstr in $errfile on line $errline\n";
});

set_exception_handler(function (Throwable $e) use ($errorHandler) {
    // Your custom logging and handling
    if($errorHandler->isSensitiveDataInTrace($e)) {
        $e = sanitizeBacktrace($e);
    }
    throw $e;
});

?>