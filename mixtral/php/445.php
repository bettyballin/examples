<?php
header("X-XSS-Protection: 1; mode=block");
header("X-Content-Type-Options: nosniff");
header('X-Frame-Options: SAMEORIGIN');
?>