
class User extends \yii\db\ActiveRecord
{
    const SCENARIO_USER_UPDATE = 'userUpdate';
    const SCENARIO_ADMIN_UPDATE = 'adminUpdate';

    public function scenarios()
    {
        $scenarios = parent::scenarios();
        $scenarios[self::SCENARIO_USER_UPDATE] = ['name']; // Only 'name' can be edited
        $scenarios[self::SCENARIO_ADMIN_UPDATE] = ['name', 'is_admin']; // 'name' and 'is_admin' can be edited
        return $scenarios;
    }

    public function rules()
    {
        return [
            ['name', 'string'],
            ['is_admin', 'integer'],
            // Other rules...
        ];
    }
}

