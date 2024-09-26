<?php

$userInput = $_POST['richText'];
$sanitizedHtml = htmlspecialchars($userInput, ENT_QUOTES, 'UTF-8');

?>