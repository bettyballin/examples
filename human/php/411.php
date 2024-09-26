<?php
$s = '<!DOCTYPE kaboom [
<!ENTITY a "a">
<!ENTITY b "&a;&a;">
<!ENTITY c "&b;&b;">
<!ENTITY d "&c;&c;">
<!ENTITY e "&d;&d;">
<!ENTITY f "&e;&e;">
<!ENTITY g "&f;&f;">
<!ENTITY h "&g;&g;">
<!ENTITY i "&h;&h;">
<!ENTITY j "&i;&i;">
]>
<kaboom>&j;</kaboom>';

$doc = new DOMDocument();
$doc->loadXML($s);

foreach ($doc->childNodes as $child) {
    if ($child->nodeType===XML_DOCUMENT_TYPE_NODE) {
        $doc->removeChild($child);
        break;
    }
}

assert($doc->doctype===NULL);
assert($doc->lastChild->nodeValue==='...');

echo $doc->saveXML();

var_dump($doc->C14N());
?>