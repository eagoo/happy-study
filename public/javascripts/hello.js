if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
}
$(document).ready(function() {
  $(document).on("click","#c",function() {
    //alert("click bound to document listening for #c-element");
    $('#pin').show()
  });
  $("#lesson").multiPicker({ selector : "li" });
})