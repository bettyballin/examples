<?php
if (!preg_match('/^[a-zA-Z0-9]+$/', $_GET['id'])) {
    // Invalid id handle error
    echo "Invalid id!";
    exit;
} else {
    // Valid id, proceed with the script
    echo "Valid id!";
}
?>