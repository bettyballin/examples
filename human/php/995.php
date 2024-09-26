<?php

$_GET["page"] = "  9999   ";

function FILTER_VALIDATE_STRICT_INT($val) {
    return intval(urlencode($val)) === intval($val) ? intval($val) : false;
}

$args=array(
    'page'=>array(
        'filter'=>FILTER_CALLBACK,
        'options'=>"FILTER_VALIDATE_STRICT_INT"));
$ret=filter_var_array($_GET, $args);

var_dump($ret['page']);

?>