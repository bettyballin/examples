<?php
// Put the url they came from 
$ref = $_SERVER['HTTP_REFERER'];

if($ref !== 'http://mydomain.com/index.php') {
  die("Must come here from index");
 // uncomment below to redirect them automatically
 // header('location: index.php');
}
// Otherwise they came from index so show the page.
echo "Displaying about page:";
echo $content;
?>