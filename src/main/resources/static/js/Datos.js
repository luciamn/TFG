$(function (){
    "use srtict";
    $(document).ready(function (){
        function getDatos(){
            $.ajax({
                url:"http://localhost:9001/api/dashboard/datos",
                'datatype' : "json"
            }).done(function(data){
                $('#count_product').text(data.count_product);
                $('#count_users').text(data.count_users);
                $('#count_compras').text(data.count_compras);
                $('#count_citas').text(data.count_citas);
            });
        }
        getDatos();
    });
})