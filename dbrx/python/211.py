from kafka import KafkaProducer

producer = KafkaProducer(
    bootstrap_servers=['brokerCName:9093'],
    security_protocol='SASL_SSL',
    ssl_cafile='pemfilename.1.pem',
    sasl_mechanism='PLAIN',  # or 'SCRAM-SHA-256' if supported by the library
    sasl_plain_username='username',
    sasl_plain_password='password'
)