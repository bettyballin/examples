<?php
$_POST['message'] = filter_var($_POST['message'], FILTER_SANITIZE_STRING);
?>
<form action="" method="post">
    <input type="text" name="message" placeholder="Enter a message">
    <input type="submit" value="Submit">
</form>

<?php
if(isset($_POST['message'])){
    echo $_POST['message'];
}
?>