<?php
$url = "http://example.com";
if (!filter_var($url, FILTER_VALIDATE_URL)) {
    echo("URL is not valid");
} else {
    // URL is validated and secure
    echo("URL is valid");
}
?>