from flask import Flask, render_template, request
import bleach

app = Flask(__name__)

@app.route('/render', methods=['POST'])
def render():
    user_input = request.form['user-html']

    # Allow only certain tags and attributes
    allowed_tags = ['p', 'br', 'strong', 'em', 'a', 'img']
    allowed_attributes = {'a': ['href'], 'img': ['src']}

    sanitized_input = bleach.clean(user_input,
                                tags=allowed_tags,
                                attributes=allowed_attributes)

    return render_template('render.html', content=sanitized_input)

if __name__ == '__main__':
    app.run(debug=True)