<?php
if (is_array($_COOKIE['name'])) {
    echo "Error: 'name' cookie is an array.";
} else {
   echo $_COOKIE['name'];
}
?>