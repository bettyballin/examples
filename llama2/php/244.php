<?php
$question = "What is your favorite color?";
$answer = "blue";
$salt = "some_random_string";
$hashedAnswer = md5($answer . $salt);

// Send the hashed answer and question to JavaScript
echo "<script>var question='" . addslashes($question) . "'; var hashedAnswer='" . $hashedAnswer . "';</script>";
?>