function refreshBarOcupacacion(){
        var clientes = "select count(*) from cliente";
        var cliente = null;
        username = document.querySelector('#clientes').value.trim();

    var status = 'success';

        switch (true){
            case clientes  >= 1:
                status = 'success';
                break;
            case clientes >= 50 && clientes < 80:
                status = 'warning';
                break;
            case clientes >= 80:
                status = 'danger';
                break;
        }

        document.getElementById("barOcupacion").classList = "progress-bar bg-"+status;
        //document.getElementById("barOcupacion").style.width = width + "%";

}