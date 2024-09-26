<?php
session_start();

echo "Before regenerating session id: ".session_id()."<br>";
session_regenerate_id(true);
echo "After regenerating session id: ".session_id()."<br>";
?>