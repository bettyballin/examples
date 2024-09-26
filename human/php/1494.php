<?php
function send_to_log(Throwable $e) {
    $noArgs = [
        'login' => true,
        'auth' => true,
        // ...
    ];

    $trace = $e->getTrace();
    foreach ($trace as &$err) {
        if (isset($noArgs[$err['function'] ?? ''])) {
            $cnt = count($err['args'] ?? []);
            if ($cnt > 0) {
                $err['args'] = array_fill(0, $cnt, 'REDACTED');
            }
        }
    }
    unset($err);

    var_dump($trace); /* This now shows "REDACTED" for all arguments
    to functions specified in the $noArgs array */

    // logging logic
}

try {
    throw new Exception('Test Exception');
} catch (Throwable $e) {
    send_to_log($e);
}