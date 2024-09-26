public function rules()
{
    return [
        [['name'], 'string'],
        // Only allow is_admin field for admin users
        [['is_admin'], 'integer', 'on' => 'admin'],
    ];
}