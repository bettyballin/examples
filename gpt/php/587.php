
if (!filter_var($to, FILTER_VALIDATE_EMAIL) || (isset($bcc) && !filter_var($bcc, FILTER_VALIDATE_EMAIL))) {
    return 'Invalid email address';
    return false;
}

