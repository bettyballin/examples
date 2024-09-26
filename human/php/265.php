<?php
$text = '[img]image.jpg[/img]';
$text = preg_replace("@\[img\](.*\.jpg)\[\/img\]@si",
                     "<img src=\"$1\" border=\"0\" />", $text);
echo $text;
?>