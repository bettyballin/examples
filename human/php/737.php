$reflectionClass = new ReflectionClass($listener);
$reflectionProperty = $reflectionClass->getProperty('map');
$reflectionProperty->setAccessible(true);
$map = $reflectionProperty->getValue($listener);