You've provided Apache configuration directives, not PHP code. Here is the corrected version:


<?php
// This is not a PHP code, it's Apache configuration directives
?>

# You can put this in your Apache configuration file (e.g., .htaccess)
Order deny,allow
Deny from all

<Files "file.php">
    Allow from all
</Files>