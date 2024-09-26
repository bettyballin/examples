<?php

use Zend\Http\Header;

class ContentSecurityPolicy extends Header {}

class MergeableContentSecurityPolicy extends ContentSecurityPolicy
{
    protected $directives = array();

    public function __construct($directives)
    {
        $this->directives = $directives;
    }

    public function addDirective($directive)
    {
        if (!in_array($directive, $this->directives)) {
            $this->directives[] = $directive;
        }

        return $this;
    }

    public function getFieldValue()
    {
        // Merge directives into a single policy
        $policy = implode('; ', array_unique($this->directives));

        return 'Content-Security-Policy: ' . $policy;
    }
}

// Example usage
$directives = ['default-src *', 'script-src https://example.com'];
$csp = new MergeableContentSecurityPolicy($directives);
$csp->addDirective('style-src https://example.net');
echo $csp->getFieldValue();

?>