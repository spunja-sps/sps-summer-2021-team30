function loadMentees() {
    fetch('/load-mentors').then(response => response.json()).then((mentees) => {
        const menteeListElement = document.getElementbyId('mentor-list');
        mentees.forEach((user) => {
            menteeListElement.appendChild(createUserElement(user));
        })
    });
}

function createUserElement(user) {
    const userElement = document.createElement('li');
    userElement.className = 'User';

    const titleElement = document.createElement('span');
    titleElement.innerText = 'Name: ' + user.firstName + ' ' + user.lastName + '; Email: ' + user.email;
    userElement.appendChild(titleElement);
    return userElement;
}
            