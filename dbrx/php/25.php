<?php
session_start();
if (!isset($_SESSION['loggedIn'])) {
    die('Access denied');
}
?>

<script>
    // Your JavaScript code here...
</script>