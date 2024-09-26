<?php
$connection = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');

$hash = isset($_GET['hash']) ? $_GET['hash'] : null;
$id = (int) $_GET['id'];

if (isset($hash) && (md5($id) == $hash)) { 
    $delete = $connection->prepare("DELETE FROM `users` WHERE `id` = :id");
    $delete->execute(['id' => $id]);
    if($delete->rowCount() > 0){
       echo 'SUCCESS';
    }else{
       echo 'ERROR';
    }
} else {
    $hash = md5($id); 
    echo 'Do you really want to delete this article? <a href="http://my.website.com/panel/articles/delete.php?id=' . $id . '&hash=' . $hash .'">yes</a>';
}
?>