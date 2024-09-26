<?php
use yii\helpers\Url;

$userModelId = /* assign the user model ID here */;

echo '<img src="' . Url::to(['controller-id/action-image', 'id' => $userModelId]) . '" alt="Profile Picture">';