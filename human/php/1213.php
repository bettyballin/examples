<?php
$a = serialize(array('a'=>'b', 'c'=>20));
var_dump(unserialize($a, array('allowed_classes'=>false)));
?>