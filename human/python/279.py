from flask_mail import Message

msg = Message(
    subject="Your Subject",
    sender="your_email@example.com",
    recipients=["recipient@example.com"]
)