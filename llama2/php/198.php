<?php
class linusLogin_Session {
    public function __construct() {
        // Regenerate session ID on every request
        session_regenerate_id();

        // Start the session
        session_start();
    }
}

$login_session = new linusLogin_Session();
?>