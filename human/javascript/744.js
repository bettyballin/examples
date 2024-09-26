// handle promise error
private handleError = (errorMessage: Error) => {
    const message = JSON.parse(errorMessage.message);
    if (message.status === 401) {

        this.authentication.logout(); // triggers logout actions and destroy credentials
    }
    throw errorMessage;
}