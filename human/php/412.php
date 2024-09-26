<?php

function test_libxml_noent($enabled) {
    if ($enabled) {
        libxml_disable_entity_loader(false);
    } else {
        libxml_disable_entity_loader(true);
    }

    $xml = file_get_contents('quadratic-blowup-2.xml');

    echo "Loaded file quadratic-blowup-2.xml into string.\n";
    echo "Mem: " . memory_get_usage() . " (Peak: " . memory_get_peak_usage() . ")\n";

    $dom = new DOMDocument();
    $start = microtime(true);
    $dom->loadXML($xml);
    $end = microtime(true);

    echo "DOMDocument loaded XML " . strlen($xml) . " bytes in " . ($end - $start) . " secs.\n";
    echo "Mem: " . memory_get_usage() . " (Peak: " . memory_get_peak_usage() . ")\n";

    unset($xml);
    echo "Removed load string.\n";
    echo "Mem: " . memory_get_usage() . " (Peak: " . memory_get_peak_usage() . ")\n";

    $xml = $dom->saveXML();
    echo "Got XML (saveXML()), length: " . strlen($xml) . "\n";

    $text = $dom->nodeValue;
    $start = microtime(true);
    $end = microtime(true);

    echo "Got Text (nodeValue), length: " . strlen($text) . "; " . ($end - $start) . " secs.\n";
    echo "Mem: " . memory_get_usage() . " (Peak: " . memory_get_peak_usage() . ")\n";
}

echo "LIBXML_NOENT disabled\n";
test_libxml_noent(false);

echo "\nLIBXML_NOENT enabled\n";
test_libxml_noent(true);