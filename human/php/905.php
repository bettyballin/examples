<?php

class AppKernel extends Kernel
{
    public function registerBundles()
    {
        $bundles = array(
            // your bundles here
        );

        if (in_array($this->getEnvironment(), array('dev', 'test'))) {
            // your dev and test bundles here
            # Bundle only activated in dev and test environments
            $bundles[] = new Acme\DevBundle\AcmeDevBundle();
        }

        return $bundles;
    }
}