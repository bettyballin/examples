<?php
$allowedIps = array('127.0.0.1','::1');
if(!in_array($_SERVER['REMOTE_ADDR'],$allowedIps)){
    echo 'No jQuery for you';
}else{
    echo 'jQuery goodness to follow...';
}
?>