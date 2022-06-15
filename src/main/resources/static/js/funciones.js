function eliminar(id){
    swal({
        title: "Estas seguro de eliminar?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({
                   url:"/miCita/eliminar/"+id,
                    success: function (res){
                       console.log(res);
                    }
                });
                swal("Poof! Your imaginary file has been deleted!", {
                    icon: "success",
                }).then((ok)=>{
                    if (ok){
                        location.href="/miCita/";
                    }
                });
            } else {
                swal("Your imaginary file is safe!");
            }
        });
}