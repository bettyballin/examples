<?php
require_once('dynamicsclient.php');
$dynamicsClient = new dynamicsClient(0);

//prints the Parent Account name of the specified Contact ID
echo $dynamicsClient->sampleFunction("<CONTACTID>");
?>