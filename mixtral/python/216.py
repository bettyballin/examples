class RuntimeException(Exception):
    pass

def validate_and_sanitize(input):
    # Implement your own sanitization logic here
    return input

def somefunc(val_from_untrusted_source):
    if val_from_untrusted_source == 'something_we_expect':
        # do something useful
        pass
    else:
        sanitized = validate_and_sanitize(val_from_untrusted_source)
        raise RuntimeException('unknown input: {}'.format(sanitized))

try:
    somefunc('something_we_expect')
    somefunc('something_malicious')
except RuntimeException as e:
    print(e)