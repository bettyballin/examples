<?php
/**
 * @link http://stackoverflow.com/q/24526493/367456
 */

$xml = <<<XML
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE article PUBLIC "-//NLM//DTD JATS (Z39.96) Journal Publishing DTD v1.0 20120330//EN" "http://jats.nlm.nih.gov/publishing/1.0/JATS-journalpublishing1.dtd">
<article/>
XML;

/* own entity loader */
libxml_set_external_entity_loader(function() {
  var_dump(func_get_args()); // just for demonstrating purposes
  return NULL;
});

$doc = new DOMDocument;
$doc->loadXML($xml, LIBXML_DTDLOAD);

echo "----\n";

/* restore default entity loader */    
libxml_set_external_entity_loader(NULL);

$doc = new DOMDocument;
$doc->loadXML($xml, LIBXML_DTDLOAD);