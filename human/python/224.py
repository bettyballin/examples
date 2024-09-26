import re

class Fail2BanConfig:
    def __init__(self):
        self.definitions = {}

    def add_definition(self, name, failregex, ignoreregex):
        self.definitions[name] = {
            'failregex': re.compile(failregex),
            'ignoreregex': re.compile(ignoreregex)
        }

    def parse_log(self, log_line):
        for name, definition in self.definitions.items():
            fail_match = definition['failregex'].search(log_line)
            if fail_match:
                return name
            ignore_match = definition['ignoreregex'].search(log_line)
            if ignore_match:
                return None
        return None

config = Fail2BanConfig()
config.add_definition('my_definition', r'<HOST> - - \[.*\] "(GET|POST).*HTTP.* 410', '')

# Test the config
log_line = '192.168.1.1 - - [01/Jan/2022:12:34:56 +0000] "GET / HTTP/1.1" 410'
result = config.parse_log(log_line)
print(result)