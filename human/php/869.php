<?php
$oldValue = libxml_disable_entity_loader(true);
// do whatever XML-processing related
libxml_disable_entity_loader($oldValue);
?>