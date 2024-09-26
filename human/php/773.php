That's not PHP code, it's Apache mod_rewrite configuration. However, here is the equivalent PHP code:


<?php
if ($_SERVER['HTTPS'] != 'on') {
    $redirect = 'https://' . $_SERVER['HTTP_HOST'] . $_SERVER['REQUEST_URI'];
    header('Location: ' . $redirect);
    exit;
}
?>