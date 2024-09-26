<?php

function hideSensitiveData($args) {
    foreach ($args as &$arg) {
        if (is_string($arg)) {
            $arg = str_repeat('*', strlen($arg));
        }
        
        // You can add more conditions here to filter out other types 
        // of sensitive data such as arrays or objects.
    }

    return $args;
}

function myFunction() {
    try {
        throw new Exception('An error occurred');
    } catch (Exception $e) {
        echo 'Caught exception: ' . $e->getMessage() . "\n";
        
        // Filter out the sensitive data before logging it
        $trace = debug_backtrace();
        foreach ($trace as &$frame) {
            if (!empty($frame['args'])) {
                $frame['args'] = hideSensitiveData($frame['args']);
            }
        }

        print_r(array_map(function($frame) { 
          return array_intersect_key(
              $frame, 
              array_flip(['file', 'line', 'function'])
          ); 
        }, $trace));
    }
}

myFunction('secret', 'non-sensitive');