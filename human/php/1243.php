<?php
    $ch = curl_init();
    $url  = "https://192.168.100.100:444/appserver/j_spring_security_check";
    $postData = 'j_username=admin&j_password=demoserver';
    curl_setopt($ch, CURLOPT_URL,$url);
    curl_setopt($ch, CURLOPT_POST, 1); 
    curl_setopt($ch, CURLOPT_POSTFIELDS,$postData); 
    curl_setopt($ch, CURLOPT_HTTPHEADER, array(
        'Content-Type: application/x-www-form-urlencoded'
    )); 
    curl_setopt($ch, CURLOPT_COOKIEJAR, 'cookies.txt'); 
    curl_setopt($ch, CURLOPT_COOKIEFILE, 'cookies.txt'); 
    curl_setopt($ch, CURLOPT_HEADER, true); 
    curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false); 
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_FOLLOWLOCATION, true); 
    echo curl_exec ($ch);
    curl_close ($ch);
?>