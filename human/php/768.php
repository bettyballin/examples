<?php
defined('_JEXEC') or die;

function onAfterInitialise()
{
   $request = JFactory::getApplication()->input->get->get('ajaxGet', '', 'string');
   $admin = JFactory::getApplication()->isAdmin();

    if(  $request == "token" and $admin){
        echo json_encode(array("token" => JSession::getFormToken()));
        exit();
    }
}

onAfterInitialise();