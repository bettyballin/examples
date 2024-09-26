{% extends 'TwigBundle::base.html.twig' %}

{% block body %}
    <h1>{{ exception.message }}</h1>

    {% if exception.previous %}
        <p>Previous exception</p>
        <h2>{{ exception.previous.message }}</h2>
    {% endif %}

    <h2>Exception Details</h2>
    <table>
        <tr>
            <th>Type</th>
            <td>{{ exception.class }}</td>
        </tr>
        <tr>
            <th>Message</th>
            <td>{{ exception.message }}</td>
        </tr>
        <tr>
            <th>Code</th>
            <td>{{ exception.code }}</td>
        </tr>
        <tr>
            <th>File</th>
            <td>{{ exception.file }}</td>
        </tr>
        <tr>
            <th>Line</th>
            <td>{{ exception.line }}</td>
        </tr>
    </table>

    <h2>Stack Trace</h2>
    <pre>{{ exception|dump }}</pre>
{% endblock %}