<?php
$mySavedSecret = 'your_secret_key_here'; // replace with your secret key

$secret = $_POST['secret']; //use post or get

if($secret != $mySavedSecret){
    die('intruder!!');
}
?>