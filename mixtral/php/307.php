<?php

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, "https://appserevr/j_spring_security_check");
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

$headers = array();
$headers[] = 'Content-type: application/x-www-form-urlencoded';

curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);

curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);

$data = 'j_username=admin&j_password=demoserver';

curl_setopt($ch, CURLOPT_POSTFIELDS, $data);

$result = curl_exec($ch);

if(curl_errno($ch))
{
    echo 'Curl error: '.curl_error($ch)."\n";
}
else
{
    if (curl_getinfo($ch, CURLINFO_HTTP_CODE) != 200) {
        $result = null;
    }
}

curl_close($ch);

?>