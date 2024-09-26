<?php

class ContainerAware {}

interface FactoryInterface {}

class SecurityAccessManager {}

class MenuBuilder extends ContainerAware
{
    /**
     * @var FactoryInterface
     */
    private $factoryInterface; 
    private $securityAccessManager;

    public function __construct(FactoryInterface $factoryInterface, SecurityAccessManager $securityAccessManager)
    {  
        $this->factoryInterface = $factoryInterface;   
        $this->securityAccessManager = $securityAccessManager;

    }
}

$factoryInterface = new class implements FactoryInterface {};
$securityAccessManager = new SecurityAccessManager();
$menuBuilder = new MenuBuilder($factoryInterface, $securityAccessManager);