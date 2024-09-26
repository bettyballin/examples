<?php
function set_cookie($name,$content,$time){
$http_only = true;
$secure = true;
$path = "/";
$domain = ".example.com"; // Include All Subdomains
setcookie($name,$content,$time,$path,$domain,$secure,$http_only);
}

set_cookie("ABC_user", "", time() + 3600);
?>