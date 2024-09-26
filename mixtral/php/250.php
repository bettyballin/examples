public function rules()
{
    return [
        ['name', 'string'],
        [['is_admin'], 'integer', 'on' => self::SCENARIO_ADMIN],
    ];
}

public function scenarios()
{
    $scenarios = parent::scenarios();

    // Define scenario for admin users
    $scenarios[self::SCENARIO_ADMIN] = ['is_admin'];

    return $scenarios;
}