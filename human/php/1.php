<?php

// Set cookie
setcookie("test_cookie", "Hello, World!", time() + 3600, "/", "", false, true);

// Set raw cookie
setrawcookie("test_raw_cookie", "Hello, World!", time() + 3600, "/", "", false, true);

// Print cookies
print_r($_COOKIE);

?>