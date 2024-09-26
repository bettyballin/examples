<?php
$haystack = "example.mp3";
if ( preg_match("~\.(mp3|wav)$~i", $haystack) ) {
    echo "It matches";
} else {
    echo "It doesn't match";
}
?>