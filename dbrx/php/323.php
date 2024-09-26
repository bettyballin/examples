<?php

$content = file_get_contents('user_uploaded_file.html');
$filtered_content = strip_tags($content, '<p><a><img>');

echo $filtered_content;

?>