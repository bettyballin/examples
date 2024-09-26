<?php
$i = 0;
$hash = '';
while ($i < 1000) {
    $hash = hash('sha256', $hash . $i);
    $i++;
}
print($hash);
?>