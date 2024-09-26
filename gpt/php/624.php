
   $imagick = new Imagick('uploaded.gif');
   $imagick = $imagick->coalesceImages();

   foreach ($imagick as $frame) {
       // Perform operations like resizing
       $frame->thumbnailImage($newWidth, $newHeight, true);
   }

   $imagick = $
