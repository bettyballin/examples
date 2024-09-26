<?php
$reason = "";
$reason = htmlspecialchars($reason, ENT_QUOTES, 'UTF-8');
echo("No reason specified: " . $reason);
?>