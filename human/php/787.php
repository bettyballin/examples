<?php

if(isset($_POST['submit'])){
   if(isset($_POST['answer']) && $_POST['answer'] == 4){

$answer=$_POST['answer'];

echo "The number is correct.";
echo "\n";
echo "The answer was in fact $answer";

echo "<br>";
echo "You have access." . "<a href='page.php'>Click here to go there now</a>";

// exit;

#Right answer was given continue with submitting form
}else{

echo "Sorry";
#The wrong answer was given give an error message.
   }
}
?>

<form action="" method="post">
<input type="text" name="answer" id="answer"  placeholder="2+2=?">
<input type="submit" name="submit" value="Submit" />

<?php if(isset($answer)) { echo "<br><br>" . $answer; } ?>

</form>