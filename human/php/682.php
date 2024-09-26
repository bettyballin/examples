<?php
$input = '2 + 3 * 4'; // example input
$tokens = token_get_all("<?php {$input}");
$expr = '';

foreach($tokens as $token){

  if(is_string($token)){

    if(in_array($token, array('(', ')', '+', '-', '/', '*'), true))
      $expr .= $token;

   continue;   
  }

  list($id, $text) = $token;

  if(in_array($id, array(T_DNUMBER, T_LNUMBER)))
    $expr .= $text;
}

$result = eval("return {$expr};");
print($result);
?>