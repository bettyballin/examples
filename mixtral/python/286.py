from confluent_kafka import Producer

conf = {
    'bootstrap.servers': '<brokerCName>:9093',
    'security.protocol': 'SASL_SSL',
    'sasl.mechanisms': 'SCRAM-SHA-256',
    'ssl.ca.location': '/path/to/pemfilename.pem',
    'sasl.username': '<password>',
    'sasl.password': '<secret>'
}

producer = Producer(conf)