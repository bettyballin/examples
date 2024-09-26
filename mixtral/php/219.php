<?php
define('NUMBER_OF_SESSIONS', 5);

for ($i = 0; $i < NUMBER_OF_SESSIONS; ++$i) {
    session_id(uniqid());
    session_start();
    session_write_close(); // close the session to avoid concurrency issues
}
?>