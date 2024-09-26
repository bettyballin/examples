public function behaviors()
{
    return [
        'access' => [
            'class' => \yii\filters\AccessControl::className(),
            'rules' => [
                // allow authenticated users
                [
                    'allow' => true,
                    'roles' => ['@'],
                    'matchCallback' => function ($rule, $action) {
                        return Yii::$app->user->can('updateOwnProfile') ||
                            (Yii::$app->user->identity->is_admin &&
                             !in_array($this->id . '/' . $this->action->id, ['/site/signup', '/site/login']));
                    },
                ],
                // everything else is denied
            ],
        ],
    ];
}