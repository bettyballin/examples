use Symfony\Component\DependencyInjection\Definition;
use Symfony\Component\DependencyInjection\Reference;

$definition = new Definition('AppBundle\Services\SecurityAccessManager');
$definition->addArgument(new Reference('security.authorization_checker'));
$definition->addArgument(new Reference('security.token_storage'));

$container->setDefinition('app_security.access.manager', $definition);