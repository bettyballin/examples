<?php
session_start();
//Check nonce against session
if(isset($_POST) && $_POST["nonce"] === $_SESSION["csrf"]){
    //save data
    //redirect
    echo "Nonce is valid!";
    // Add your save data and redirect logic here
} else {
    echo "Nonce is invalid!";
}

//generate new nonce for form
$_SESSION["csrf"] = uniqid(mt_rand(),true);
?>

<form method="post" action="<?php echo $_SERVER['REQUEST_URI'] ?>">
    <input type="hidden" name="nonce" value="<?php echo $_SESSION['csrf']; ?>"/>
    <!-- other form fields -->
    <input type="text" name="name" placeholder="Name">
    <input type="email" name="email" placeholder="Email">
    <!-- submit button -->
    <button type="submit">Submit</button>
</form>