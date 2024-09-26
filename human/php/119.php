public static function entropy() {
   $h = 0; $p = 0;
   for ($i = 0; $i < count($this->count); $i++){
      $p = $this->count[$i]/($this->totalChars*1.0);
      $h -= $p*log($p)/log(2);
   }
   return $h;
}