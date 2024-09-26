<?php

use Monolog\Logger;
use Monolog\Handler\StreamHandler;

class Log {
    private static $logger;

    public static function getLogger() {
        if (is_null(self::$logger)) {
            self::$logger = new Logger('my_logger');
            self::$logger->pushHandler(new StreamHandler('logs/app.log', Logger::DEBUG));
        }

        return self::$logger;
    }

    public static function info($message, array $context = array()) {
        self::getLogger()->info($message, $context);
    }

    public static function error($message, array $context = array()) {
        self::getLogger()->error($message, $context);
    }
}

// usage
class User {
    public $name;

    public function __construct($name) {
        $this->name = $name;
    }
}

$user = new User('John Doe');

Log::info('User logged in.', ['username' => $user->name]);

try {
    // some code...
    throw new Exception('Something went wrong!');
} catch (Exception $e) {
    Log::error($e->getMessage());

    throw $e;
}