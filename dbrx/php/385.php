class MyClass {
    public function __construct(\Psr\Container\ContainerInterface $container)
    {
        // ...
    }
}

// Usage:
$container = new \Psr\Container\Container();
$instance = new MyClass($container);