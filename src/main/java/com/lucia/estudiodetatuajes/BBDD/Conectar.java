package com.lucia.estudiodetatuajes.BBDD;

import com.lucia.estudiodetatuajes.Repositorio.PersonalRepo;
import com.lucia.estudiodetatuajes.Modelo.*;
import com.lucia.estudiodetatuajes.Repositorio.*;
import com.lucia.estudiodetatuajes.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Conectar implements CommandLineRunner {

    private final PersonalRepo personal;
    private final TipoTatuajeRepo tipoTatuaje;
    private final ProductoRepo producto;
    private final ClienteRepo cliente;


    @Autowired
    public Conectar(
            PersonalRepo personal,
            TipoTatuajeRepo tipoTatuaje,
            ProductoRepo producto,
            ClienteRepo cliente) {
        this.personal = personal;
        this.tipoTatuaje = tipoTatuaje;
        this.producto = producto;
        this.cliente = cliente;
    }

    @Autowired
    ProductoServicio productoServicio;

    @Override
    public void run(String... strings) {


        //Tipos de tatuajes.
        TipoTatuaje realista = new TipoTatuaje("realista");
        this.tipoTatuaje.save(realista);

        TipoTatuaje oldSchool = new TipoTatuaje("oldSchool");
        this.tipoTatuaje.save(oldSchool);

        TipoTatuaje blackwork = new TipoTatuaje("blackwork");
        this.tipoTatuaje.save(blackwork);

        TipoTatuaje cartoon = new TipoTatuaje("cartoon");
        this.tipoTatuaje.save(cartoon);

        TipoTatuaje japones = new TipoTatuaje("japones");
        this.tipoTatuaje.save(japones);

        //Personal
        Personal p1 = new Personal("Lola", "Perez ", "48123453C", "652972588", "Mañana", realista);
        this.personal.save(p1);
        //Personal p2 = new Personal("Alicia", "Martín Duran", "78476356Q", "647839012", "Tarde", realista);
        //this.personal.save(p2);
        Personal p3 = new Personal("Maria", "Navas Garcia", "78367190V", "659825187", "Mañana", oldSchool);
        this.personal.save(p3);
        //Personal p4 = new Personal("Clara", "Cabeza Rodriguez", "39078654B", "683619365", "Tarde", oldSchool);
        //this.personal.save(p4);
        Personal p5 = new Personal("Alvaro", "Cuevas", "67947297B", "790378210", "Mañana", blackwork);
        this.personal.save(p5);
        //Personal p6 = new Personal("Marco", "Toledo Alvarez", "78309875Q", "678301789", "Tarde", blackwork);
        //this.personal.save(p6);
        Personal p7 = new Personal("Jose", "Navas Ruiz", "78356710E", "673890356", "Tarde", cartoon);
        this.personal.save(p7);
        Personal p8 = new Personal("Julian", "Perez Moreno", "93781098U", "736174560", "Mañana", japones);
        this.personal.save(p8);


        //Productos
        List<Producto> listado = Arrays.asList
                (new Producto("Crema bephantol", 10.0f, "Bepanthol Tattoo es la fórmula experta para el cuidado específico de la piel tatuada, tanto para tatuajes recientes como antiguos; hidrata y repara la piel, preservando la belleza del tatuaje", "https://s2.qwant.com/thumbr/0x380/d/0/f8f420eba84bda8a99335fdfa1bcfcb64d77789ead413ab25d7607cb0427d5/s-l400.jpg?u=https%3A%2F%2Fi.ebayimg.com%2Fimages%2Fg%2FD2UAAOSwUwFaLA9C%2Fs-l400.jpg&q=0&b=1&p=0&a=0"),
                new Producto("UNGÜENTO con DEXPANTHENOL Y DMAE", 34.90f, "Se utiliza desde el primer día y le ayudará a mantener su belleza original a lo largo del tiempo. Su doble acción al inicio actua con un efecto calmante facilitando la curación, aplique la pomada sobre la piel recién tatuada al menos dos veces al día.", "https://canubis-shop.com/wp-content/uploads/2019/09/Etiqueta-Tattoo-30ml.jpg"),
                new Producto("Vaselina Flavour Tattoo aroma Tropical", 7.0f, "Se aplica antes, durante y tras finalizar el tatuaje. Gracias a nuestras vaselinas, se logra una mayor facilidad en el proceso, ya que tiene un efecto calmante sobre la piel y ayuda a que esté hidratada, con esto logramos que el proceso sea mucho más sencillo para todos", "https://flavourtattoo.com/wp-content/uploads/2021/10/Tropical75ml-scaled-800x800.jpg"),
                new Producto("Kit Vaselina 75 ml + Butter 50 ml + Foam 110 ml", 20.0f, "Kits de espuma, vaselina y mantequillas ", "https://flavourtattoo.com/wp-content/uploads/2021/10/kit-vaselina-75-ml-butter-50-ml-foam-110-ml-para-tatuajes-flavour-diferentes-aromas-4.jpg"),
                new Producto("Spray INK-EEZE", 15.0f, "Spray curativo. Con una mínima presión puede estar hidratado sin necesidad de un producto espeso que puede obstruir sus poros. El aerosol incluye vitaminas A, C y E, soja, girasol, avena, pepino, té verde, arándano, almendra dulce y extracto de granada, que, vaporizadas, le evitan frotar para alcanzar un alivio absoluto del dolor del tatuaje", "https://www.killerinktattoo.es/media/catalog/product/cache/df744ff28494f4cf709e9aa273072ef3/i/n/inke-healspary80.jpg"),
                new Producto("Kit Curacion Tatuajes Hidrogel Skinlock", 59.99f, "SkinLock es un líquido sellador que instantáneamente se fija en la tinta y proteje la integridad del tatuaje recién terminado. Una rociada de SkinLock sustituye todos los vendajes sucios y las envolturas de plástico. No comprometa su tinta, protéjala desde el principio con SkinLock.", "https://www.killerinktattoo.es/media/catalog/product/cache/df744ff28494f4cf709e9aa273072ef3/s/k/skinlock_3.jpg"),
                new Producto("DERMALIZE PRO ROLL ", 36.30f, "El uso de Dermalize hace que proteja del exterior y que el tatuaje cure de dentro a fuera, manteniendo la humedad de la piel y haciendo que se regenere de forma fácil y segura, garantizando a los artistas una perfecta curación del tatuaje y mantiene el brillo de los colores una vez curados.", "https://www.vegatattoosupplies.com/2502-large_default/dermalize-pro-roll-rollo-de-15cm-x-10m.jpg"),
                new Producto("GREEN SOAP FOAM ALOE TATTOO", 9.68f, "Es una solucion jabonosa de alta calidad sin sulfatos ni PEG. Muy suave para con la piel y con gran poder de limpieza de tintas, para utilizar directamente y sin diluir durante el proceso del tatuaje. ", "https://www.vegatattoosupplies.com/2223-large_default/green-soap-foam-aloe-tattoo-220ml.jpg"),
                new Producto("SPRAY AFTER TATTOO HORNET ", 4.30f, "Hara de tu cuaracion una de las experiencioas mas comodas, agradables y limpias. Fabricado con miel, aprovechando cada una de sus propiedades y manteniendo simpre ese aroma a miel suave. Pulverizar a 20cm para que pueda crear una capa protectora y dejar hasta su absorcion ", "https://www.vegatattoosupplies.com/5652-large_default/hustle-butter-5oz.jpg")
                );

        listado.forEach(productoServicio::insertar);
    }
}







