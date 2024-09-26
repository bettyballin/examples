<?php 
session_start();

if($_SERVER['REQUEST_METHOD']=='POST'){
    if(isset($_SESSION['security']) && 
       isset($_SESSION['security_key']) && 
       !empty($_POST[$_SESSION['security_key']]) && 
       $_POST[$_SESSION['security_key']] == $_SESSION['security'])
    {
        /* forms post is from domain as session would 
           not have been started and security would not have been set */
        echo 'good';
    }else{
        /* forms post is not from domain */
        echo 'bad';
    }
    $_SESSION['security_key'] = sha1(microtime(true)+1);
    $_SESSION['security'] = sha1(microtime(true));
}else{
    $_SESSION['security_key'] = sha1(microtime(true)+1);
    $_SESSION['security'] = sha1(microtime(true));
}
?>

<form method="POST" action="">
  <input type="hidden" name="<?=$_SESSION['security_key'];?>" value="<?=$_SESSION['security'];?>"/>
  <p><input type="text" name="Text" size="20"><input type="submit" value="Submit"></p>
</form>