<?php
$config = @parse_ini_file("./../../db.ini");
if ($config === false) {
    die("Error parsing ini file.");
}
print_r($config);
?>