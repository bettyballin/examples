<?php
$yourSecretKey = 'UPbztBfJEY7FjDjUZ7kd';
$fields = array(
    'ref' => 'toasty',
    'name' => 'toasta'
);
$hash = hash('sha512', $yourSecretKey . serialize($fields));

$fields['hash'] = $hash;

print_r($fields);
?>