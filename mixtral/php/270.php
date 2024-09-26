<?php

$kernel->getContainer()->setParameter('cache_dir', getenv("CACHE_PATH"));

// Or if you are not in a Symfony 4+ application

if ($container->hasDefinition(CacheWarmer::class)) {
    $definition = $container->findDefinition(CacheWarmer::class);

    // Set the cache directory
    $cacheDir = getenv("CACHE_PATH");

    if (!empty($cacheDir) && is_dir($cacheDir)) {
        $definition
            ->addMethodCall('setDebug', [false])
            ->replaceArgument(0, new DefinitionDecorator('filesystem'))
            ->findTaggedServiceIds('kernel.cache_warmer');
    }
}