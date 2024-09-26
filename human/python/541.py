import subprocess

def create_big_query_export(dataset_name, folder_id=None, organization_id=None, project_id=None, description=None, filter=None):
    command = [
        "gcloud",
        "scc",
        "bqexports",
        "create",
        "BIG_QUERY_EXPORT",
        "--dataset=" + dataset_name
    ]

    if folder_id:
        command.append("--folder=" + folder_id)
    elif organization_id:
        command.append("--organization=" + organization_id)
    elif project_id:
        command.append("--project=" + project_id)

    if description:
        command.append("--description=" + description)

    if filter:
        command.append("--filter=" + filter)

    subprocess.run(command)

# Example usage:
create_big_query_export("my_dataset", folder_id="1234567890")