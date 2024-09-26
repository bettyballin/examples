<?php

function isSensitiveDataInTrace(Throwable $exception) {
   foreach ($exception->getTrace() as $frame) {
       if (isset($frame['args']) && is_array($frame['args'])) {
           // Check for sensitive data in the arguments
            return true;
        }
    }

  return false;
}

// Example usage:
try {
    throw new Exception('Test exception');
} catch (Throwable $e) {
    var_dump(isSensitiveDataInTrace($e));
}