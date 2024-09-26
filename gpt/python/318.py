
from confluent_kafka import Producer

config = {
    'bootstrap.servers': 'brokerCName:9093',
    'security.protocol': 'SASL_SSL',
    'ssl.ca.location': 'pemfilename.pem',
    'sasl.mechanisms': 'SCRAM-SHA-256',
    'sasl.username': 'username',
    'sasl.password': 'secret'
}

producer = Producer(config)

