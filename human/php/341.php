<?php
function sanitize($str)
{
  $str = trim($str);

  if (get_magic_quotes_gpc())
    $str = stripslashes($str);

  return htmlentities(mysql_real_escape_string($str));
}

// usage example
$string = "Hello, World!";
echo sanitize($string);
?>