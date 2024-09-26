from confluent_kafka import Producer

# See https://github.com/edenhill/librdkafka/blob/master/CONFIGURATION.md
conf = {
    'bootstrap.servers': 'localhost:9092',
    'security.protocol': 'SASL_SSL',
    'sasl.mechanisms': 'SCRAM-SHA-256',
    'sasl.username': 'yourUsername',
    'sasl.password': 'yourPassword', 
    # any other config you like ..
}

p = Producer(**conf)

def on_delivery(err, msg):
    if err:
        print(f'Delivery failed: {err}')
    else:
        print(f'Delivered message to {msg.topic()} [{msg.partition()}]')

# Produce a message
p.produce('yourTopic', value='yourMessage', callback=on_delivery)

# Wait for any remaining messages to be delivered
p.poll(1)

# Close the producer
p.flush()