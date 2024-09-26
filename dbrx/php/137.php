<?php
class linusLogin_Session {
    function open($save_path, $name) {
        return true;
    }
    function close() {
        return true;
    }
    function read($id) {
        return '';
    }
    function write($id, $data) {
        return true;
    }
    function destroy($id) {
        return true;
    }
    function gc($maxlifetime) {
        return true;
    }
}

$handler = new linusLogin_Session();
session_set_save_handler($handler, true);
session_name('llSSID');
session_start();

// ... later in the script ...
session_write_close(); // close session before outputting anything to prevent locking issues
?>