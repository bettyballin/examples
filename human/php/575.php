<?php
function load_template($file, array $vars){
  extract($vars);
  unset($file, $vars);
  require func_get_arg(0);
}

// example usage
load_template('example.php', ['name' => 'John', 'age' => 30]);
?>