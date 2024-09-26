
class FileUploader {

    protected $fileName;
    protected $fileData;
    protected $destination;

    public function __construct($key){
        $this->fileName = $_FILES[$key]['name'];
        $this->fileData = $_FILES[$key]['tmp_name'];
    }

    public function saveIn($folder){
        $this->destination = $folder;
    }

    public function save(){
        // Check if the folder is writable
        $folderWriteAble = is_writable($this->destination);
        
        // Check if the file is a JPEG image
        $isJPEG = exif_imagetype($this->fileData) == IMAGETYPE_JPEG;
        
        // Get the file extension
        $fileExtension = strtolower(pathinfo($this->fileName, PATHINFO_EXTENSION));
        
        // Define allowed extensions
        $allowedExtensions = ['jpg', 'jpeg'];

        // Check if the extension is allowed and the file is a JPEG image
