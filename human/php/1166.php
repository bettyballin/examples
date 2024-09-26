<?php
session_start();
$pdf_file = "{$_SERVER['DOCUMENT_ROOT']}/path-to-pdf-file/".$_SESSION['userId'].".pdf";
if( file_exists( $pdf_file ) )
{
  header( 'Cache-Control: public' );
  header( 'Content-Description: File Transfer' );
  header( "Content-Disposition: attachment; filename=".$_SESSION['userId'].".pdf" );
  header( 'Content-Type: application/pdf' );
  header( 'Content-Transfer-Encoding: binary' );
  readfile( $pdf_file );
  exit;
}
die( "ERROR: invalid song or you don't have permissions to download it." );
?>