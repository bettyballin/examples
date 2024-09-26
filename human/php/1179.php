<?php
if (isset($_GET['id']) && $_GET['id'] != ''){
    $groepsindeling = $_GET['id'];
} elseif (isset($_GET['group'])) {
    $groepsindeling = $_GET['group'];
} else {
    $groepsindeling = '';
}