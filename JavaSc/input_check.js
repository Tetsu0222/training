var elmSubmit = document.getElementById("INPUT_SUBMIT");
elmSubmit.onclick = function(){
  var elmUserAge   = document.getElementById("AGE");
  var elmMESSAGE = document.getElementById("MESSAGE");
  var canSubmit = true;
  if(elmUserAge.value == "" || elmMESSAGE.value == ""){
    alert("入力漏れの項目があります。");
    canSubmit = false;
  }
  return canSubmit;
}
