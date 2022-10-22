let tarjeta = document.getElementById("prod");

/*       Se cargan los datos de las cards de ofertas        */
window.addEventListener("load", function(){
    getData();
    if (localStorage.getItem("carrito")) {
        compra = JSON.parse(localStorage.getItem("carrito"))
    }

})


/*        Función para obtener información del json                */

let url1 = "/api/productos/"

const getData = () =>{
    let promise = fetch(url1,{
      method:"GET"
    });//fetch
    promise.then( (response) => {
            response.json().then((data)=>{
                    data.forEach(element => {
                    if (String(element.product_id).charAt(3)==7){
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
            <img src="${item.prod_Link}" class="card-img-top" alt="image">
            <div class="card-body">
                <h5 class="card-title">${item.prod_nombr}</h5> 
                <p class="card-text">${item.prod_desc.slice(0,20)}...<br>
                <strong>$ ${item.precio_prod} (MXN)</strong></p>   
                <button type="button" class="btn" data-toggle="modal" data-target="#modalItem_${item.product_id}">
                 Ver más 
                </button>
 
            </div> 
        </div> 
        <br/>
        <!-- Modal -->
<div class="modal fade" id="modalItem_${item.product_id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">${item.prod_nombr}</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      ${item.prod_desc} <br/>
      <strong>$ ${item.precio_prod} (MXN)</strong>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>
</div>`
    div.innerHTML += itemHTML;
}//addItem
