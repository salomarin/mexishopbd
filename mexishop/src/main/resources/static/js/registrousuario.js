let nombre = document.getElementById ("nombre");
let Telefono = document.getElementById("Telefono");
let email = document.getElementById("email");
let contra = document.getElementById("contra");
let contracof = document.getElementById("contraconf");
let btnRegistrar = document.getElementById("btnSubmit");
let btnLink = document.getElementById("login")

let usuarios = []

btnLink.addEventListener("click", function (i) {
    i.preventDefault();

    window.location.assign("http://localhost:8080/pages/login.html")
});


btnRegistrar.addEventListener("click", function(e){
     e.preventDefault();

    let cont = 0;
    let password = contra.value.split("")
    let signs = ["/", "@", "_", ":", "~", "$", "#", "*", "^", ".", "-"]
    signs.forEach(element => {
        if (password.includes(element)) {
            cont++;
        }
    });

//Validadciones



if ((nombre.value.length>=3) 
        && 
        (isNaN(nombre.value))
    ) {
        nombre.classList.remove("is-invalid");
        nombre.classList.add("is-valid");
    } else {
        nombre.classList.remove("is-valid");
        nombre.classList.add("is-invalid");
    } // If nombre 


    if (email.value.length >=12)  {
        email.classList.remove("is-invalid");
        email.classList.add("is-valid");
    } else {
        email.classList.remove("is-valid");
        email.classList.add("is-invalid");
    } //If email

    if (Telefono.value.length >=10)  {
        Telefono.classList.remove("is-invalid");
        Telefono.classList.add("is-valid");
    } else {
        Telefono.classList.remove("is-valid");
        Telefono.classList.add("is-invalid");
    } //If telefono

    if ((contra.value==contracof.value) 
        && 
        (cont>0)
        &&
        (contra.value.length >=8)
    ) { 
        contra.classList.remove("is-invalid");
        contra.classList.add("is-valid");

        contracof.classList.remove("is-invalid");
        contracof.classList.add("is-valid");
    } else {
        contra.classList.remove("is-valid");
        contra.classList.add("is-invalid");

        contracof.classList.remove("is-valid");
        contracof.classList.add("is-invalid");
    } //If validacion contraseña

    if ((nombre.value.length>=3) 
        && 
        (isNaN(nombre.value))
        &&
        (email.value.length >=12)
        &&
        (Telefono.value.length >=10)
        &&
        (contra.value==contracof.value) 
        && 
        (cont>0)
        &&
        (contra.value.length >=8)
        
        
    ){
	
	
	let token = JSON.parse (localStorage.getItem("token"));
	const usuario = { "nombre": nombre.value };

fetch('https://example.com/profile', {
  method: 'POST', // or 'PUT'
  headers: {
    'Content-Type': 'application/json',
    "Authorization":"Bearer: " + token.accesToken
  },
  body: JSON.stringify(usuario),
})
  .then((response) => response.json())
  .then((data) => {
    console.log('Success:', data);
  })
  .catch((error) => {
    console.error('Error:', error);
  });

	
    Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Registro exitoso',
        showConfirmButton: false,
        timer: 1500,
        background: '#282F36', 
        color: '#C2943F',    
          })


    
  

    let item = {"nombre": nombre.value, 
        "telefono": Telefono.value,
        "email": email.value,
        "contrasena":contra.value
       }

       usuarios.push(item)
       let tmp = JSON.stringify(usuarios)
       localStorage.setItem("users", tmp)
    } else {
        Swal.fire({
            position: 'center',
            icon: 'error',
            title: 'Por favor, ingrese los datos completos y correctos de nuevo',
            showConfirmButton: false,
            timer: 1500,
            background: '#282F36', 
            color: '#C2943F'
          })
    }
});//addEventListener