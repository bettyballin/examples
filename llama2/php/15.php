<?php
function filter_url($input) {
  return filter_var($input, FILTER_SANITIZE_URL);
}

$_GET = filter_url($_GET);
$_SERVER['QUERY_STRING'] = filter_url($_SERVER['QUERY_STRING']);
?>