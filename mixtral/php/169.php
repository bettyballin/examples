public function save(){
    $folderWriteAble = is_writable($this->destination);

    // Get file extension
    $fileExtension = pathinfo($_FILES[$this->key]['name'], PATHINFO_EXTENSION);

    if ($folderWriteAble && (exif_imagetype($this->fileData) == IMAGETYPE_JPEG)
        && in_array(strtolower($fileExtension), ['jpg', 'jpeg'])) {

         $name = $this->destination . '/' . $this->fileName;
         $success = move_uploaded_file($this->fileData, $name);
    } else {
        trigger_error("Cannot write to " . $this->destination . " or file is not a valid image.");
        $success = false;
    }

     return $success;
}