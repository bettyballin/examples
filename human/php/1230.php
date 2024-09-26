This is not PHP code, it's a YAML configuration file. However, I can provide you with the equivalent PHP code that defines the same service:


use Symfony\Component\DependencyInjection\Definition;
use Symfony\Component\DependencyInjection\Reference;

$definition = new Definition('AppBundle\\EventListener\\SecurityListener');
$definition->setParent('sensio_framework_extra.security.listener');
$definition->addTag('kernel.event_subscriber');

$container->setDefinition('app.security.listener', $definition);