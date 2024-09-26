<?php
$unsafeJSON = '{"name": "John", "age": 30, "city": "New York"}';
$safeJSON = json_encode(json_decode($unsafeJSON));
print($safeJSON);
?>