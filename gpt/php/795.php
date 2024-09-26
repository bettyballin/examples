
   public function getAuthKey()
   {
       return $this->auth_key; // Make sure this matches the property name exactly
   }

   public function validateAuthKey($authKey)
   {
       return $this->auth_key === $authKey; // Same here, match the property name
   }
   
