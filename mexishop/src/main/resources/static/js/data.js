if (!localStorage.getItem("catalogo")) {
    window.addEventListener("load", function () {
        getData();
      })
}//if no existe elementos en catálogo

function getData() {
    let promise = fetch("http://localhost:8080/api/productos/",{
      method:"GET"
    });//fetch
    promise.then( (response) => {
            response.json().then((data)=>{
                localStorage.setItem("catalogo", JSON.stringify(data))
  
            }).catch( (error) =>{
              console.error(error);
          });
      }).catch((error) =>{
        console.error("Error en la solicitud " + error);
    });
      
}//getData

/*function getData() {

fetch("http://localhost:8080/api/productos/", {
  method: 'GET',
  headers: {
    'Content-Type': 'application/json',
  },
})
  .then((response) => response.json())
  .then((data) => {
	console.log(data) 
	localStorage.setItem("catalogo",JSON.stringify(data))
  })
  .catch((error) => {
    console.error('Error:', error);
  });
  }//GETDATA*/