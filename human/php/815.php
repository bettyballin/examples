<?php
DEFINE ('DB_USER', 'xxx');
DEFINE ('DB_PASSWORD', 'xxx');  
DEFINE ('DB_HOST', 'xxx');
DEFINE ('DB_NAME', 'xxx');

$mysqli = @mysqli_connect (DB_HOST, DB_USER, DB_PASSWORD, DB_NAME) 
OR die("could not connect");

if(isset($_POST['submit'])){
  //This is the directory where images will be saved 
  $target = "images/"; 
  $target = $target . basename( $_FILES['photo']['name']); 
  $ok=1;

  $fake=mysqli_real_escape_string($mysqli,$_POST['fake']);
  $name=mysqli_real_escape_string($mysqli,$_POST['name']);
  $champname=mysqli_real_escape_string($mysqli,$_POST['champname']);
  $cat=mysqli_real_escape_string($mysqli,$_POST['category']);
  $username=mysqli_real_escape_string($mysqli,$_POST['username']);

  $pic=($_FILES['photo']['name']);
  $photo_size=$_FILES["photo"]["size"];

  if ($photo_size > 350000)
  {
    echo "Your file is too large.<br>";
    $ok=0;
    echo "<a href='upload.php'>Click here to try again.</a>";
    exit;
  } 

  if(mysqli_query($mysqli,"INSERT INTO `submissions` (fake, name, champname, cat, username, pic) VALUES ('$fake','$name','$champname', '$cat', '$username', '$pic')")){
    echo "success!";
  } else {
    echo "an error occured saving your data!";
  }

  if(move_uploaded_file($_FILES['photo']['tmp_name'], $target)) 
  { 
    echo "The file ". basename( $_FILES['photo']['name']). " has been succesfully uploaded to return click below."; 
  } 
  else { 
    echo "Sorry, there was a problem uploading your file."; 
  }

} 
?>

<form action="" method="post" enctype='multipart/form-data'>
Name: <input type="text" name = "name"><br>
Username: <input type="text" name = "username"><br>
Champ name: <input type="text" name = "champname"><br>
Category: <input type="text" name = "category"><br>
Fake: <input type="text" name = "fake"><br>
Image: <input name="photo" type="file"><br> 
<input type="submit" value="Add" name="submit"> 
</form>