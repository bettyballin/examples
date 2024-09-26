def process_input(val_from_untrusted_source):
    if val_from_untrusted_source == 'something_we_except':
        # do something useful
        pass
    else:
        try:
            txt = str(val_from_untrusted_source)
        except UnicodeEncodeError:                # unicode string on Python 2
            txt = val_from_untrusted_source.encode(error = 'replace')
        except UnicodeDecodeError:                # byte string on Python 3
            txt = val_from_untrusted_source.decode(error = 'replace')
        except Exception:                         # quite weird but once we are there...
            txt = "object non convertible to string"
        if len(txt) > 47:     # limit length to 50
            txt = txt[:47] + '...'
        raise RuntimeError('unknown input: {}'.format(txt))

# Example usage:
try:
    process_input('something_we_except')
except RuntimeError as e:
    print(e)