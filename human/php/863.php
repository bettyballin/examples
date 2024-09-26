<?php
$map = array('bar' => 'bar.php');
if (!isset($map[$_GET['foo']])) {
    throw new \Exception();
}
include($map[$_GET['foo']]);
?>