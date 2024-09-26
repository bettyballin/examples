class KafkaClient:
    SASL_MECHANISMS = ['PLAIN', 'GSSAPI', 'OAUTHBEARER']

    def __init__(self, config):
        self.config = config
        self.validate_config()

    def validate_config(self):
        if self.config['security_protocol'] in ('SASL_PLAINTEXT', 'SASL_SSL'):
            assert self.config['sasl_mechanism'] in self.SASL_MECHANISMS, (
                'sasl_mechanism must be in ' + ', '.join(self.SASL_MECHANISMS))

# Example usage
config = {
    'security_protocol': 'SASL_PLAINTEXT',
    'sasl_mechanism': 'PLAIN'
}

client = KafkaClient(config)