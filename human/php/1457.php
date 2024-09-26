<?php
function encrypt($stringData) {
  $ivMessage = "a";
  $apiSecret = "secret_key"; 

  $encrypted = false;
  $encrypt_method = 'AES-256-CBC';
  $iv = substr(hash('sha256', $ivMessage), 0, 16);
  $encrypted = openssl_encrypt($stringData, $encrypt_method, $apiSecret, 0, $iv);

  return $encrypted;
}

$stringData = '{"uid":19,"price":10000000,"duration":240,"credit_purpose":5,"new_tab":false,"cssFile":"kalkulatorok","css":[],"supported":false,"email":"test@test.hu","productType":"home_loan","method":"calculator","calculatorType":"calculator","unique":true}';
print(encrypt($stringData) . "\n");
?>