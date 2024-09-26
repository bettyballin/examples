<?php

// Assuming you're using Symfony framework

// Controller
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;

class RecordController extends Controller
{
    public function indexAction(Request $request)
    {
        $records = // fetch records from database
        return $this->render('records.html.twig', ['records' => $records]);
    }

    public function deleteAction(Request $request, $token)
    {
        // Delete record from database using the token
        $response = // delete record and return a response
        return new JsonResponse($response);
    }
}

// Twig template ( records.html.twig )
{% extends 'base.html.twig' %}

{% block content %}
  <h1>My Records</h1>
  <ul>
    {% for record in records %}
      <li>
        {{ record.title }}
        <button data-token="{{ record.token }}" class="delete-record">Delete</button>
      </li>
    {% endfor %}
  </ul>
{% endblock %}

{% block scripts %}
  <script>
    $(document).ready(function() {
      $('.delete-record').on('click', function(event) {
        event.preventDefault();
        var token = $(this).data('token');
        $.ajax({
          url: '/api/records/' + token,
          method: 'DELETE',
          success: function(response) {
            console.log(response);
          },
          error: function(xhr, status, error) {
            console.error(xhr.responseText);
          }
        });
      });
    });
  </script>
{% endblock %}

// Routing ( routing.yml )
records:
    path:     /records
    defaults: { _controller: AppBundle:Record:index }

record_delete:
    path:     /api/records/{token}
    defaults: { _controller: AppBundle:Record:delete }
    methods:  [DELETE]

Note: This code assumes you're using Symfony framework, adjust the code according to your needs and framework.