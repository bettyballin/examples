use AppBundle\Menu\MenuBuilder;
use Symfony\Component\DependencyInjection\Reference;

$container->register('app.menu.builder', MenuBuilder::class)
    ->addArgument(new Reference('knp_menu.factory'))
    ->addArgument(new Reference('medapp_security.access.manager'));