<?php

namespace AppBundle\Configuration;

class SecurityConfiguration
{
    /**
     * @var Security[]
     */
    private $configurations;

    public function __construct(array $configurations)
    {
        $this->configurations = $configurations;
    }

    public function getExpression()
    {
        $expressions = [];
        foreach ($this->configurations as $configuration) {
            $expressions[] = $configuration->getExpression();
        }

        return implode(' and ', $expressions);
    }
}

class Security
{
    public function getExpression()
    {
        // You need to implement this method
        // For demonstration purposes, I'll just return a string
        return 'some_expression';
    }
}

$configurations = [new Security(), new Security()];
$securityConfig = new SecurityConfiguration($configurations);
echo $securityConfig->getExpression();