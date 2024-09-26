<?php
libxml_disable_entity_loader(true);
$xml = <<<XML
<!DOCTYPE root [
  <!ENTITY c SYSTEM "/etc/passwd">
]>
<root>&c;</root>
XML;

$dom = new DOMDocument();
$dom->loadXML($xml, LIBXML_NOENT);
print $dom->saveXML();
?>