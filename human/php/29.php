<?php
// mostly pulled from http://snippets.dzone.com/posts/show/2738
function MakeSafe($unsafestring) 
{
    $unsafestring= htmlentities($unsafestring, ENT_QUOTES);

    if (get_magic_quotes_gpc()) 
    { 
        $unsafestring= stripslashes($unsafestring); 
    }

    $unsafestring= trim($unsafestring);
    $unsafestring= strip_tags($unsafestring);
    $unsafestring= str_replace("\r\n", "", $unsafestring);

    return $unsafestring;
} 

// Call a function to make sure the variables you are 
// pulling in are not able to inject sql into your 
// sql statement causing massive doom and destruction.

if(isset($_POST["user"]) && isset($_POST["pwd"])){
    $name = MakeSafe( $_POST["user"] );
    $pwd = MakeSafe( $_POST["pwd"] );

    // As suggested by cagcowboy: 
    // You should NEVER store passwords decrypted.
    // Ever.  
    // sha1 creates a hash of your password
    // pack helps to shrink your hash
    // base64_encode turns it into base64
    $pwd = base64_encode(pack("H*",sha1($pwd)));

    // Example usage:
    echo "Safe Name: $name\n";
    echo "Safe Password: $pwd\n";
} else {
    echo "Please provide user and password.";
}
?>