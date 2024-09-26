<?php
$favorites = [['id'=> 1, 'type'=>'product'], ['id'=>2, 'type'=>'category']];
setcookie('user_fav', json_encode($favorites));
?>