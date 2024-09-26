from flask import Flask, request, render_template, session, send_file, redirect

app = Flask(__name__)

if __name__ == "__main__":
    app.debug = False

    # Set secret key
    app.secret_key = "something"

    # Update config
    app.config.update(
        SESSION_COOKIE_SECURE=True,
        SESSION_COOKIE_HTTPONLY=True,
        SESSION_COOKIE_SAMESITE='Lax',
        SESSION_PERMANENT=True
    )

    app.run()