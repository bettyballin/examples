<?php
// Set the session ID in a cookie
setcookie(session_name(), session_id(), time() + (86400 * 30), '/');
?>