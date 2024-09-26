<?php
$ipWhiteList = array(
    'XX.XXX.XXX.XXX', // teammate1,
    'YY.YYY.YYY.YYY', // teammate2
);
if(!in_array($_SERVER['REMOTE_ADDR'],$ipWhiteList)){
    die('Access Denied!');
}
?>