<?php
require 'vendor/autoload.php';
use ParagonIE\SeedSpring\SeedSpring;

$prng = new SeedSpring('JuxJ1XLnBKk7gPAS');
$byte = $prng->getBytes(16);
var_dump(bin2hex($byte));