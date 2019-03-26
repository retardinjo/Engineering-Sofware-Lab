function usernameValidation() {
    var inputAdd = document.getElementById("un");
    var outputAdd = document.getElementById("unAlert");
    var submitDisable = document.getElementById("submit");
    var regExpName = /^[a-z0-9_-]{3,15}$/;
    if (!regExpName.test(inputAdd.value)) {
        outputAdd.style.color = "red";
        outputAdd.innerHTML = "NOT OK!"
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
        outputAdd.innerHTML = "NOT OK!"
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
        outputAdd.innerHTML = "NOT OK!"
        submitDisable.disabled = true;
    } else {
        outputAdd.style.color = "green";
        outputAdd.innerHTML = "OK!"
        submitDisable.disabled = false;
    }
}


function disableSubmit() {
  var checkBox = document.getElementById("agreeId");
    var submitDisable = document.getElementById("submit");
  if (!checkBox.checked == true){
      submitDisable.disabled = true;
  } else{
      submitDisable.disabled = false;
  }
} 

function validate(form) {
    var checkBox = document.getElementById("agreeId");
		if (!checkBox.checked == true){
			alert('Sorry, you must accept the License Agreement before submitting.');
			return false;
		}
		return true;
	}

$(function datePicker(){
			$("#datepicker").datepicker();
		});
