<?php
$config = new \Doctrine\ORM\Configuration();
$config->setSQLLogger(null);

// or

use Doctrine\ORM\Tools\Setup;

$paths = array("/path/to/entity-files");
$isDevMode = true;
$config = Setup::createAnnotationMetadataConfiguration($paths, $isDevMode, null, null, false);