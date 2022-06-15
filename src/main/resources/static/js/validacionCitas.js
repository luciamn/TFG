document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("formulario").addEventListener('submit', validarFormulario);
});

function validarFormulario(evento) {
    evento.preventDefault();
    var usuario = document.getElementById('zonaDelCuerpo').value;
    if(usuario.length == 0) {
        alert('No has escrito nada en el usuario');
        return;
    }

    //Validar que el usuario no puede coger horas fuera del horario establecido
    var hora = document.querySelector('#timeInAddHora').value.match(/\d+:\d+/);

    if (hora < "09:30" || hora > "19:00") {
        alert("El horario es de 09:30 a 19:00")
        return;
    }

//Validar que la fecha que escoge el usuario no puede ser anterior a la fecha actual
    var hoy  = new Date();
    var fechaFormulario = timeInAdd.valueAsDate.getTime();
    // Compara solo las fechas => no las horas!!
    hoy.setHours(0,0,0,0);

    if (hoy <= fechaFormulario) {
    }
    else {
        alert("No puedes registrar una cita en una fecha pasada");
        return
    }
    this.submit();
}