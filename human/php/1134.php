<?php
if (!preg_match('/^[0-9]+$/', $_GET['id']))  { 
    echo 'ID disallowed.';
}
?>