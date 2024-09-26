<?php
//Check if user has permission
if(isset($_COOKIE["allow_access"]))
{
    //delete access after visiting the page
    setcookie("allow_access","",time()-3600);
}
else
{
    header("location: index.html");
    exit;
}
?>