use Symfony\Component\Security\Csrf\CsrfTokenManagerInterface;

$container->setParameter('security.csrf.token_manager', $container->get(CsrfTokenManagerInterface::class));

$firewalls = [
    'secured_area' => [
        'form_login' => [
            'csrf_token_generator' => $container->getParameter('security.csrf.token_manager'),
        ],
    ],
];