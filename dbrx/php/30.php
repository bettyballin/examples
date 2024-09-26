<?php
$this->widget('CCaptcha', array(
    'imageOptions' => array(
        'width' => 150,
        'height' => 40,
        'clickableImage' => true,
        'captchaAction' => 'site/captcha',
        'testLimit' => 1
    )
));
?>