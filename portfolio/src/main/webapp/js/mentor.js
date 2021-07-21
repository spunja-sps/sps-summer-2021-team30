window.onload = function(){
    this.loadMentees();
}

function loadMentees() {
    
    fetch('/load-mentees').then(response => response.json()).then((mentees) => {
        const menteeListElement = document.getElementById('mentee-list');
        console.log("Mentee element: " + mentees);
        mentees.forEach((user) => {
            console.log("user: " + user);
            menteeListElement.appendChild(createUserElement(user));
        })
        
    });
    
   /*
   var mentees = [{id: 1, firstName: "Mary", lastName: "Smith", email: "user@email.com", password: "MyPassword", userType: "Mentee"}];
   const menteeListElement = document.getElementById('mentee-list');
   mentees.forEach((user) => {
    console.log("user: " + user.firstName);
    menteeListElement.appendChild(createUserElement(user));
   });
   */
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
            
