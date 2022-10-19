let nombre = document.getElementById("nombre");
let tlf = document.getElementById("Telefono");
let mail = document.getElementById("email");
let mensaje = document.getElementById("Mensaje")

let btnEnviar = document.getElementById("btnSubmit");
btnEnviar.addEventListener("click", function(e){
    e.preventDefault();
    

    if ((nombre.value.length >= 3)
        &&
        (isNaN(nombre.value))
    ) { //validacion nombre
        nombre.classList.remove("is-invalid");
        nombre.classList.add("is-valid");
    } else {
        nombre.classList.remove("is-valid");
        nombre.classList.add("is-invalid");
    }

    if (
        (tlf.value.length>=10)
        &&
        (! isNaN(tlf.value))
        &&
        (tlf.value!=0000000000)
    ){                               //validación Teléfono 
        tlf.classList.remove("is-invalid");
        tlf.classList.add("is-valid");
    }else {
        tlf.classList.remove("is-valid");
        tlf.classList.add("is-invalid");
    }

    if (
        !(mail.validity.typeMismatch) //validación mail
        &&
        (mail.value.length >= 6)
    ){                               
        mail.classList.remove("is-invalid");
        mail.classList.add("is-valid");
    }else {
        mail.classList.remove("is-valid");
        mail.classList.add("is-invalid");
    }

    if (
        (mensaje.value.length >= 20) //validacion mensaje
        && 
        (mensaje.value.length <=140)
    ){ 
        mensaje.classList.remove("is-invalid");
        mensaje.classList.add("is-valid");
    } else {
        mensaje.classList.remove("is-valid");
        mensaje.classList.add("is-invalid");
    }

    if ((nombre.value.length >= 12)
        &&
        (tlf.value.length>=10)
        &&
        (! isNaN(tlf.value))
        &&
        (tlf.value!=0000000000)
        &&
        !(mail.validity.typeMismatch)
        &&
        (mail.value.length >= 6)
        &&
        (mensaje.value.length >= 20) //validacion mensaje
        && 
        (mensaje.value.length <=140)
    ) {
        

        Email.send({
            Host : "smtp.elasticemail.com",
            Username : "mexishopgeneration@gmail.com",
            Password : "406D1B6FBC2FB61ED5E9ECFA9453067FFF4F",
            To : 'mexishopgeneration@gmail.com',
            From : "mexishopgeneration@gmail.com",
            Subject : `Contáctanos Mexishop ${nombre.value}`,
            Body : `${mensaje.value}
            <br>
            <br>
            <br>
            A nombre de: ${nombre.value}
            Teléfono de contacto: ${tlf.value}
            `
        }).then(
        message =>        Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'SOLICITUD ENVIADA. NOS COMUNICAREMOS A LA BREVEDAD. ' + message,
            showConfirmButton: false,
            timer: 2000,
            background: '#282F36', 
            color: '#C2943F'
          }) 
        ); 
         
    } else{
        Swal.fire({
            position: 'center',
            icon: 'error',
            title: 'Por favor, verifica la informacion otorgada.',
            showConfirmButton: false,
            timer: 1500,
            background: '#282F36', 
            color: '#C2943F'
          })
    }
    

});