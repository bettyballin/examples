<?php
$something = "Hello, World!";
echo htmlspecialchars(urlencode(json_encode($something)));
?>