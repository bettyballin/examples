<?php
$reason = filter_var($_REQUEST['reason'], FILTER_SANITIZE_STRING);
echo('Proceed');
?>