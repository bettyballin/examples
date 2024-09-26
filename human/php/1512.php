<?php
session_start();

// assuming $output is already defined

if(isset($_SESSION['secure']) && $_SESSION['secure']) {
    echo json_encode($output);
    $_SESSION['secure'] = false;
}
?>