<?php

class User extends \yii\db\ActiveRecord
{
    const SCENARIO_USER_SAVE = 'user-save';

    public function scenarios()
    {
        return [
            self::SCENARIO_USER_SAVE => ["field1", "field2"],
        ];
    }
}

// usage example
$user = new User();
$user->scenario = User::SCENARIO_USER_SAVE;
$user->field1 = 'value1';
$user->field2 = 'value2';
$user->save();