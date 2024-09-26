<?php
require_once 'app/Mage.php';
Mage::app();

$formKey = Mage::getSingleton('core/session')->getFormKey();
echo $formKey;
?>