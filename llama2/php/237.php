function passwords_match_check($hashed_pw, $conf_hashed_pw){
    global $errors;
    if($_POST['password'] != $_POST['conf_password']){
        $errors['pws_no_match'] = "Passwords do not match";
    }
}

// Example usage:
$errors = array();
if(isset($_POST['submit'])){
    passwords_match_check($_POST['password'], $_POST['conf_password']);
    if(count($errors) > 0){
        foreach($errors as $error){
            echo $error . "<br>";
        }
    } else {
        // Passwords match, proceed with registration/login logic
    }
}