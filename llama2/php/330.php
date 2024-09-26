<?php
session_start();
header("Location: thankyou.php?token=" . $_SESSION['token']);
exit;
?>