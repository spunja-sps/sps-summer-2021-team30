window.onload = function() {
    this.loadMentors();
}

function loadMentors() {
    fetch('/load-mentors').then(response => response.json()).then((mentees) => {
        const menteeListElement = document.getElementById('mentor-list');
        console.log("mentors: " + mentees);
        mentees.forEach((user) => {
            menteeListElement.appendChild(createUserElement(user));
        })
    });
}

function createUserElement(user) {
    const userElement = document.createElement('li');
    userElement.className = 'User';

    const button = document.createElement('a');
    // waves-effect waves-teal btn-flat
    button.classList.add('waves-effect');
    button.classList.add('waves-teal');
    button.classList.add('btn-flat');
    button.innerHTML = user.firstName + " " + user.lastName + "; Email: " + user.email;

    //const titleElement = document.createElement('span');
    //titleElement.innerText = 'Name: ' + user.firstName + ' ' + user.lastName + '; Email: ' + user.email;
    //userElement.appendChild(titleElement);
    userElement.appendChild(button);
    return userElement;
}
            
