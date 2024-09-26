<?php
  // This is an Apache mod_rewrite rule, not PHP.
  // However, you can achieve similar functionality using PHP headers.
  if ($_SERVER['REQUEST_URI'] == '/PATH-YOU-WANT-TO-RESTRICT' && $_SERVER['SERVER_PORT'] == 80) {
    header('Location: https://' . $_SERVER['SERVER_NAME'] . $_SERVER['REQUEST_URI']);
    exit;
  }
?>