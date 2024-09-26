<?php

use Symfony\Component\Routing\RouteCollection;
use Symfony\Component\Routing\Route;

$collection = new RouteCollection();

$collection->add('mybundle_contact_advertiser', new Route('/ad/contact/{id}', array(
    '_controller' => 'MyBundle:Default:contactAdvertiser',
)));

return $collection;