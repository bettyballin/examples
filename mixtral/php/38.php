<?php
$hash = 'da39a3ee5e6b4b0d3255bfef95601890afd80709';
if(preg_match('/^[a-fA-F0-9]{40}$/', $hash)) {
    echo 'This is a valid SHA1 hash';
} else {
    echo 'This is not a valid SHA1 hash';
}
?>