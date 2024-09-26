<?php

$xml = '
<!DOCTYPE article PUBLIC "-//NLM//DTD JATS (Z39.96) Journal Publishing DTD v1.0 20120330//EN" "http://jats.nlm.nih.gov/publishing/1.0/JATS-journalpublishing1.dtd">
<article>
</article>
';

$dom = new DOMDocument();
$dom->resolveExternals = false;
$dom->loadXML($xml);

print_r($dom);

?>