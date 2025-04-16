//Aquí inicia la travesia - Febrero 24 - 2025 

// Funciones globales

let incorrecto

//Pantalla - 2 

function ingresar ()
    {
    let usuario =document.getElementById('usuario').value;
    let password =document.getElementById('password').value;
    
    
    if (usuario == "adminiProyecto@admin.com" && password == "1234") 
        {
            window.location.href = "..//index.html"
        }
        else 
        {
            incorrecto = document.getElementById ('incorrecto').innerHTML = "Correo y/o contraseña invalidos.";
        }
    }

    //Pantalla - 1 


function img(input) 
    {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function(e) {
            $('#imagen').attr('src',e.target.result);
           
        }
        reader.readAsDataURL(input.files[0]);
    }
}
// // $("#imgFile").change(function(){
//     img(this);
// })

function registro ()

    {
    let nombre = document.getElementById('name').value;
    let apellido = document.getElementById('lastName').value;
    let correoEle = document.getElementById('correoEle').value;
    let numeroCel = document.getElementById('numeroCel').value;
    let password = document.getElementById('password').value;
    let conPassword = document.getElementById('conPassword').value;
    let terminos = document.getElementById('terminos');

    if (nombre ==="" || apellido==="" || correoEle==="" || numeroCel==="" || password==="" || conPassword ==="")

        {
            incorrecto = document.getElementById('incorrecto').innerHTML ="Complete todos los campos para continuar.";
        }
        
    else if (password != conPassword) 
        {
            incorrecto = document.getElementById('incorrecto').innerHTML = "Las contraseñas no coinciden, intente nuevamente";
        }

    else if (!terminos.checked)
        {
            incorrecto = document.getElementById('incorrecto').innerHTML = "Debe aceptar los terminos y condiciones para continuar";
        }

    else {
            window.location = "..//index.html"
        }   
    
    }


//pantalla - 3




    