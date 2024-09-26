<?php
if(isset($_COOKIE['lang'])){
   $lang=$_COOKIE['lang'];
}else{
   $lang="english";
}

include ("translation/".$lang.".html");
?>