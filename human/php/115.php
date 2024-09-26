<?php
    session_start();
    $csrfToken = md5(uniqid(mt_rand(),true)); 

    $_SESSION['csrfToken'] = $csrfToken;
?>

<form action="formHandler.php">
   <input type="hidden" name="csrfKey" value="<?php echo $csrfToken ?>" />
</form>