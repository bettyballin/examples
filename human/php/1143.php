<?php
function getImg($url){
    $curl = curl_init($url);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
    $data = curl_exec($curl);
    curl_close($curl);
    return $data;
}

$url = "http://inspiring-photography.com/wp-content/uploads/2012/04/Culla-bay-rock-formations-Isle-of-Uist.jpg";
$raw = getImg($url);
$im = imagecreatefromstring($raw);
$width = imagesx($im);
$height = imagesy($im);
echo $width." x ".$height;
?>