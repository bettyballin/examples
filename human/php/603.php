<?php
if(isset($_GET['site'])){
  if(validURL($_GET['site'])) {
     $f = fopen($_GET['site'], 'r');
     $html = '';
     while (!feof($f)) {
       $html .= fread($f, 24000);
     }
     fclose($f);
     echo $html;
  } else {
     echo "Invalid URL, please enter a valid web url (i.e: http://www.google.com)";
  }
}

function validURL($url){ 
   $pattern = "/^(http|https):\/\/([a-zA-Z0-9-]+\.)+[a-zA-Z]{2,}$/";
   return preg_match($pattern, $url);
}
?>