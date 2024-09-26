<?php
$path = '/some/dir/prefix_'.$_GET['path'].'whatever';
$path = realpath($path);
if (($path !== false) && (strncmp('/dir/some/prefix_', $path, 17) === 0)) {
  // $path is fine
  echo "Path is fine: $path";
} else {
  echo "Path is not fine: $path";
}
?>