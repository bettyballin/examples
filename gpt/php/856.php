
<?php 
  if(isset($_GET['view-source'])){ 
    $flag = "FLAG{**********}"; 
    if(preg_match('/f|l|a|g/i', $_GET['view-source'])) exit("Don't try it!"); 
    echo $_GET['view-source']; 
  } 
  echo " "; 
  highlight_file(__FILE__); 
?>

