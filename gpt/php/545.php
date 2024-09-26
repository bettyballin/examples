
public function actionUserProfileImage($filename)
{
    // Implement your authentication logic here
    // Ensure the current user is allowed to access the image

    if ($userIsAllowedToSeeImage) {
        $path = Yii::getPathOfAlias('application.protected.user_images') . '/' . $filename;

        if (file_exists($path)) {
            // Send the correct content type header
            $info = get
