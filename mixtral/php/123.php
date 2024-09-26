<?php
if(isset($_GET['page'])) {
    $file = basename($_GET['page']);

    if(!preg_match('/^[a-zA-Z0-9]+$/', $file))
        die('Invalid page');

    if(file_exists($file . '.php'))
        include($file . '.php');
    else
        die('Page not found');
}
?>