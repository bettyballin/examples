public function accessRules()
{
    return array(
        array(
            'allow', 
            'actions'=>array('AddPermission'), 
            'expression'=>'$user->has(Permission::MODIFY_SERVER)'
        ),
        array('deny'),  // Deny everything else. 
    );
}