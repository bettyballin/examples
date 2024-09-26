<?php
$arr = $_POST['arraywithdata'];
if (!is_array($arr)) {
    echo "Error: Input is not an array.";
    exit;
}
?>