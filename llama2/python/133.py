class Alert:
    def __init__(self, id, name, state):
        self.id = id
        self.name = name
        self.state = state

alerts = [
    Alert(1, "Alert 1", "active"),
    Alert(2, "Alert 2", "inactive"),
    Alert(3, "Alert 3", "active")
]

for alert in alerts:
    print(alert.id, alert.name, alert.state)