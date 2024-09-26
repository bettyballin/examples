This is not PHP code, it's a YAML configuration file for a Symfony application. However, I can provide you with the equivalent PHP code that defines the services and imports the configuration files:


use Symfony\Component\DependencyInjection\Loader\Configurator\ContainerConfigurator;
use Symfony\Component\DependencyInjection\ContainerBuilder;

return function (ContainerConfigurator $configurator) {
    $configurator->import('config.yml');
    $configurator->import('security_debugging.yml');

    $services = $configurator->services();

    $services->set('my.debugging.exception_listener')
        ->class('My\Bundle\AppBundle\EventListener\DebuggingExceptionListener')
        ->tag('kernel.event_listener', ['event' => 'kernel.exception']);

    $services->set('my.debugging.access_listener')
        ->class('My\Bundle\AppBundle\EventListener\DebuggingAccessListener')
        ->tag('kernel.event_listener', ['event' => 'kernel.request', 'method' => 'onKernelRequest'])
        ->arg('$authorizationChecker', service('security.authorization_checker'))
        ->arg('$tokenStorage', service('security.token_storage'));
};


Note that this code uses the new Symfony 5.3+ syntax for defining services. If you're using an older version of Symfony, the syntax may be different.