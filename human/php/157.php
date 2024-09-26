<?php
    $salt1 = '2348SDasdf!^*__';
    $salt2 = '_a35j@*#(lsdf_';
    $password = $_POST['password'];
    $hashed_password = sha1($salt1.$password.$salt2); 
    print($hashed_password);
?>
<form action="" method="post">
    <input type="password" name="password">
    <input type="submit">
</form>