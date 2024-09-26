$httpResponse = $httpClient->execute($httpPost);
$httpEntity = $httpResponse->getEntity();
$xml = EntityUtils::toString($httpEntity);