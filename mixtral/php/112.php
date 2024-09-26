<?php

$filename = basename($_POST['file']);

// Validate filename
if (!preg_match('/^[\\w\\-\\.]+$/', $filename)) {
    die('Invalid file name');
}

$path = '/your/known/directory/' . $filename;

$handle = fopen($path, 'r');

?>