<?php

class linusLogin_Database {
    // Assuming this class is already implemented
}

class linusLogin_Session implements SessionHandlerInterface {

    private $_database;

    public function __construct() {
        $this->_database = new linusLogin_Database;
    }

    public function open($savePath, $sessionName) {
        // Implementation required by SessionHandlerInterface
    }

    public function close() {
        // Implementation required by SessionHandlerInterface
    }

    public function read($sessionId) {
        // Implementation required by SessionHandlerInterface
    }

    public function write($sessionId, $sessionData) {
        // Implementation required by SessionHandlerInterface
    }

    public function destroy($sessionId) {
        // Implementation required by SessionHandlerInterface
    }

    public function gc($maxLifetime) {
        // Implementation required by SessionHandlerInterface
    }
}

$session = new linusLogin_Session;
session_set_save_handler($session, true);
session_start();

?>