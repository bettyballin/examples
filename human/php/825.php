<?php
$range = array('options'=>array('default'=>1, 'min_range'=>0, 'max_range'=>10));
$id = filter_input(INPUT_GET, 'id', FILTER_VALIDATE_INT, $range);
print($id);
?>