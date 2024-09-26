<?php
session_start();

if (!isset($_SESSION['stage']) || $_SESSION['stage'] < 2) {
    header('Location: stage1.php');
    exit;
}
else{
   echo "Stage 2 Content";
}

// At the end of each page increment your session variable for next stages
$_SESSION['stage']++;
?>