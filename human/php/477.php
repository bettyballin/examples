<?php
$path = '/home/user/orders/printing/';
$filename = 'example.xml'; // assuming you have a filename
$file = $path.$filename;

if ( !preg_match("#\.\./#", $file) ){
    /* write it */
    $xml = new SimpleXMLElement('<root/>'); // assuming you have an xml object
    $xml->save($file);
}
?>