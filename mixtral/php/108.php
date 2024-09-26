<?php

define('APPLICATION_ENV', 'production');

if (defined('APPLICATION_ENV') && APPLICATION_ENV == 'development') {
    $devMode = true;
} else {
    $devMode = false;
}

$config = new stdClass();
$config->setDevMode = function($mode) use (&$config) {
    $config->devMode = $mode;
};

$config->setDevMode($devMode);

?>