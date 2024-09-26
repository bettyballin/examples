
$text = preg_replace("@\[img\](https?://.*\.(jpg|jpeg|png|gif))\[\/img\]@siU", "<img src=\"$1\" alt=\"\" />", $text);

