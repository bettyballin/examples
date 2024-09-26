<?php
if(isset($_POST['submit'])){
   if(isset($_POST['answer']) && $_POST['answer'] == 4){
      echo "The number is correct.";
   }else{
      echo "Sorry, try again.";
   }
}
?>

<form action="" method="post">
   <input type="text" name="answer" id="answer" placeholder="2+2=?">
   <input type="submit" name="submit" value="Submit" />
</form>