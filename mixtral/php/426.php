function sanitizeBacktrace(Throwable $exception) {
   foreach ($exception->getTrace() as &$frame) {
       if (isset($frame['args']) && is_array($frame['args'])) {
           // Sanitize the arguments
           array_walk($frame['args'], function (&$arg, $key) use(&$frame){
               if(isSensitiveData($arg)){
                   $frame['args'][$key] = '***';
               }
           });
       }
   }

   return $exception;
}

function isSensitiveData($data) {
    // Implement your logic to determine if data is sensitive
    // for demonstration purposes, consider all strings as sensitive
    return is_string($data);
}

// Example usage
try {
    throw new Exception('Test');
} catch (Throwable $e) {
    $sanitizedException = sanitizeBacktrace($e);
    print_r($sanitizedException->getTrace());
}