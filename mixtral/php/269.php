<?php

// Assuming $kernel and $container are already initialized

$cache_path = '/path/to/cache'; // Replace with your actual cache path

$kernel->getContainer()->setParameter('kernel.cache_dir', $cache_path);

// Or if you are not in a Symfony 4+ application

$container = $this->getContainer();

$config = array(
    'parameters' => array(
        'cache_path' => $cache_path
    )
);

if (isset($config['parameters']['cache_path'])) {
    $container->setParameter('kernel.cache_dir', $config['parameters']['cache_path']);
}