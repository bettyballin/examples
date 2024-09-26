<?php
require_once 'Zend/Filter/LocalizedToNormalized.php';
require_once 'Mage.php';

Mage::app();

$filter = new Zend_Filter_LocalizedToNormalized(
    array('locale' => Mage::app()->getLocale()->getLocaleCode())
);
$params['qty'] = $filter->filter($params['qty']);