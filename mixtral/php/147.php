<?php
session_start();

if(isset($_GET['file']))
{
    $filename = basename($_GET['file']);

    // full file path
    $full_path = '/home/test/user-data/' . $_SESSION['user']['account_id'] .'/downloads/' .$filename;

    if(strpos($full_path, realpath('/home/test/user-data/' .$_SESSION['user']['account_id']. '/downloads')) === 0)
    {
        // rest of your code
    }
}
?>