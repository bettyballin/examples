<?php

$item = json_decode(base64_decode($_REQUEST["item"]));

$timeout = 3600;

if($item->time < (time()-$timeout)){
  die("Invalid token - timeout");
}

if($item->token_id !== $_SERVER["REQUEST_URI"]){
  die("Invalid token - page url");
}

$secret ="ABC1232";
$valid = ($_REQUEST["signed"] === base64_encode(hash_hmac("sha256",json_encode($item),$secret,true)));

if(!$valid){
  die("Invalid token");
}

?>