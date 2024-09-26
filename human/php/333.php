<?php

$secret ="ABC1232";

$item = array(
  "time"=>time(),
  "token_id"=>"<page_url>"
);

$signed = base64_encode(hash_hmac("sha256",json_encode($item),$secret,true));
$item = base64_encode(json_encode($item));

$ajax_url = "myscript.php?signed=$signed&item=$item";

print($ajax_url);

?>