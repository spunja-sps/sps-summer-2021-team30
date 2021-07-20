/*
load("nashorn:mozilla_compat.js");
importClass(Resource.java);
var resources = new Resource.java(1, "Invitation to Computer Science", "short description", Date());
console.log(resources);
*/

var elem = document.querySelector('.sidenav');
var instance = new M.Sidenav(elem);
var el = document.querySelectorAll('.tab');

// loads Materialize sidebar and tabs
  $(document).ready(function(){
   $('.sidenav').sidenav();
   $('.tabs').tabs();
  });

// Make list of resources using Resources class

window.onload = function() {
  this.loadResources();
}

/**
 * Gets the list of Resources
 */
async function loadResources() {
    const serverResponse = await fetch('/resource');
    const resourceList = await serverResponse.json();
    const gettingStartedPage = document.getElementById('getting-started-container');
    const javaPage = document.getElementById('java-container');

    resourceList.forEach(function(element) {
        if (element.id < 4) {
            gettingStartedPage.appendChild(createResourceCard(element));
        }
        else if (element.id < 6) {
            javaPage.appendChild(createResourceCard(element));
        }
    });
}

/**
 * Prints a Resource to the HTML page inside a Materialize card
 * @param resource an element containing info about a resource
 */
function createResourceCard(resource) {
    const row = document.createElement('div');
    row.classList.add("row");

    const container = document.createElement('div');
    container.classList.add("col");
    container.classList.add("s12");
    container.classList.add("m12");

    const card = document.createElement('div');
    card.classList.add("card");
    card.classList.add("brown");
    card.classList.add("lighten-2");
    card.classList.add("white-text");

    const resourceElement = document.createElement('div');
    resourceElement.classList.add("card-content");

    const resourceTitle = document.createElement('span');
    resourceTitle.classList.add("card-title");
    resourceTitle.innerHTML = resource.title;
     //resourceTitle.innerHTML = "Test 1";

    const resourceInfo = document.createElement('p');
    resourceInfo.innerHTML = resource.description;
    //resourceInfo.innerHTML = "A short description";

    console.log("Title " + resource.title);
    console.log("title 2 " + resource.description);
    resourceElement.appendChild(resourceTitle);
    resourceElement.appendChild(resourceInfo);

    card.appendChild(resourceElement);
    container.appendChild(card);
    row.appendChild(container);

    return row;
}

/*
function createResourceLink(resource) {
    const container = document.createElement('div');
    container.classList.add("card-action pink-text lighten-5");

    const link = document.createElement('a');
}
*/