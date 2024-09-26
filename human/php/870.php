<?php
$remote_xml = "https://stackoverflow.com/opensearch.xml";

$dom = new DOMDocument();

if ($dom->load($remote_xml) !== FALSE)
    echo "loaded remote xml!\n";
else
    echo "failed to load remote xml!\n";

libxml_disable_entity_loader(true);
if ($dom->load($remote_xml) !== FALSE)
    echo "loaded remote xml after libxml_disable_entity_loader(true)!\n";
else 
    echo "failed to remote xml after libxml_disable_entity_loader(true)!\n";
?>