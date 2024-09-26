<?php
$url = filter_var($_GET['page'], FILTER_VALIDATE_URL);

if ($url === false) {
    echo "Invalid URL input";
} else {
    echo "Valid URL input: $url";
}
?>