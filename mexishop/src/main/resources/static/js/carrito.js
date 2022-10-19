let tabla = document.getElementById("tabla");
let tarjeta = document.getElementById("prod");
let total = document.getElementById("total");
let compra=[];
let suma = 0;


/*       Se cargan los datos de las cards de ofertas        */
window.addEventListener("load", function(){
    printData();
    if (localStorage.getItem("carrito")) {
        compra = JSON.parse(localStorage.getItem("carrito"))
    }

})


/*        Función para obtener información del json                */

const printData = () =>{
    let promise = fetch("http://127.0.0.1:5500/data.json",{
      method:"GET"
    });//fetch
    promise.then( (response) => {
            response.json().then((data)=>{
                    data.forEach(element => {
                    if (element.id.charAt(3)==5){
                          addItem(tarjeta, element)
                    }//if para añadir productos más vendidos
                    
                  }); //forEach */
            }).catch( (error) =>{
              console.error(error);
          });
      }).catch((error) =>{
        alert("Error en la solicitud " + error);
    });

}//getData

/*    Función para pintar la card       */

function addItem(div, item){
    const itemHTML = `<div class="card" style="width: 18rem;">
            <img src="${item.img}" class="card-img-top" alt="image">
            <div class="card-body">
                <h5 class="card-title">${item.name}</h5> 
                <p class="card-text">${item.description.slice(0,20)}...<br>
                <strong>$ ${item.precio} (MXN)</strong></p>   
                <button type="button" class="btn" data-toggle="modal" data-target="#modalItem_${item.id}">
                 Ver más 
                </button>
                <a href="/pages/carrito.html" class="btn btnAdd">Añadir a carrito</a> 
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
      ${item.description} <br/>
      <strong>$ ${item.precio} (MXN)</strong>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>
</div>`
    div.innerHTML += itemHTML;
}//addItem

/*    Función para agregar funcionalidad al botón añadir a Carrito    */

tarjeta.addEventListener("click", function(e){
    e.preventDefault();
    add(e);
})

/* añadir a Carrito */

function add(e) {
    if (e.target.classList.contains("btnAdd")){
        objeto = e.target.parentElement;
        let item = {nombre: "", precio:"", cantidad: 1, id: ""}

        item.nombre = objeto.querySelector("h5").textContent
        item.precio = parseInt(objeto.querySelector("strong").textContent.split(" ")[1])

        //Traer valor de id//
        item.id = parseInt(objeto.querySelector(".btn").dataset.target.slice(11,15))

        if (compra.length!=0) {
            compra.forEach(elem =>{
                if(parseInt(elem.id) === item.id){
                    item.cantidad = elem.cantidad+1
                    let index = compra.indexOf(elem)
                    compra.splice(index,1)
                }
            })            
        }

          compra.push(item)
          
          localStorage.setItem("carrito", JSON.stringify(compra))
          location.reload();


    }//if para que aplique únicamente a botón
    
}//add

/*              Tabla                    */
tabla.innerHTML += ` <thead>
<tr>
  <th scope="col">ID</th>
  <th scope="col">Nombre</th>
  <th scope="col">Cantidad</th>
  <th scope="col">Precio</th>
  <th scope="col"></th>
</tr>
</thead>`

if ((!localStorage.getItem("carrito")) || (JSON.parse(localStorage.getItem("carrito")).length==0)) {
    tabla.innerHTML += `
    <th scope="row">¡No has añadido nada a tu carrito!</th>`
} 

if(localStorage.getItem("carrito")){
    let tmp = JSON.parse(localStorage.getItem("carrito"))
    tmp.forEach(prod => {
        suma+= prod.precio*prod.cantidad
        tabla.innerHTML+= `<tbody>
        <tr>
          <th scope="row">${prod.id}</th>
          <td>${prod.nombre}</td>
          <td>${prod.cantidad}</td>
          <td>$ ${prod.precio*prod.cantidad}</td>
          <td><button type="button" class="btn btnQuitar">Quitar</button></td>
        </tr>`
      suma+=prod.precio*prod.cantidad
    });
}

total.innerHTML+=`<div class="alert alert-info" role="alert">
Total de compra:   $${suma/2}
</div>`

//Eliminar  producto

tabla.addEventListener("click", function (e) {
  e.preventDefault();
  deleteProd(e)
  
})

function deleteProd(e) {
  if (e.target.classList.contains("btnQuitar")){
    let row = e.target.parentElement.parentElement;
    let prod_id =row.querySelector("th").textContent 
    let temporal = JSON.parse(localStorage.getItem("carrito"))
    temporal.forEach(element => {
        if (element.id == prod_id){
            let ind = temporal.indexOf(element)
            temporal.splice(ind,1);
            localStorage.setItem("carrito", JSON.stringify(temporal))
        }//eliminar elemento
    });//forEach
    location.reload();
  }//if para identificar botón  
}//función deleteProd
