<?php

require_once 'ESAPI.php';
require_once 'CustomEncoder.php';

use OWASP\ESAPI\ESAPI;

$esapi = new ESAPI();
$esapi->setEncoder(new CustomEncoder());

?>