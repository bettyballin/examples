<?php
session_start();

$errors = array();

function passwords_match_check($hashed_pw, $conf_hashed_pw){
    global $errors;
    if($hashed_pw != $conf_hashed_pw){
        $errors['pws_no_match'] = "Passwords do not match";
    }
}

if(isset($_POST['submit'])){
    $hashed_pw = password_hash($_POST['password'], PASSWORD_DEFAULT);
    $conf_hashed_pw = password_hash($_POST['conf_password'], PASSWORD_DEFAULT);
    passwords_match_check($hashed_pw, $conf_hashed_pw);
    // rest of your code...
}

// example form
?>
<form action="" method="post">
    <input type="password" name="password" placeholder="Password">
    <input type="password" name="conf_password" placeholder="Confirm Password">
    <input type="submit" name="submit" value="Submit">
</form>

<?php
// display errors
if(!empty($errors)){
    foreach($errors as $error){
        echo $error . "<br>";
    }
}
?>