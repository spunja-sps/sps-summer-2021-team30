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
 //alert("let's go!");
  this.loadResources();
}

/**
 * Gets the list of Resources
 */
async function loadResources() {
    const serverResponse = await fetch('/resource');
    const resourceList = await serverResponse.json();
    const resourceListElement = document.getElementById('resources-list');
    resourceList.forEach(function(element) {
        resourceListElement.appendChild(createResourceElement(element));
    });
}

/**
 * Prints a Resource to the HTML page inside a Materialize card
 * @param resource an element containing info about a resource
 */
function createResourceElement(resource) {
    const resourceElement = document.createElement('div');
    const resourceTitle = document.createElement('span');
    const resourceInfo = document.createElement('p');

    resourceTitle.innerHTML = resource.getTitle;
    resourceInfo.innerHTML = resource.getDescription;

    resourceElement.appendChild(resourceTitle);
    resourceElement.appendChild(resourceInfo);

    return resourceElement;
}