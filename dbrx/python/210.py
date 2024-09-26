from kafka import KafkaProducer

producer = KafkaProducer(
    bootstrap_servers=['brokerCName:9093'],
    security_protocol='SASL_SSL',
    ssl_cafile='pemfilename.pem',
    sasl_mechanism='OAUTHBEARER'
)