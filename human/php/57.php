<?php
$path = '/thisisa"quote/helloworld/';
$path = implode('/', array_map('rawurlencode', explode('/', $path)));
print($path);
?>