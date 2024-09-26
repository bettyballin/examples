
<?php
session_start();

// Check if the user is authenticated
if (!isset($_SESSION['user_authenticated']) || $_SESSION['user_authenticated']
