<?php
$input = "da39a3ee5e6b4b0d3255bfef95601890afd80709";
if (strlen($input) === 40 && ctype_xdigit($input)) {
    echo "$input is a valid hexadecimal number of length 20 bytes i.e an SHA-1 hash.";
} else {
    echo "$input is not a valid hexadecimal number of length 20 bytes i.e not an SHA-1 hash.";
}
?>