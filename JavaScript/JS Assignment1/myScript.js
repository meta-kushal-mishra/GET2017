function redirect() 
{
    window.location="page.html";
}
function redirectToContact()
{
	window.location="Contacts.html";
}
function validateForm()
{
 	var x=document.getElementById("name");
 	var namepattern = /^([a-zA-Z]|\s)*$/;

 	if (!namepattern.test(x.value) || x.value=="")
 	{
    if(x.value=="")
      alert("Name is required. Please enter your name");
    else
    	alert("name should contain only alphabets.");
  	x.focus();
  	return false;
 	}

 	var emailpattern = /\S+@\S+\.\S+/ ;
	x=document.getElementById("email");
 	if(!emailpattern.test(x.value) || x.value=="")
  {
    if(x.value=="")
      alert("Email is required. Please enter your email");
    else
  		alert("Invalid email id.");
  		x.focus();
  		return false;
 	}

 if(!validateSelect())
    return false;

 	var phoneno = /^\d{10}$/;
 	x=document.getElementById("contact");
 	if(!phoneno.test(x.value) || x.value=="")
  {
    if(x.value=="")
      alert("Phone No. is required. Please enter your phone number");
    else
 		alert("Invalid no .");
  		x.focus();
      return false;
 	}

 	var orgReg = /[a-zA-Z]/;
 	x=document.getElementById("orgName");
 	if(!orgReg.test(x.value) || x.value=="")
 	{
    if(x.value==""){
      alert("Enter Org name");
    }
    else
 		   alert("Invalid orgName ");
  		x.focus();
      return false;
 	}
 	var message = document.getElementById("Message");
 	if(message.length > 250)
 	{
 		alert("Invalid message");
  		x.focus();
      return false;
 	}
 }
 function validateSelect()
 {
 	var x =document.getElementById("select");
 	if (x.value=="Choose here") 
 	{
    	alert("Please make a selection");
        x.focus();
        return false;
    }
    else
    {
    	var y = document.getElementById("textField");
    	y.defaultValue = x.value;
    	document.getElementById('textField').style.visibility='visible';
		document.getElementById('City').style.visibility='visible';
    return true;
    }

 }