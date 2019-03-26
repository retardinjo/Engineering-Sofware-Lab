function usernameValidation() {
    var inputAdd = document.getElementById("un");
    var outputAdd = document.getElementById("unAlert");
    var submitDisable = document.getElementById("submit");
    var regExpName = /^[a-z0-9_-]{3,15}$/;
    if (!regExpName.test(inputAdd.value)) {
        outputAdd.style.color = "red";
        outputAdd.innerHTML = "NOT OK!!!"
        submitDisable.disabled = true;
    } else {
        outputAdd.style.color = "green";
        outputAdd.innerHTML = "OK!"
        submitDisable.disabled = false;
    }
}

function passwordValidation() {
    var inputAdd = document.getElementById("pass");
    var outputAdd = document.getElementById("passAlert");
    var submitDisable = document.getElementById("submit");
    var regExpName = /^[a-z0-9_-]{3,15}$/;
    if (!regExpName.test(inputAdd.value)) {
        outputAdd.style.color = "red";
        outputAdd.innerHTML = "NOT OK!!!"
        submitDisable.disabled = true;
    } else {
        outputAdd.style.color = "green";
        outputAdd.innerHTML = "OK!"
        submitDisable.disabled = false;
    }
}

function emailValidation() {
    var inputAdd = document.getElementById("email");
    var outputAdd = document.getElementById("emailAlert");
    var submitDisable = document.getElementById("submit");
    var regExpName = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!regExpName.test(inputAdd.value)) {
        outputAdd.style.color = "red";
        outputAdd.innerHTML = "NOT OK!!!"
        submitDisable.disabled = true;
    } else {
        outputAdd.style.color = "green";
        outputAdd.innerHTML = "OK!"
        submitDisable.disabled = false;
    }
}


function agreeFunction() {
  var checkBox = document.getElementById("agreeId");
  if (!checkBox.checked == true){
    alert("nije cekiran");
      return false;
  } 
} 
