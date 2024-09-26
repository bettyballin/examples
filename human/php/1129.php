<?php

function get_query_var($var) {
  $uri = $_SERVER['REQUEST_URI'];
  $parts = explode('/', $uri);
  $last_part = end($parts);
  return $last_part;
}

$a = get_query_var('action');
echo $a; //prints **add**

?>