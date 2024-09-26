<?php
$jsonFavorites = $_COOKIE['user_fav'];
if (!empty($jsonFavorites)) {
    $decodedFavorites = json_decode($jsonFavorites, true);
    var_dump($decodedFavorites);
} else {
    echo "No favorites found.";
}
?>