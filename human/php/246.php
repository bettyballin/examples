<?php
// array of pages
$paginas = array(
    'principal' => 'pag.php',
    'perfil' => 'secure.php'
);

$id = (int)$_GET['id'];

if ( isset( $paginas[$id] ) && file_exists($paginas[$id]) ) {
    require( $paginas[$id] );
}
else {
    require('home.php');
}
?>