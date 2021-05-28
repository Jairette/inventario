window.onload= ()=>{
    var labels=document.getElementsByTagName("label");
    var hidden=document.getElementById("cambios");
    labels.array.forEach(element => {
        element.addEventListener("click",function (e){
            var label=e.target;
            hidden.value+=label.id+" |";
        }); 
    });
    var formulario=document.getElementById("evaluaproducto");
    formulario.onsubmit(function(){
        alert("Se guardo la evaluacion");
    });
};


