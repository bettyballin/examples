<?php
ini_set('session.gc_maxlifetime', 360); // Session expires after 6 minutes

// Or set it in php.ini

// Lifetime in seconds of cookie or if 0 until browser is restarted
ini_set('session.cookie_lifetime', 180);
session_start();