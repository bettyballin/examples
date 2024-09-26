from azure.common.credentials import ServicePrincipalCredentials

credentials = ServicePrincipalCredentials(
    client_id='your_client_id',
    secret='your_secret',
    tenant='your_tenant'
)