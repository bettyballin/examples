<?php
session_start();
header('Location: thankyou.php?token=' . urlencode($_SESSION['new_token']), true, 303);
exit;