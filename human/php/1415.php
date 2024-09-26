<?php
const PICTURES_DIR = '/path/to/pictures/';
$files = scandir(PICTURES_DIR, SCANDIR_SORT_ASCENDING);
print_r($files);
?>