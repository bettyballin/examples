<?php

class Site {
    // implementation of Site class
}

class YourClass {
    private $sites;

    public function __construct() {
        $this->sites = new \Doctrine\Common\Collections\ArrayCollection();
    }

    public function getSites() {
        return $this->sites;
    }

    public function isOwner(Site $site) {
        return $this->getSites()->contains($site);
    }
}

$yourObject = new YourClass();
$site = new Site();

// Add site to collection for demonstration purposes
$yourObject->getSites()->add($site);

var_dump($yourObject->isOwner($site));