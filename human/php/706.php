// components/WebUser.php
class WebUser extends CWebUser {
    public function has($permission) {
        $userId = Yii::app()->user->id;
        $sql = "SELECT * FROM user_permissions WHERE user_id = :user_id AND permission = :permission";
        $command = Yii::app()->db->createCommand($sql);
        $command->bindParam(":user_id", $userId);
        $command->bindParam(":permission", $permission);
        $result = $command->queryRow();
        return $result !== false;
    }
}