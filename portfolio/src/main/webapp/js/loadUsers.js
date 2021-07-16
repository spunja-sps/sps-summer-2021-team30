function loadUsers() {
    fetch('/load-users').then(response => response.json()).then((users) => {
        const userListElement = document.getElementbyId('user-list');
        users.forEach((user) => {
            userListElement.appendChild(createUserElement(user));
        })
    });
}

function createUserElement() {
    const userElement = document.createElement('span');
    userElement.className = 'User';

    const titleElement = document.createElement('span');
    titleElement.innerText = 'Name: ' + user.firstName + ' ' + user.lastName + '; Email: ' + user.email;
    userElement.appendChild(titleElement);
    return userElement;
}
            
