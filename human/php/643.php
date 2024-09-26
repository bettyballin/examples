<?php

class SessionStorage {
    public function __construct() {
        if (session_id() != '') {
            session_start();
        }
        $_SESSION['HTTP_USER_AGENT'] = $_SERVER['HTTP_USER_AGENT'];
        $_SESSION['REMOTE_ADDR'] = $_SERVER['REMOTE_ADDR'];
    }

    public function isValid() {
        return $_SESSION['HTTP_USER_AGENT'] === $_SERVER['HTTP_USER_AGENT'] && $_SESSION['REMOTE_ADDR'] === $_SERVER['REMOTE_ADDR'];
    }

    public function __destruct() {
        session_write_close();
    }

    public function destroy() {
        setcookie(session_name(), null, time() - 86400);
        return session_destroy();
    }

    public function write(array $data) {
        foreach ($data as $key => $value) {
            $_SESSION[$key] = $value;
        }
    }

    public function exists() {
        foreach (func_get_args() as $arg) {
            if (!array_key_exists($arg, $_SESSION)) {
                return false;
            }
        }
        return true;
    }

    public function read($key) {
        if ($this->exists($key)) {
            return $_SESSION[$key];
        } else {
            throw new RuntimeException('Cannot access non-existing var ' . $key);
        }
    }
}

$session = new SessionStorage();
$session->write(array('foo' => 'bar'));

if ($session->isValid() === TRUE) {
    echo $session->read('foo'); // bar
} else {
    // Session hijack. Handle here
}

// To totally destroy a session:
$session->destroy();

?>