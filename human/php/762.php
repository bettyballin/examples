<?php
$csrf_key = 'your_csrf_key_here';
?>

<form action="path/to/handler/page" method="post">
    <!-- form input elements -->
    <input type="hidden" name="csrf_key" value="<?php echo $csrf_key; ?>">
    <input type="hidden" name="csrf_token" value="<?php echo $_SESSION[$csrf_key]; ?>">
</form>