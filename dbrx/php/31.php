public function actions()
{
    return array(
        'captcha' => array(
            'class' => 'CCaptchaAction',
            'backColor' => 0xFFFFFF,
            'minLength' => 4,
            'maxLength' => 6,
            'width' => 150,
            'height' => 40,
            'testLimit' => 1,
            'transparent' => true,
            'fontFile' => Yii::getPathOfAlias('application.assets.fonts') . '/your_japanese_font.ttf',
        ),
    );
}