
    let tabla = document.getElementById("tabla");
    let id = document.getElementById("id");
    let nameprod = document.getElementById("nameproducto");
    let img = document.getElementById("imgproduct");
    let cost = document.getElementById("precio");
    let comment = document.getElementById("comentarios");
    let btnagregar = document.getElementById("btnSubmit");
    let preview = document.getElementById("Preview");
    let btnPreview = document.getElementById("btnMostrar");
    let inventario=[];
    /*  Titulo de tabla */
    tabla.innerHTML += `<thead class="thead-dark">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">PRODUCTO</th>
      <th scope="col">IMAGEN</th>
      <th scope="col">PRECIO</th>
      <th scope="col">COMENTARIOS</th>
    </tr>
  </thead>`

//Arreglo Inicial
    if (localStorage.getItem("catalogo")) {
    let tempInventario = JSON.parse(localStorage.getItem("catalogo"));
    tempInventario.forEach(element => {
        inventario.push(element)
    });
    
    }
    //Función para añadir elemento en una card

    function showItem(div, item){
        const itemHTML = `<div class="card" style="width: 18rem;">
                <img src="${item.img}" class="card-img-top" alt="image">
                <div class="card-body">
                    <h5 class="card-title">${item.name}</h5> 
                    <p class="card-text">${item.description.slice(0,20)}...<br>
                    <strong>$ ${item.precio} (MXN)</strong></p>   
                    <button type="button" class="btn" data-toggle="modal" data-target="#modalItem_${item.id}">
                    Ver más 
                    </button>
                    <a href="#" class="btn btnDelete">Eliminar</a> 
                </div> 
            </div> 
            <br/>
            <!-- Modal -->
    <div class="modal fade" id="modalItem_${item.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">${item.name}</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">
        ${item.description}
        </div>
        <div class="modal-footer">
            <button type="button" class="btn" data-dismiss="modal">Cerrar</button>
        </div>
        </div>
    </div>
    </div>`
        div.innerHTML += itemHTML;
    }//addItem

    //Vista previa de producto
    preview.addEventListener("click", function(e){
        e.preventDefault();
        removeItem(e)
    });//Card addEventListener

    function removeItem(e) {
        if(e.target.classList.contains("btnDelete")) {
            preview.style.display="none"
            id.value=null
            nameprod.value=null
            img.value=null
            comment.value=null
            cost.value=null
        }
    }//removeItem

    if (localStorage.getItem("catalogo")) {
        let tmp = JSON.parse(localStorage.getItem("catalogo"))
        tmp.forEach(element => {
            tabla.innerHTML += `<tbody>
            <tr>
              <th scope="row">${element.id}</th>
              <td><strong>${element.name}</strong></td>
              <td><strong>${element.img}</strong></td>
              <td><strong>${element.precio}</strong></td>
              <td><strong>${element.description}</strong></td>
            </tr>`
            
        });
        
    }//if catalogo tiene elementos en localStorage 

    btnPreview.addEventListener("click", function(e){
        e.preventDefault();
        let item = {"id":`${id.value}`, 
        "name":`${nameprod.value}`,
        "img": `${img.value}`,
        "description":`${comment.value}`,
        "precio": `${cost.value}`
       }
       preview.innerHTML=""
        showItem(preview, item)
        if (preview.style.display="none") {
            preview.style.display="flex"
        }
    }); //btnPreview

btnagregar.addEventListener("click", function(e) {
    e.preventDefault();

let item = {"id":"", 
        "name":"",
        "img": "",
        "description":"",
        "precio": ""
       }

         item.name = nameprod.value;
         item.id = id.value;
         item.img = img.value;
         item.description = comment.value;
         item.precio = cost.value;    

    if ((id.value.length==4) 
        && 
        (! isNaN(id.value))
    ) {
        id.classList.remove("is-invalid");
        id.classList.add("is-valid");
    } else {
        id.classList.remove("is-valid");
        id.classList.add("is-invalid");
    } // ID validacion


    if (nameprod.value.length >=6)  {
        nameprod.classList.remove("is-invalid");
        nameprod.classList.add("is-valid");
    } else {
        nameprod.classList.remove("is-valid");
        nameprod.classList.add("is-invalid");
    } //If Product Name

    if (img.value.length >=10)  {
        img.classList.remove("is-invalid");
        img.classList.add("is-valid");
    } else {
        img.classList.remove("is-valid");
        img.classList.add("is-invalid");
    } //If URL Img

    if ((cost.value.length>=3) 
        && 
        (! isNaN(cost.value))
    ) {
        cost.classList.remove("is-invalid");
        cost.classList.add("is-valid");
    } else {
        cost.classList.remove("is-valid");
        cost.classList.add("is-invalid");
    } // validacion Costo

    if (comment.value.length >=30)  {
        comment.classList.remove("is-invalid");
        comment.classList.add("is-valid");
    } else {
        comment.classList.remove("is-valid");
        comment.classList.add("is-invalid");
    } //If Descripcion

    if ((id.value.length==4) 
        && 
        (! isNaN(id.value))
        &&
        (nameprod.value.length >=6)
        &&
        (img.value.length >=10)
        &&
        (cost.value.length>=3) 
        && 
        (! isNaN(cost.value))
        &&
        (comment.value.length >=30)) {
        //mandar información a localstorage
        Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Se ha añadido producto a la lista',
            showConfirmButton: false,
            timer: 1500,
            background: '#282F36', 
            color: '#C2943F'
          })
    
    inventario.push(item)
    localStorage.setItem("catalogo", JSON.stringify(inventario))

    let tmp = JSON.parse(localStorage.getItem("catalogo"))
        tmp.forEach(element => {
            tabla.innerHTML += `<tbody>
            <tr>
              <th scope="row">${element.id}</th>
              <td>${element.name}</td>
              <td class="size">${element.img}</td>
              <td>${element.precio}</td>
              <td>${element.description}</td>
            </tr>`
        
            preview.style.display="none"
            id.value=null
            nameprod.value=null
            img.value=null
            comment.value=null
            cost.value=null
            
        });
    }//if de validacion
    else{
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

    

});// btn Agregar

