<?php

use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\DependencyInjection\ContainerAwareTrait;
use Symfony\Component\DependencyInjection\ContainerInterface;

class LoginController
{
    use ContainerAwareTrait;

    protected function renderLogin(array $data)
    {
        if (false === $this->container->get('security.context')->isGranted('IS_AUTHENTICATED_ANONYMOUSLY')) {
            return new RedirectResponse('/', 403);
        }

        $template = sprintf('FOSUserBundle:Security:login.html.%s', $this->container->getParameter('fos_user.template.engine'));

        return $this->container->get('templating')->renderResponse($template, $data);
    }
}

// assuming you have a ContainerInterface instance
$container = new ContainerInterface();

$controller = new LoginController();
$controller->setContainer($container);

$data = []; // your data here

$response = $controller->renderLogin($data);

// send the response
$response->send();