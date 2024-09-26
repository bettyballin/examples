from flask import Flask, render_template_string

app = Flask(__name__)

template = '''
<span id="search-query">You searched for {{ query | safe }}</span>
'''

@app.route('/search')
def search():
    query = 'example search query'
    return render_template_string(template, query=query)

if __name__ == '__main__':
    app.run()