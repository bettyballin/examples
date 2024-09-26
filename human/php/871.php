<?php
libxml_disable_entity_loader(false);
$doc = new DOMDocument();
if ($doc->load('https://stackoverflow.com/opensearch.xml')) {
    echo "loaded remote xml!";
} else {
    echo "failed to load remote xml!";
}
libxml_disable_entity_loader(true);
$doc = new DOMDocument();
if ($doc->load('https://stackoverflow.com/opensearch.xml')) {
    echo "loaded remote xml after libxml_disable_entity_loader(true)!";
} else {
    echo "failed to remote xml after libxml_disable_entity_loader(true)!";
}
?>