<?php
$url = $_SERVER['HTTP_HOST'] . $_SERVER['REQUEST_URI'];
if ($url == "http://mysite.com") {
    // display mp3 player
    echo "<!-- mp3 player code here -->";
} else {
    // don't display mp3 player
    echo "<!-- no mp3 player -->";
}
?>