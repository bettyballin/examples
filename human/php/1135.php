<?php
if (!preg_match('/^[0-9]{1,6}$/', $_GET['id']))  {
    echo 'ID disallowed.';
}
?>