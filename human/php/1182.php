<?php
$string_to_be_signed = '<your_xml_string_here>';
$doc = new DOMDocument();
$doc->loadXML($string_to_be_signed);
echo base64_encode(sha1($doc->C14N(true)));
?>