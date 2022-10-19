let email = document.getElementById("email")
let password = document.getElementById("contra")
let button = document.getElementById("btnSubmit")
let btnLink = document.getElementById("registro")

let arr=[]
let flag =0;

btnLink.addEventListener("click", function (i) {
    i.preventDefault();

    window.location.href="http://localhost:8080/pages/registrousuario.html"
});

button.addEventListener("click", function (e) {
    e.preventDefault();
    if (email.value.length==0){
        email.classList.add("is-invalid")
        email.classList.remove("is-valid")
    } else {
        email.classList.add("is-valid")
        email.classList.remove("is-invalid")
    }
    
    
    if (password.value.length==0){
        password.classList.add("is-invalid")
        password.classList.remove("is-valid")
    } else{
        email.classList.add("is-valid")
        email.classList.remove("is-invalid")
    }

	const acceso = { "email": email.value, "contrasena":  password.value};
	
//FETCH	
fetch("http://localhost:8080/api/login/", {
  method: 'POST', // or 'PUT'
  headers: {
    'Content-Type': 'application/json',
  },
  body: JSON.stringify(acceso),
})
  .then((res) => res.json())
  .catch((error) => {
    console.error('Error:', error);
  })
  .then((response)=>{
	localStorage.setItem("token", JSON.stringify(response));
  
	let result = JSON.parse(localStorage.getItem("token"))
	if(response.accesToken!=null ){
		    Swal.fire({
                position: 'center',
                icon: 'success',
                title: 'Has accedido a tu cuenta',
                background: '#282F36', 
                color: '#C2943F',
                confirmButtonColor: "#E8AF4E"
              })
              .then((result)=>{
                if(result.isConfirmed){
                    window.location.assign("http://localhost:8080/index.html/")
                }
              })
	} else {
		        Swal.fire({
            position: 'center',
            icon: 'error',
            title: 'Usuario no registrado',
            showConfirmButton: false,
            timer: 1500,
            background: '#282F36', 
            color: '#C2943F'
          })
	}
  });

})//addEventListener


