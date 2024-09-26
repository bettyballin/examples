alerts = securitycenter_client.alerts.list()
for alert in alerts:
    print(f"Alert name: {alert.name}")