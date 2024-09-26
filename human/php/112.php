<?php
if(isset($_POST['submit_button_name'])){
    $email = htmlentities($_POST['email_address_field_name'], ENT_QUOTES);
    $handle = fopen("email_list.txt", "a");
    fwrite($handle, "\n".$email);
    fclose($handle);
}
?>

<form action="" method="post">
    <input type="email" name="email_address_field_name" placeholder="Enter your email address">
    <input type="submit" name="submit_button_name" value="Submit">
</form>