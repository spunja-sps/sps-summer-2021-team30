//import * as jquery from "https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js";

var elem = document.querySelector('.sidenav');
var instance = new M.Sidenav(elem);

var el = document.querySelectorAll('.tab');
//var instanceTabs = M.Tabs.init(el);
   // with jquery

  $(document).ready(function(){
   $('.sidenav').sidenav();
   $('.tabs').tabs();
  });