<?php
session_start();
if (isset($_SESSION['user']) && $_SESSION['user'] == 'verified') {
    include('secret-content.html');
} else {
    echo "Sorry access not granted!";
}
?>