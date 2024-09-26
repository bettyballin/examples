use Symfony\Component\Security\Core\Role\RoleHierarchy;

$roleHierarchy = new RoleHierarchy([
    'ROLE_ADMIN' => ['ROLE_USER'],
    'ROLE_SUPER_ADMIN' => ['ROLE_ADMIN'],
]);