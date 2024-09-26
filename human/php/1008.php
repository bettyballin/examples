<?php
//10 minute session, forces https only and attempts to set the httponly flag
session_set_cookie_params(600, '/', '.domain.com', true, true);
session_start();
?>