<?php
$dom = new DOMDocument();
$dom->resolveExternals = false;
$dom->loadXML('<root><![CDATA[<!DOCTYPE foo [<!ENTITY % foo "bar">]>]]></root>', LIBXML_NOERROR);
?>