<?php
$userInput = 'Hello, <a href="#">world</a>! This is a <b>test</b> with <i>italic</i> text.';
$userComment = strip_tags($userInput, '<a><b><i>');
echo htmlspecialchars($userComment);
?>