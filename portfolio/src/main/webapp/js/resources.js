
var elem = document.querySelector('.sidenav');
var instance = new M.Sidenav(elem);

var el = document.querySelectorAll('.tab');

// loads Materialize sidebar and tabs
  $(document).ready(function(){
   $('.sidenav').sidenav();
   $('.tabs').tabs();
  });

// Make list of resources using Resources class

/**
 * Gets the list of Resources
 */
function loadResources() {
    var resourcesList = [];
    const resourceListElement = document.getElementById('resources-list');
    resourcesList.forEach(function(element) {
        resourcesListElement.appendChild(createResourceElement(element));
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